package me.thomaspj10.library.executor.variable;

import java.util.ArrayList;
import java.util.List;

public class VariableManager {

	private List<Variable> variables = new ArrayList<>();
	
	public VariableManager() {
		
	}
	
	public void reset() {
		this.variables.clear();
	}
	
	public void set(String name, Object value) {
		Variable variable = this.get(name);
		if (variable != null) {
			variable.setValue(value);
			return;
		}
		
		this.variables.add(new Variable(name, value));
	}
	
	public Variable get(String name) {
		for (Variable variable : this.variables) {
			if (variable.getName().equals(name))
				return variable;
		}
		
		return null;
	}
	
	public boolean has(String name) {
		return this.get(name) != null;
	}
	
}
