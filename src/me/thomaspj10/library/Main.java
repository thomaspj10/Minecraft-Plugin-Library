package me.thomaspj10.library;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import me.thomaspj10.library.events.EventManager;
import me.thomaspj10.library.events.listeners.BlockEventListener;
import me.thomaspj10.library.events.listeners.EntityEventListener;
import me.thomaspj10.library.events.listeners.InventoryEventListener;
import me.thomaspj10.library.events.listeners.PlayerEventListener;

public class Main extends JavaPlugin {

	public static final EventManager eventManager = new EventManager();
	public static Gson gson;
	public static Main singleton;
	
	@Override
	public void onEnable() {
		singleton = this;
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gson = gsonBuilder.create();
		
		getServer().getPluginManager().registerEvents(new PlayerEventListener(eventManager), this);
		getServer().getPluginManager().registerEvents(new BlockEventListener(eventManager), this);
		getServer().getPluginManager().registerEvents(new InventoryEventListener(eventManager), this);
		getServer().getPluginManager().registerEvents(new EntityEventListener(eventManager), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
