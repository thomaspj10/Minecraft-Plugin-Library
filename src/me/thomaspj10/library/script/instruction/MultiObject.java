package me.thomaspj10.library.script.instruction;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MultiObject {

	private ArrayList<Object> objects = new ArrayList<>();
	
	public MultiObject(Object object) {
		this.objects.add(object);
	}
	
	public void addObject(Object object) {
		this.objects.add(object);
	}
	
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
		
		public Object getObject() {
			return this.object;
		}
		
		public Method getMethod() {
			return this.method;
		}
		
	}
	
}
