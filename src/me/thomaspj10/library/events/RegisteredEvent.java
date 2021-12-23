package me.thomaspj10.library.events;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class RegisteredEvent<T, S> {

	private Class<T> clazz;
	private Consumer<T> callback;
	private Predicate<S> filter;
	
	protected RegisteredEvent(Class<T> clazz, Consumer<T> callback, Predicate<S> filter) {
		this.clazz = clazz;
		this.callback = callback;
		this.filter = filter;
	}
	
	public Class<T> getEventClass() {
		return this.clazz;
	}
	
	public void execute(T event) {
		this.callback.accept(event);
	}
	
	public boolean isValidEvent(S event) {
		return this.filter.test(event);
	}
	
}
