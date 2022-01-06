package me.thomaspj10.library.event.entity;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import com.google.gson.JsonObject;

import me.thomaspj10.library.ClassBuilder;
import me.thomaspj10.library.Logger;
import me.thomaspj10.library.Logger.LogType;
import me.thomaspj10.library.executor.CommandExecutor;

public class ConstructableAEntity {

	private int id;
	private String target;
	private JsonObject data;
	
	private ArrayList<CommandExecutor> listeners = new ArrayList<>();
	
	public ConstructableAEntity(int id, String target, String result, JsonObject data) {
		this.id = id;
		this.target = target;
		this.data = data;
	}
	
	public void addListener(CommandExecutor executor) {
		this.listeners.add(executor);
	}
	
	public int getId() {
		return this.id;
	}
	
	public AEntity<?> construct() {
		try {
			Class<?> builderCls = Class.forName(this.target);
			
			if (!ClassBuilder.class.isAssignableFrom(builderCls)) {
				Logger.log(LogType.SEVERE, "The class " + this.target + " does not inherit from the ClassBuilder superclass");
				return null;
			}
			
			AEntity<?> entity = (AEntity<?>) ((ClassBuilder<?>) builderCls.getDeclaredConstructor().newInstance())
					.json(this.data)
					.build();
			
			for (CommandExecutor executor : this.listeners)
				executor.register(entity);
			
			return entity;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
