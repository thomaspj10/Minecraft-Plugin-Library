package me.thomaspj10.library.script.parameter;

import me.thomaspj10.library.script.variable.VariableManager;

public interface IParameter {
	
	/**
	 * 
	 * @param variableManager
	 * @return evaluates the value of the parameter.
	 */
	public Object getValue(VariableManager variableManager);
	
	/**
	 * 
	 * @return the type of the parameter.
	 */
	public Class<?> getType();
	
}
