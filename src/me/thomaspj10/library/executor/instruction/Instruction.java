package me.thomaspj10.library.executor.instruction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import me.thomaspj10.library.executor.parameter.IParameter;
import me.thomaspj10.library.executor.variable.VariableManager;

public class Instruction {

	private String action;
	private List<IParameter> parameters = new ArrayList<>();
	
	public Instruction(String action) {
		this.action = action;
	}
	
	public void addParameter(IParameter parameter) {
		this.parameters.add(parameter);
	}
	
	public Object execute(VariableManager variableManager, Object previous) {
		try {
			Class<?>[] parameterTypes = new Class[this.parameters.size()];
			Object[] parameterValues = new Object[this.parameters.size()];
			
			for (int i=0; i < this.parameters.size(); i++) {
				IParameter parameter = this.parameters.get(i);
				
				parameterTypes[i] = parameter.getType();
				parameterValues[i] = parameter.getValue(variableManager);
			}
			
			Method method = previous.getClass().getMethod(this.action, parameterTypes);
			
			return method.invoke(previous, parameterValues);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
