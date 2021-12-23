package me.thomaspj10.library.inventory.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryInteractEvent;

import me.thomaspj10.library.inventory.AInventory;

public class AInventoryEvent extends Event {

	private InventoryInteractEvent event;
	private AInventory inventory;
	private Player player;
	
	public AInventoryEvent(InventoryInteractEvent event, AInventory inventory, Player player) {
		this.event = event;
		this.inventory = inventory;
		this.player = player;
	}

	public AInventory getInventory() {
		return this.inventory;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void setCancelled(boolean toCancel) {
		this.event.setCancelled(toCancel);
	}
	
	public boolean isCancelled() {
		return this.event.isCancelled();
	}

	@Override
	public HandlerList getHandlers() {
		return null;
	}
	
}
