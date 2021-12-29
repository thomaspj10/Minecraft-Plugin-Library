package me.thomaspj10.library.command;

import java.lang.reflect.Field;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import me.thomaspj10.library.Main;
import me.thomaspj10.library.event.IEventListener;

public class ACommand implements IEventListener<ACommandExecuteEvent> {

	private ACommandListener listener;
	private String command;
	
	private Predicate<ACommandExecuteEvent> filter = e -> {
		return e.getCommand() == this.command;
	};
	
	public ACommand(String command, String description, String usageMessage) {
		this.listener = new ACommandListener(command);
		this.command = command;
	
		this.listener.setDescription(description);
		this.listener.setUsage(usageMessage);
		
		// Register the command.
		try {
			final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
			bukkitCommandMap.setAccessible(true);
			
			CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
			commandMap.register(command, listener);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public <T extends ACommandExecuteEvent> void on(Class<T> clazz, Consumer<T> callback) {
		Main.eventManager.register(clazz, callback, this.filter);
	}
	
	class ACommandListener extends BukkitCommand {
		
		private String name;

		protected ACommandListener(String name) {
			super(name);
			this.name = name;
		}

		@Override
		public boolean execute(CommandSender sender, String alias, String[] args) {
			ACommandExecuteEvent event = new ACommandExecuteEvent(this.name, sender, alias, args);
			
			Main.eventManager.execute(ACommandExecuteEvent.class, event);
			
			return true;
		}
		
	}
	
}
