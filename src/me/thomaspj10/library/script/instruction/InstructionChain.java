package me.thomaspj10.library.script.instruction;

import java.util.ArrayList;
import java.util.List;

import me.thomaspj10.library.Logger;
import me.thomaspj10.library.Logger.LogType;
import me.thomaspj10.library.script.variable.VariableManager;

public class InstructionChain {

	private List<Instruction> instructions = new ArrayList<>();
	private String base;
	
	public InstructionChain(String base) {
		this.base = base;
	}
	
	/**
	 * Add an instruction to the chain.
	 * @param instruction
	 */
	public void addInstruction(Instruction instruction) {
		this.instructions.add(instruction);
	}
	
	/**
	 * Execute the instruction chain.
	 * @param variableManager
	 * @return the MultiObject at the end of the chain.
	 */
	public MultiObject execute(VariableManager variableManager) {
		MultiObject previous = new MultiObject(variableManager.get(base).getValue());
		
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
