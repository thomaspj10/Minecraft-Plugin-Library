package me.thomaspj10.library.event.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewingStandFuelEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.inventory.SmithItemEvent;
import org.bukkit.event.inventory.TradeSelectEvent;

import me.thomaspj10.library.api.inventory.AInventory;
import me.thomaspj10.library.api.inventory.AItem;
import me.thomaspj10.library.entity.AEntity;
import me.thomaspj10.library.event.EventManager;
import me.thomaspj10.library.event.events.ainventory.AInventoryClickEvent;

public class InventoryEventListener implements Listener {

	private EventManager eventManager;
	
	public InventoryEventListener(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	
	@EventHandler
	public void on(BrewingStandFuelEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(CraftItemEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(FurnaceBurnEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(FurnaceExtractEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(FurnaceSmeltEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(InventoryClickEvent event) {
		AInventory inventory = AEntity.getEntityByIdentifier(event.getClickedInventory(), AInventory.class);
		
		if (inventory != null) {			
			AItem item = (AItem) AEntity.getEntityByIdentifier(event.getCurrentItem(), AItem.class);
			
			AInventoryClickEvent e = new AInventoryClickEvent(event, inventory, (Player) event.getWhoClicked(), item, event.getSlot());
			this.eventManager.execute(e.getClass(), e);	
		}
		
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(InventoryCloseEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(InventoryCreativeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(InventoryDragEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(InventoryInteractEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(InventoryMoveItemEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(InventoryOpenEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(InventoryPickupItemEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PrepareAnvilEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PrepareItemCraftEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PrepareSmithingEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(SmithItemEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(TradeSelectEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
}
