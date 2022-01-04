package me.thomaspj10.library.executor.instruction;

import java.util.ArrayList;
import java.util.List;

import me.thomaspj10.library.Logger;
import me.thomaspj10.library.Logger.LogType;
import me.thomaspj10.library.executor.variable.VariableManager;

public class InstructionChain {

	private List<Instruction> instructions = new ArrayList<>();
	private String base;
	
	public InstructionChain(String base) {
		this.base = base;
	}
	
	public void addInstruction(Instruction instruction) {
		this.instructions.add(instruction);
	}
	
	public Object execute(VariableManager variableManager) {
		Object previous = variableManager.get(base).getValue();
		for (Instruction instruction : this.instructions) {
			// Perform a null check to prevent unwanted calls to null objects.
			if (previous == null) {
				Logger.log(LogType.WARN, "InstructionChain attempted to call a method on a null object.");
				return null;
			}
			
			previous = instruction.execute(variableManager, previous);
		}
		
		return previous;
	}
	
}
