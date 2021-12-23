package me.thomaspj10.library.executor.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import me.thomaspj10.library.Builder;
import me.thomaspj10.library.executor.instruction.InstructionChain;
import me.thomaspj10.library.executor.parameter.ConstantParameter;
import me.thomaspj10.library.executor.parameter.IParameter;
import me.thomaspj10.library.executor.parameter.InstructionChainParameter;

public class ParameterBuilder extends Builder<IParameter, JsonObject> {
	
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
