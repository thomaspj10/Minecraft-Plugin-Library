package me.thomaspj10.library;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.function.Consumer;

import org.bukkit.ChatColor;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

import me.thomaspj10.library.command.ACommand;
import me.thomaspj10.library.command.ACommandExecuteEvent;
import me.thomaspj10.library.data.Context;
import me.thomaspj10.library.events.IEventListener;

public class PluginLibrary implements IEventListener<Event> {
	
	private JavaPlugin plugin;
	
	private ArrayList<Context> availableContexts = new ArrayList<>();
	
	public PluginLibrary(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * Register a new Context. Must be done at the start of the Plugin.
	 * @param <T>
	 * @param clazz
	 */
	public <T extends Context> void registerContext(Class<T> clazz) {
		try {
			T context = clazz.getConstructor().newInstance();
			context.load(this.plugin);
			
			this.availableContexts.add(context);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get a Context based on the class.
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public <T extends Context> T getContext(Class<T> clazz) {
		for (Context context : this.availableContexts) {
			if (context.getClass() == clazz)
				return clazz.cast(context);
		}
		
		return null;
	}
	
	/**
	 * Changes the color codes into a String which can be used in the Spigot api.
	 * @param str
	 * @return
	 */
	public String color(String str) {
		return ChatColor.translateAlternateColorCodes('&', str);
	}
	
	/**
	 * Create a new command listener.
	 * @param command
	 * @param description
	 * @param usage
	 * @param callback
	 */
	public void onCommand(String command, String description, String usage, Consumer<ACommandExecuteEvent> callback) {
		new ACommand(command, description, usage).on(ACommandExecuteEvent.class, callback);
	}

	@Override
	public <T extends Event> void on(Class<T> clazz, Consumer<T> callback) {
		Main.eventManager.register(clazz, callback, e -> {
			return true;
		});
	}
	
}
