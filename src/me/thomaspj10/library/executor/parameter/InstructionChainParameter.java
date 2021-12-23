package me.thomaspj10.library.executor.parameter;

import org.apache.commons.lang.ClassUtils;

import me.thomaspj10.library.executor.instruction.InstructionChain;
import me.thomaspj10.library.executor.variable.VariableManager;

public class InstructionChainParameter implements IParameter {

	private Class<?> clazz;
	private InstructionChain chain;
	
	public InstructionChainParameter(String className, InstructionChain chain) {
		try {
			this.clazz = ClassUtils.getClass(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.chain = chain;
	}
	
	@Override
	public Object getValue(VariableManager variableManager) {
		return this.chain.execute(variableManager);
	}

	@Override
	public Class<?> getType() {
		return this.clazz;
	}
	
}
