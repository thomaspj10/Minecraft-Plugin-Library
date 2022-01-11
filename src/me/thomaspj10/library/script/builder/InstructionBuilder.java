package me.thomaspj10.library.script.builder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import me.thomaspj10.library.builder.ClassBuilder;
import me.thomaspj10.library.script.instruction.Instruction;
import me.thomaspj10.library.script.parameter.IParameter;

public class InstructionBuilder extends ClassBuilder<Instruction> {

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
