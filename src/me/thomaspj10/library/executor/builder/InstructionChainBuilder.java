package me.thomaspj10.library.executor.builder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import me.thomaspj10.library.Builder;
import me.thomaspj10.library.executor.instruction.InstructionChain;

public class InstructionChainBuilder extends Builder<InstructionChain, JsonObject> {

	public InstructionChain build() {
		InstructionChain chain = new InstructionChain(this.getJson().get("base").getAsString());
		
		for (JsonElement instructionElement : this.getJson().get("chain").getAsJsonArray()) {
			JsonObject instructionObject = instructionElement.getAsJsonObject();
			
			chain.addInstruction(new InstructionBuilder().json(instructionObject).build());
		}
		
		return chain;
	}
	
}
