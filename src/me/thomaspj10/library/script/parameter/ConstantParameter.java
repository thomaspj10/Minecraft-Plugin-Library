package me.thomaspj10.library.script.parameter;

import org.apache.commons.lang.ClassUtils;

import me.thomaspj10.library.script.variable.VariableManager;

public class ConstantParameter implements IParameter {

	private Class<?> clazz;
	private Object value;
	
	public ConstantParameter(String className, Object value) {
		try {
			this.clazz = ClassUtils.getClass(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.value = value;
	}

	public Object getValue(VariableManager variableManager) {
		return this.value;
	}

	@Override
	public Class<?> getType() {
		return this.clazz;
	}
	
}
