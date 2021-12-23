package me.thomaspj10.library.events;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EventManager {

	private CopyOnWriteArrayList<RegisteredEvent<?, ?>> registeredEvents = new CopyOnWriteArrayList<>();
	
	public <T, S> void register(Class<T> clazz, Consumer<T> callback, Predicate<S> filter) {
		RegisteredEvent<T, S> eventRegister = new RegisteredEvent<T, S>(clazz, callback, filter);
		
		this.registeredEvents.add(eventRegister);
	}
	
	public <T> void register(Class<T> clazz, Consumer<T> callback) {
		this.register(clazz, callback, e -> {
			return true;
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> void execute(Class<? extends T> clazz, T event) {
		for (RegisteredEvent eventRegister : this.registeredEvents) {
			if (eventRegister.getEventClass() != clazz) 
				continue;
			
			if (!eventRegister.isValidEvent(event))
				continue;
			
			eventRegister.execute(event);
		}
	}
	
}
