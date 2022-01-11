package me.thomaspj10.library.script.instruction;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MultiObject {

	private ArrayList<Object> objects = new ArrayList<>();
	
	public MultiObject(Object object) {
		this.objects.add(object);
	}
	
	/**
	 * Add an object to the end of the options.
	 * @param object
	 */
	public void addObject(Object object) {
		this.objects.add(object);
	}
	
	/**
	 * Get a method by name and parameterTypes. Goes through the objects in order.
	 * @param name
	 * @param parameterTypes
	 * @return the MethodResult if the method exists, otherwise returns null.
	 */
	public MethodResult getMethod(String name, Class<?>[] parameterTypes) {
		for (Object object : this.objects) {
			try {
				return new MethodResult(object, object.getClass().getMethod(name, parameterTypes));
			} catch (NoSuchMethodException e) {
				
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	class MethodResult {
		
		private Object object;
		private Method method;
		
		public MethodResult(Object object, Method method) {
			this.object = object;
			this.method = method;
		}
		
		/**
		 * 
		 * @return the object.
		 */
		public Object getObject() {
			return this.object;
		}
		
		/**
		 * 
		 * @return the method.
		 */
		public Method getMethod() {
			return this.method;
		}
		
	}
	
}
