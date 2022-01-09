package me.thomaspj10.library.entity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import com.google.gson.JsonObject;

import me.thomaspj10.library.Logger;
import me.thomaspj10.library.Logger.LogType;
import me.thomaspj10.library.builder.ClassBuilder;
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
			
			// Ensure that the target class is a ClassBuilder
			if (!ClassBuilder.class.isAssignableFrom(builderCls)) {
				Logger.log(LogType.SEVERE, "The class " + this.target + " does not inherit from the ClassBuilder superclass");
				return null;
			}
			
			// Ensure that the generic type of the class builder inherits from AEntity.
			ParameterizedType builderClassGenericType = (ParameterizedType) builderCls.getGenericSuperclass();
	        Class<?> builderClassGenericTypeClass = (Class<?>) builderClassGenericType.getActualTypeArguments()[0];
	        if (!AEntity.class.isAssignableFrom(builderClassGenericTypeClass)) {
				Logger.log(LogType.SEVERE, "The class " + this.target + " does not return an Aentity");
				return null;
	        }
			
	        // Build the entity.
			AEntity<?> entity = (AEntity<?>) ((ClassBuilder<?>) builderCls.getDeclaredConstructor().newInstance())
					.json(this.data)
					.build();
			
			// Add the listeners to the entity.
			for (CommandExecutor executor : this.listeners)
				executor.register(entity);
			
			return entity;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
