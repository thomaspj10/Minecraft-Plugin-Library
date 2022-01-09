package me.thomaspj10.library.executor;

import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import me.thomaspj10.library.entity.AEntity;
import me.thomaspj10.library.entity.ConstructableAEntity;

public class Script {
	
	private String name;
	
	private ArrayList<ConstructableAEntity> entities = new ArrayList<>();
	
	public Script(JsonObject json) {
		this.name = json.get("name").getAsString();
		
		// Load the entities.
		for (JsonElement entityElement : json.get("entities").getAsJsonArray()) {
			JsonObject entityObject = entityElement.getAsJsonObject();
			int id = entityObject.get("id").getAsInt();
			
			ConstructableAEntity constructableAEntity = new ConstructableAEntity(
					id,
					entityObject.get("target").getAsString(),
					entityObject.get("result").getAsString(),
					entityObject.get("data").getAsJsonObject()
				);
			
			// Load the listeners.
			for (JsonElement listenerElement : json.get("listeners").getAsJsonArray()) {
				JsonObject listenerObject = listenerElement.getAsJsonObject();
				
				int entityId = listenerObject.get("entity").getAsInt();
				
				if (entityId == id) {
					CommandExecutor executor = new CommandExecutor(listenerObject);
					constructableAEntity.addListener(executor);
				}
			}

			this.entities.add(constructableAEntity);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public AEntity<?> getUniqueAEntityById(int id) {
		for (ConstructableAEntity constructableAEntity : this.entities) {
			if (constructableAEntity.getId() == id)
				return constructableAEntity.construct();
		}
		
		return null;
	}

}
