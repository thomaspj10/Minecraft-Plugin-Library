package me.thomaspj10.library.script.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import me.thomaspj10.library.builder.ClassBuilder;
import me.thomaspj10.library.script.instruction.InstructionChain;
import me.thomaspj10.library.script.parameter.ConstantParameter;
import me.thomaspj10.library.script.parameter.IParameter;
import me.thomaspj10.library.script.parameter.InstructionChainParameter;

public class ParameterBuilder extends ClassBuilder<IParameter> {
	
	public ParameterBuilder() {
		this.setRequiredKeys(new String[] {
			"type", "className", "value"
		});
	}
	
	public IParameter build() {
		String type = this.getJson().get("type").getAsString();
		String className = this.getJson().get("className").getAsString();
				
		Gson gson = new GsonBuilder().create();
		
		if (type.equals("constant")) {
			Object value = gson.fromJson(this.getJson().get("value"), Object.class);
				
			return new ConstantParameter(className, value);
		}
		
		if (type.equals("commandchain")) {			
			JsonObject instructionChainObject = this.getJson().get("value").getAsJsonObject();
			InstructionChain chain = new InstructionChainBuilder().json(instructionChainObject).build();
			
			return new InstructionChainParameter(className, chain);
		}
		
		return null;
	}
	
}
