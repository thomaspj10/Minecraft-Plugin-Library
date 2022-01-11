package me.thomaspj10.library.script.instruction;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import me.thomaspj10.library.Logger;
import me.thomaspj10.library.Logger.LogType;
import me.thomaspj10.library.script.adapter.AdapterManager;
import me.thomaspj10.library.script.adapter.IAdaptable;
import me.thomaspj10.library.script.instruction.MultiObject.MethodResult;
import me.thomaspj10.library.script.parameter.IParameter;
import me.thomaspj10.library.script.variable.VariableManager;

public class Instruction {

	private String action;
	private List<IParameter> parameters = new ArrayList<>();
	
	public Instruction(String action) {
		this.action = action;
	}
	
	public void addParameter(IParameter parameter) {
		this.parameters.add(parameter);
	}
	
	public MultiObject execute(VariableManager variableManager, MultiObject previous) {
		try {
			Class<?>[] parameterTypes = new Class[this.parameters.size()];
			Object[] parameterValues = new Object[this.parameters.size()];
			
			for (int i=0; i < this.parameters.size(); i++) {
				IParameter parameter = this.parameters.get(i);
				
				parameterTypes[i] = parameter.getType();
				parameterValues[i] = parameter.getValue(variableManager);
			}
			
			MethodResult methodResult = previous.getMethod(this.action, parameterTypes);
			
			if (methodResult.getMethod() == null)
				Logger.log(LogType.SEVERE, "The method '" + this.action + "' does not exist on the object.");
			
			Object object = methodResult.getMethod().invoke(methodResult.getObject(), parameterValues);
			MultiObject returnObject = new MultiObject(object);
			
			// Attempt to adapt the result.
			IAdaptable<?> adaptable = AdapterManager.transform(object);
			
			if (adaptable != null) {
				returnObject = new MultiObject(adaptable);
				returnObject.addObject(adaptable.getBase());
			}
				
			return returnObject;
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
