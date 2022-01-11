package me.thomaspj10.library.script.variable;

public class Variable {
	
	private String name;
	private Object value;
	
	public Variable(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * 
	 * @return the name of the variable.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return the value of the variable.
	 */
	public Object getValue() {
		return this.value;
	}
	
	/**
	 * 
	 * @return the type of the variable.
	 */
	public Class<?> getType() {
		return this.value.getClass();
	}
	
	/**
	 * Sets the current value to the new value.
	 * @param value
	 */
	public void setValue(Object value) {
		this.value = value;
	}

}
