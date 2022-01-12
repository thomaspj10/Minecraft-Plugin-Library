package me.thomaspj10.library.entity;

import java.util.ArrayList;

import me.thomaspj10.library.event.IEventListener;

public abstract class AEntity<EventType> implements IEventListener<EventType>, IDisposable {

	private static final ArrayList<AEntity<?>> entities = new ArrayList<>();
	
	/**
	 * 
	 * @param identifier
	 * @param type
	 * @return the AEntity which matches the identifier. Returns null if none exist.
	 */
	public static AEntity<?> getEntityByIdentifier(Object identifier, Class<?> type) {
		if (identifier == null)
			return null;
		
		for (AEntity<?> entity : entities) {
			if (entity.matchesIdentifier(identifier))
				return entity;
		}
		
		return null;
	}
	
	private ArrayList<Flag<?>> flags = new ArrayList<>();
	
	public AEntity() {
		entities.add(this);
	}
	
	@Override
	public void dispose() {
		AEntity.entities.remove(this);
	}
	
	/**
	 * Set the value of a flag. Usefull for keeping track of state data.
	 * @param <T>
	 * @param name
	 * @param value
	 * @param type
	 */
	public <T> void setFlag(String name, T value, Class<T> type) {
		this.flags.removeIf(f -> f.getName().equals(name));
		this.flags.add(new Flag<T>(name, value, type));
	}
	
	/**
	 * Get the value of a flag by name.
	 * @param <T>
	 * @param name
	 * @param type
	 * @return the value of the flag or null if the flag does not exist.
	 */
	@SuppressWarnings("unchecked")
	public <T> T getFlag(String name, Class<T> type) {
		for (Flag<?> flag : this.flags) {
			if (flag.getName().equals(name) && flag.getType() == type)
				return (T) flag.getValue();
		}
		return null;
	}
	
	/**
	 * In order to track AEntities an identifier must be specified. 
	 * @param identifier
	 * @return true of the identifier matches the specified identifier.
	 */
	protected abstract boolean matchesIdentifier(Object identifier);
	
}
