package me.thomaspj10.library.executor.instruction;

import java.util.ArrayList;
import java.util.List;

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
			previous = instruction.execute(variableManager, previous);
		}
		
		return previous;
	}
	
}
