package me.thomaspj10.library.data;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class Context extends Data {

	private String getName() {
		return getClass().getSimpleName();
	}
	
	public void save(JavaPlugin plugin) {
		plugin.getDataFolder().mkdirs();
		File file = new File(plugin.getDataFolder().getAbsolutePath() + "/" + this.getName() + ".yml");
		this.save(file);
	}
	
	public void load(JavaPlugin plugin) {
		plugin.getDataFolder().mkdirs();
		File file = new File(plugin.getDataFolder().getAbsolutePath() + "/" + this.getName() + ".yml");
		this.load(file);
	}
	
}
