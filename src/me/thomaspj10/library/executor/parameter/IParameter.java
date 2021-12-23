package me.thomaspj10.library.executor.parameter;

import me.thomaspj10.library.executor.variable.VariableManager;

public interface IParameter {

	public Object getValue(VariableManager variableManager);
	
	public Class<?> getType();
	
}
