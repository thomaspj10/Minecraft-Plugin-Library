package me.thomaspj10.library.entity;

import java.util.ArrayList;

import me.thomaspj10.library.event.IEventListener;

public abstract class AEntity<EventType> implements IEventListener<EventType> {

	private static final ArrayList<AEntity<?>> entities = new ArrayList<>();
	
	public static AEntity<?> getEntityByIdentifier(Object identifier, Class<?> type) {
		if (identifier == null)
			return null;
		
		for (AEntity<?> entity : entities) {
			if (entity.matchesIdentifier(identifier))
				return entity;
		}
		
		return null;
	}
	
	public AEntity() {
		entities.add(this);
	}
	
	protected abstract boolean matchesIdentifier(Object identifier);
	
}
