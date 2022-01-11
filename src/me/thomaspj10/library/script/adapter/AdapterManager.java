package me.thomaspj10.library.script.adapter;

import java.util.ArrayList;

public class AdapterManager {

	private static final ArrayList<IReturnTypeAdapter<Object, ? extends IAdaptable<?>>> adapters = new ArrayList<>();
	
	/**
	 * Register a new Adapter.
	 * @param adapter
	 */
	public static void register(IReturnTypeAdapter<Object, ? extends IAdaptable<?>> adapter) {
		adapters.add(adapter);
	}
	
	/**
	 * Clear all the registered adapters.
	 */
	public static void clear() {
		adapters.clear();
	}
	
	/**
	 * Transforms an object into an IAdaptable allowing the object to be two classes at the same time.
	 * @param object
	 * @return the IAdaptable or null when this object cannot be adapted.
	 */
	public static IAdaptable<?> transform(Object object) {
		for (IReturnTypeAdapter<Object, ? extends IAdaptable<?>> adapter : adapters) {
			if (adapter.getFromType() == object.getClass())
				return adapter.transform(object);
		}
		
		return null;
	}

}
