package me.thomaspj10.library.event;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.bukkit.event.Event;

public class EventManager {

	private CopyOnWriteArrayList<RegisteredEvent<?, ?>> registeredEvents = new CopyOnWriteArrayList<>();
	
	public <T, S> void register(Class<T> clazz, Consumer<T> callback, Predicate<S> filter) {
		RegisteredEvent<T, S> eventRegister = new RegisteredEvent<T, S>(clazz, callback, filter);
		
		this.registeredEvents.add(eventRegister);
	}
	
	/**
	 * Register a new event listener to an event class.
	 * @param <T>
	 * @param clazz The class to listen for.
	 * @param callback The callback function.
	 */
	public <T> void register(Class<T> clazz, Consumer<T> callback) {
		this.register(clazz, callback, e -> {
			return true;
		});
	}
	
	/**
	 * Execute an event by class type and instance.
	 * @param <T>
	 * @param clazz
	 * @param event
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T extends Event> void execute(Class<? extends T> clazz, T event) {
		for (RegisteredEvent eventRegister : this.registeredEvents) {
			if (eventRegister.getEventClass() != clazz) 
				continue;
			
			if (!eventRegister.isValidEvent(event))
				continue;
			
			eventRegister.execute(event);
		}
	}
	
}
