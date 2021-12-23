package me.thomaspj10.library.events.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.thomaspj10.library.events.EventManager;
import me.thomaspj10.library.inventory.AInventory;
import me.thomaspj10.library.inventory.AItem;
import me.thomaspj10.library.inventory.events.AInventoryClickEvent;

public class InventoryEventListener implements Listener {

	private EventManager eventManager;
	
	public InventoryEventListener(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	
	@EventHandler
	public void on(InventoryClickEvent event) {
		AInventory inventory = AInventory.match(event.getClickedInventory());
		
		if (inventory != null) {			
			AItem item = event.getCurrentItem() != null ? new AItem(event.getCurrentItem()) : null;
			
			AInventoryClickEvent e = new AInventoryClickEvent(event, inventory, (Player) event.getWhoClicked(), item, event.getSlot());
			this.eventManager.execute(e.getClass(), e);	
		}
	}
	
}
