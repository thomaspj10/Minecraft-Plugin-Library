package me.thomaspj10.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import me.thomaspj10.library.event.EventManager;
import me.thomaspj10.library.event.listeners.BlockEventListener;
import me.thomaspj10.library.event.listeners.EntityEventListener;
import me.thomaspj10.library.event.listeners.InventoryEventListener;
import me.thomaspj10.library.event.listeners.PlayerEventListener;
import me.thomaspj10.library.executor.CommandExecutor;

public class Main extends JavaPlugin {

	public static final EventManager eventManager = new EventManager();
	public static PluginLibrary library;
	
	public static Gson gson;
	public static Main singleton;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		library = new PluginLibrary(null);
		gson = new GsonBuilder().create();
		
		StringBuilder result = new StringBuilder();
		URL url = new URL("http://localhost/plugin-library-web/examples/event.json");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
			for (String line; (line = reader.readLine()) != null; ) {
				result.append(line);
			}
		}
		
		JsonObject json = gson.fromJson(result.toString(), JsonObject.class);
		CommandExecutor executor = new CommandExecutor(json);
		
		TestPlayer testPlayer = new TestPlayer();
		
		PlayerMoveEvent pme = new PlayerMoveEvent(testPlayer, null, null);
		
		System.out.println(pme.isCancelled());
		
		eventManager.execute(PlayerMoveEvent.class, pme);
		
		System.out.println(pme.isCancelled());
	}
	
	@Override
	public void onEnable() {
		singleton = this;
		library = new PluginLibrary(this);
		
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
