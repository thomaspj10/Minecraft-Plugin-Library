package me.thomaspj10.library.api.inventory;

import java.util.function.Predicate;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.thomaspj10.library.entity.AEntity;
import me.thomaspj10.library.event.events.ainventory.AInventoryEvent;

public class AInventory extends AEntity<AInventoryEvent> {
	
	private Inventory inventory;
	
	public AInventory(String name, int size) {
		this.inventory = Bukkit.createInventory(null, size, name);
	}
	
	@Override
	public Predicate<AInventoryEvent> getFilter() {
		return e -> {
			return e.getInventory() == this;
		};
	}
	
	@Override
	protected boolean matchesIdentifier(Object identifier) {
		return this.inventory == identifier;
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
