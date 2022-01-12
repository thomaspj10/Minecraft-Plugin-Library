package me.thomaspj10.library.entity;

public class Flag<T> {

	private String name;
	private T value;
	private Class<T> type;
	
	public Flag(String name, T value, Class<T> type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}
	
	/**
	 * 
	 * @return the name of this flag.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return the value of this flag.
	 */
	public T getValue() {
		return this.value;
	}
	
	/**
	 * 
	 * @return the type of this flag.
	 */
	public Class<T> getType() {
		return this.type;
	}
	
}
