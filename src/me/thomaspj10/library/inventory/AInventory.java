package me.thomaspj10.library.inventory;

import java.util.ArrayList;
import java.util.function.Predicate;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.thomaspj10.library.event.IEventListener;
import me.thomaspj10.library.event.events.ainventory.AInventoryEvent;

public class AInventory implements IEventListener<AInventoryEvent> {

	private static ArrayList<AInventory> inventories = new ArrayList<>();
	
	private Inventory inventory;
	
	public AInventory(String name, int size) {
		this.inventory = Bukkit.createInventory(null, size, name);
		
		inventories.add(this);
	}
	
	@Override
	public Predicate<AInventoryEvent> getFilter() {
		return e -> {
			return e.getInventory() == this;
		};
	}
	
	public static AInventory match(Inventory inventory) {
		for (AInventory AInventory : inventories) {
			if (AInventory.inventory == inventory)
				return AInventory;
		}
		
		return null;
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
