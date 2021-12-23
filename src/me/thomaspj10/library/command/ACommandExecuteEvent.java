package me.thomaspj10.library.command;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ACommandExecuteEvent extends Event {

	@Override
	public HandlerList getHandlers() {
		return null;
	}

	private String command;
	private CommandSender sender;
	private String alias;
	private String[] args;
	
	public ACommandExecuteEvent(String command, CommandSender sender, String alias, String[] args) {
		this.command = command;
		this.sender = sender;
		this.alias = alias;
		this.args = args;
	}
	
	public String getCommand() {
		return this.command;
	}
	
	public CommandSender getSender() {
		return this.sender;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public String[] getArgs() {
		return this.args;
	}
	
}
