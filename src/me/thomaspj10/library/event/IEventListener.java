package me.thomaspj10.library.event;

import java.util.function.Consumer;
import java.util.function.Predicate;

import me.thomaspj10.library.Main;

public interface IEventListener<S> {
	
	/**
	 * Returns the filter the EventListener has to adhere by.
	 * @return
	 */
	public Predicate<S> getFilter();

	/**
	 * Register a new event listener.
	 * @param <T>
	 * @param clazz
	 * @param callback
	 */
	public default <T extends S> void on(Class<T> clazz, Consumer<T> callback) {
		Main.eventManager.register(clazz, callback, this.getFilter());
	}
	
}
