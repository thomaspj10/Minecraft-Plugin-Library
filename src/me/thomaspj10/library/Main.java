package me.thomaspj10.library;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import me.thomaspj10.library.events.EventManager;
import me.thomaspj10.library.events.listeners.BlockEventListener;
import me.thomaspj10.library.events.listeners.EntityEventListener;
import me.thomaspj10.library.events.listeners.InventoryEventListener;
import me.thomaspj10.library.events.listeners.PlayerEventListener;
import me.thomaspj10.library.executor.CommandExecutor;
import me.thomaspj10.library.inventory.AInventory;
import me.thomaspj10.library.inventory.AItem;
import me.thomaspj10.library.inventory.builder.AInventoryBuilder;
import me.thomaspj10.library.inventory.events.AInventoryClickEvent;

public class Main extends JavaPlugin {

	public static final EventManager eventManager = new EventManager();
	
	public static void main(String args[]) {
		System.out.println("Starting..");
		
		PluginLibrary library = new PluginLibrary(null);
		
		String jsonData = "{ \"event\": \"org.bukkit.event.player.PlayerMoveEvent\", \"commands\": [ { \"base\": \"event\", \"chain\": [ { \"action\": \"setCancelled\", \"parameters\": [ { \"type\": \"constant\", \"className\": \"boolean\", \"value\": true } ] } ] } ] }";
		JsonObject json = new JsonParser().parse(jsonData).getAsJsonObject();
		
		new CommandExecutor(json).register(library);
		
		PlayerMoveEvent event = new PlayerMoveEvent(null, null, null);
		System.out.println(event.isCancelled());
		
		Main.eventManager.execute(PlayerMoveEvent.class, event);
		
		System.out.println(event.isCancelled());
	}
	
	@Override
	public void onEnable() {
		PluginLibrary library = new PluginLibrary(this);
		
		getServer().getPluginManager().registerEvents(new PlayerEventListener(eventManager), this);
		getServer().getPluginManager().registerEvents(new BlockEventListener(eventManager), this);
		getServer().getPluginManager().registerEvents(new InventoryEventListener(eventManager), this);
		getServer().getPluginManager().registerEvents(new EntityEventListener(eventManager), this);
		
		String invStr = "{ \"name\": \"Name of the inventory!\", \"size\": 18, \"items\": [ { \"slot\": 0, \"item\": { \"material\": \"STONE\", \"amount\": 64 } }, { \"slot\": 1, \"item\": { \"material\": \"GRASS\", \"amount\": 1 } } ] }";
		AInventory inventory = new AInventoryBuilder().json(invStr).build();
		
		AItem item = new AItem(Material.DIRT);
		inventory.setItem(5, item);
		
		AItem dirt = new AItem(Material.DIRT);
		inventory.setItem(7, dirt);
		
		item.on(AInventoryClickEvent.class, e -> {
			e.getPlayer().sendMessage("Click registered!");
		});
		
		library.on(PlayerEggThrowEvent.class, e -> {
			inventory.openInventory(e.getPlayer());
		});
		
		library.onCommand("hello", "This is a descrption", "/hello", e -> {
			if (e.getSender() instanceof Player) {
				Player player = (Player) e.getSender();
				
				player.sendMessage("hello player!");
			}
		});
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
