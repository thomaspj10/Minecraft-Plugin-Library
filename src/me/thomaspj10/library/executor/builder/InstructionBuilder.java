package me.thomaspj10.library.executor.builder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import me.thomaspj10.library.ClassBuilder;
import me.thomaspj10.library.executor.instruction.Instruction;
import me.thomaspj10.library.executor.parameter.IParameter;

public class InstructionBuilder extends ClassBuilder<Instruction, JsonObject> {

	public InstructionBuilder() {
		this.setRequiredKeys(new String[] {
			"action", "parameters"
		});
	}
	
	public Instruction build() {
		Instruction instruction = new Instruction(this.getJson().get("action").getAsString());
		
		for (JsonElement parameterElement : this.getJson().get("parameters").getAsJsonArray()) {
			JsonObject parameterObject = parameterElement.getAsJsonObject();
			
			IParameter parameter = new ParameterBuilder().json(parameterObject).build();
			instruction.addParameter(parameter);
		}
		
		return instruction;
	}
	
}
