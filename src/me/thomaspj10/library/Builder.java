package me.thomaspj10.library;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import me.thomaspj10.library.logger.Logger;
import me.thomaspj10.library.logger.Logger.LogType;

public class Builder<T, S extends JsonElement> {

	private S json;
	
	private String[] requiredKeys = new String[] {};
	
	protected final S getJson() {
		return this.json;
	}
	
	protected final void setRequiredKeys(String[] keys) {
		this.requiredKeys = keys;
	}
	
	private boolean isValidJson() {
		if (this.json instanceof JsonObject) {
			JsonObject json = (JsonObject) this.json;
			
			for (String key : this.requiredKeys) {
				if (!json.has(key)) return false;
			}
		}
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public final Builder<T, JsonObject> json(String jsonData) {
		this.json = (S) new JsonParser().parse(jsonData).getAsJsonObject();
		if (!this.isValidJson()) Logger.log(LogType.WARN, "The json is missing a required key.");
		
		return (Builder<T, JsonObject>) this;
	}
	
	public final Builder<T, S> json(S json) {
		this.json = json;
		if (!this.isValidJson()) Logger.log(LogType.WARN, "The json is missing a required key.");
		
		return this;
	}
	
	public T build() {
		return null;
	}
	
}
