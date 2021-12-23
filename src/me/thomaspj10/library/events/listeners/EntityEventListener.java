package me.thomaspj10.library.events.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.thomaspj10.library.events.EventManager;

public class EntityEventListener implements Listener {

	private EventManager eventManager;
	
	public EntityEventListener(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	
	@EventHandler
	public void on(PlayerDeathEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
}
