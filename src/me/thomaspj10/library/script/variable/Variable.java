package me.thomaspj10.library.script.variable;

public class Variable {
	
	private String name;
	private Object value;
	
	public Variable(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Object getValue() {
		return this.value;
	}
	
	public Class<?> getType() {
		return this.value.getClass();
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

}
