package me.thomaspj10.library;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import me.thomaspj10.library.Logger.LogType;

public class ClassBuilder<T> {

	private JsonObject json;
	
	private String[] requiredKeys = new String[] {};
	
	protected final JsonObject getJson() {
		return this.json;
	}
	
	protected final void setRequiredKeys(String[] keys) {
		this.requiredKeys = keys;
	}
	
	private boolean isValidJson() {
		JsonObject json = (JsonObject) this.json;
		
		for (String key : this.requiredKeys) {
			if (!json.has(key)) return false;
		}
	
		return true;
	}
	
	public final ClassBuilder<T> json(String jsonData) {
		this.json = new JsonParser().parse(jsonData).getAsJsonObject();
		if (!this.isValidJson()) Logger.log(LogType.WARN, "The json is missing a required key.");
		
		return (ClassBuilder<T>) this;
	}
	
	public final ClassBuilder<T> json(JsonObject json) {
		this.json = json;
		if (!this.isValidJson()) Logger.log(LogType.WARN, "The json is missing a required key.");
		
		return this;
	}
	
	public T build() {
		return null;
	}
	
}
