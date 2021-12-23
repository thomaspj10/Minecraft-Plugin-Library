package me.thomaspj10.library.events;

import java.util.function.Consumer;

public interface IEventListener<S> {

	/**
	 * Register a new event listener.
	 * @param <T>
	 * @param clazz
	 * @param callback
	 */
	public <T extends S> void on(Class<T> clazz, Consumer<T> callback);
	
}
