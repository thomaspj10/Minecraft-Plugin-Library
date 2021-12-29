package me.thomaspj10.library.inventory;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.thomaspj10.library.Main;
import me.thomaspj10.library.event.IEventListener;
import me.thomaspj10.library.event.events.ainventory.AInventoryEvent;

public class AInventory implements IEventListener<AInventoryEvent> {

	private static ArrayList<AInventory> inventories = new ArrayList<>();
	
	private Inventory inventory;
	
	private Predicate<AInventoryEvent> filter = e -> {
		return e.getInventory() == this;
	};
	
	public AInventory(String name, int size) {
		this.inventory = Bukkit.createInventory(null, size, name);
		
		inventories.add(this);
	}
	
	public static AInventory match(Inventory inventory) {
		for (AInventory AInventory : inventories) {
			if (AInventory.inventory == inventory)
				return AInventory;
		}
		
		return null;
	}
	
	@Override
	public <T extends AInventoryEvent> void on(Class<T> clazz, Consumer<T> callback) {
		Main.eventManager.register(clazz, callback, this.filter);
	}
	
	public int getSize() {
		return this.inventory.getSize();
	}
	
	public AItem getItem(int slot) {
		return this.inventory.getItem(slot) != null ? new AItem(this.inventory.getItem(slot)) : null;
	}
	
	public void openInventory(Player player) {
		player.openInventory(this.inventory);
	}
	
	public void setItem(int slot, AItem item) {
		this.inventory.setItem(slot, item.getItemStack());
	}
	
}
