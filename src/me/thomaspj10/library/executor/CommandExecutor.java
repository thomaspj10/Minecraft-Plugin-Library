package me.thomaspj10.library.executor;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import me.thomaspj10.library.event.IEventListener;
import me.thomaspj10.library.executor.builder.InstructionChainBuilder;
import me.thomaspj10.library.executor.instruction.InstructionChain;
import me.thomaspj10.library.executor.variable.VariableManager;

public class CommandExecutor {
	
	private List<InstructionChain> instructions = new ArrayList<>();
	private VariableManager variableManager = new VariableManager();
	
	private String event;
	private int entityId;
	
	public CommandExecutor(JsonObject json) {	
		this.event = json.get("event").getAsString();
		this.entityId = json.get("entity").getAsInt();
		
		JsonArray commands = json.get("commands").getAsJsonArray();
		
		for (JsonElement command : commands) {
			JsonObject commandObject = command.getAsJsonObject();
			
			InstructionChain chain = new InstructionChainBuilder().json(commandObject).build();
			this.instructions.add(chain);
		}
	}
	
	public int getEntityId() {
		return this.entityId;
	}
	
	public String getEvent() {
		return this.event;
	}
	
	public <T> void register(IEventListener<T> listener) {
		try {
			@SuppressWarnings("unchecked")
			Class<T> clz = (Class<T>) Class.forName(this.event);
			
			listener.<T>on(clz, object -> {
				this.variableManager.reset();
				this.variableManager.set("event", object);
				
				for (InstructionChain chain : this.instructions) {
					chain.execute(this.variableManager);
				}
			});
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
