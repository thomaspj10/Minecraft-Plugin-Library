package me.thomaspj10.library.event.entity;

import java.util.ArrayList;

import me.thomaspj10.library.event.IEventListener;

public abstract class AEntity<EventType> implements IEventListener<EventType> {

	private static final ArrayList<AEntity<?>> entities = new ArrayList<>();
	private static int currentId = 0;
	
	public static AEntity<?> getEntityById(int id) {
		for (AEntity<?> entity : entities) {
			if (entity.getUniqueId() == id)
				return entity;
		}
		
		return null;
	}
	
	public static AEntity<?> getEntityByIdentifier(Object identifier, Class<?> type) {
		if (identifier == null)
			return null;
		
		for (AEntity<?> entity : entities) {
			if (entity.matchesIdentifier(identifier))
				return entity;
		}
		
		return null;
	}

	private static int generateId() {
		currentId = currentId + 1;
		return currentId;
	}
	
	private int id;
	
	public AEntity() {
		id = generateId();
		entities.add(this);
	}
	
	protected int getUniqueId() {
		return this.id;
	}
	
	protected abstract boolean matchesIdentifier(Object identifier);
	
}
