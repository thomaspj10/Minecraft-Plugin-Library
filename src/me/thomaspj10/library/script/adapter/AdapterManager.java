package me.thomaspj10.library.script.adapter;

import java.util.ArrayList;

public class AdapterManager {

	private static final ArrayList<IReturnTypeAdapter<Object, ? extends IAdaptable<?>>> adapters = new ArrayList<>();
	
	public static void register(IReturnTypeAdapter<Object, ? extends IAdaptable<?>> adapter) {
		adapters.add(adapter);
	}
	
	public static void clear() {
		adapters.clear();
	}
	
	public static IAdaptable<?> transform(Object object) {
		for (IReturnTypeAdapter<Object, ? extends IAdaptable<?>> adapter : adapters) {
			if (adapter.getFromType() == object.getClass())
				return adapter.transform(object);
		}
		
		return null;
	}

}
