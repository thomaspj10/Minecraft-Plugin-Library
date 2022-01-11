package me.thomaspj10.library.script.parameter;

import me.thomaspj10.library.script.variable.VariableManager;

public interface IParameter {

	public Object getValue(VariableManager variableManager);
	
	public Class<?> getType();
	
}
