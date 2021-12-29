package me.thomaspj10.library;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {

	private static final LogType minimum = LogType.LOG;
	
	public enum LogType {
		
		LOG("LOG", 1, ChatColor.RESET),
		WARN("WARN", 2, ChatColor.GOLD),
		SEVERE("SEVERE", 3, ChatColor.RED);
		
		private String name;
		private int level;
		private ChatColor color;
		
		LogType(String name, int level, ChatColor color) {
			this.name = name;
			this.level = level;
			this.color = color;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getLevel() {
			return this.level;
		}
		
		public ChatColor getColor() {
			return this.color;
		}
		
	}
	
	public static void log(LogType type, String message) {
		// The message should not be printed because the level is too low.
		if (type.getLevel() < minimum.getLevel()) return;
		
		Bukkit.getServer().getConsoleSender().sendMessage(type.getColor() + "[" + type.getName() + "] " + message);
	}
	
}
