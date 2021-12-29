package me.thomaspj10.library.event.events.ainventory;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryInteractEvent;

import me.thomaspj10.library.inventory.AInventory;
import me.thomaspj10.library.inventory.AItem;

public class AInventoryClickEvent extends AInventoryEvent {

	public AInventoryClickEvent(InventoryInteractEvent event, AInventory inventory, Player player, AItem item, int slot) {
		super(event, inventory, player);
		this.item = item;
		this.slot = slot;
	}

	private AItem item;
	private int slot;
	
	public AItem getItem() {
		return this.item;
	}
	
	public int getSlot() {
		return this.slot;
	}
	
}
