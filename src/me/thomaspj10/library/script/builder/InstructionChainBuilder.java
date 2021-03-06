package me.thomaspj10.library.script.builder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import me.thomaspj10.library.builder.ClassBuilder;
import me.thomaspj10.library.script.instruction.InstructionChain;

public class InstructionChainBuilder extends ClassBuilder<InstructionChain> {

	public InstructionChain build() {
		InstructionChain chain = new InstructionChain(this.getJson().get("base").getAsString());
		
		for (JsonElement instructionElement : this.getJson().get("instructions").getAsJsonArray()) {
			JsonObject instructionObject = instructionElement.getAsJsonObject();
			
			chain.addInstruction(new InstructionBuilder().json(instructionObject).build());
		}
		
		return chain;
	}
	
}
