package me.thomaspj10.library.script.variable;

import java.util.ArrayList;
import java.util.List;

public class VariableManager {

	private List<Variable> variables = new ArrayList<>();
	
	public VariableManager() {
		
	}
	
	/**
	 * Clear all the variables.
	 */
	public void reset() {
		this.variables.clear();
	}
	
	/**
	 * Set the value of a variable.
	 * @param name
	 * @param value
	 */
	public void set(String name, Object value) {
		Variable variable = this.get(name);
		if (variable != null) {
			variable.setValue(value);
			return;
		}
		
		this.variables.add(new Variable(name, value));
	}
	
	/**
	 * Get a variable by name.
	 * @param name
	 * @return
	 */
	public Variable get(String name) {
		for (Variable variable : this.variables) {
			if (variable.getName().equals(name))
				return variable;
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param name
	 * @return true if the variable by name exists.
	 */
	public boolean has(String name) {
		return this.get(name) != null;
	}
	
}
