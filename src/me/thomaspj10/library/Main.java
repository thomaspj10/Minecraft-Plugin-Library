package me.thomaspj10.library;

import java.io.IOException;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import me.thomaspj10.library.api.PluginLibrary;
import me.thomaspj10.library.api.inventory.AInventory;
import me.thomaspj10.library.api.player.APlayer;
import me.thomaspj10.library.entity.AEntity;
import me.thomaspj10.library.event.EventManager;
import me.thomaspj10.library.event.listeners.BlockEventListener;
import me.thomaspj10.library.event.listeners.EntityEventListener;
import me.thomaspj10.library.event.listeners.InventoryEventListener;
import me.thomaspj10.library.event.listeners.PlayerEventListener;
import me.thomaspj10.library.script.Script;

public class Main extends JavaPlugin {

	public static final EventManager eventManager = new EventManager();
	public static PluginLibrary library;
	
	public static Gson gson;
	public static Main singleton;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		library = new PluginLibrary(null);
		gson = new GsonBuilder().create();
		
		/*
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
		System.out.println(executor.getEntity());
		
		TestPlayer testPlayer = new TestPlayer();
		PlayerMoveEvent pme = new PlayerMoveEvent(testPlayer, null, null);
		
		eventManager.execute(PlayerMoveEvent.class, pme);
		*/
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
		
		library.on(PlayerJoinEvent.class, e -> {
			new APlayer(e.getPlayer());
		});
		
		library.on(PlayerQuitEvent.class, e -> {
			AEntity.getEntityByIdentifier(e.getPlayer().getUniqueId(), APlayer.class).dispose();
		});
		
		library.on(PlayerMoveEvent.class, e -> {
			String s = "{ \"name\": \"The name of my script..\", \"listeners\": [ { \"entity\": 1, \"event\": \"me.thomaspj10.library.event.events.ainventory.AInventoryClickEvent\", \"commands\": [ { \"base\": \"event\", \"instructions\": [ { \"action\": \"setCancelled\", \"parameters\": [ { \"type\": \"constant\", \"className\": \"boolean\", \"value\": true } ] } ] } ] } ], \"entities\": [ { \"id\": 1, \"target\": \"me.thomaspj10.library.builder.AInventoryBuilder\", \"result\": \"me.thomaspj10.library.api.inventory.AInventory\", \"data\": { \"name\": \"Name of the inventory!\", \"size\": 18, \"items\": [ { \"slot\": 0, \"item\": { \"material\": \"STONE\", \"amount\": 64 } }, { \"slot\": 1, \"item\": { \"material\": \"GRASS\", \"amount\": 1 } } ] } } ] }";
					
			JsonObject json = gson.fromJson(s, JsonObject.class);
			Script script = new Script(json);
			
			AInventory inventory = (AInventory) script.getUniqueAEntityById(1);
			inventory.openInventory(e.getPlayer());
		});
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
