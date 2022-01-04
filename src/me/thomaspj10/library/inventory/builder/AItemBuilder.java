package me.thomaspj10.library.inventory.builder;

import org.bukkit.Material;

import com.google.gson.JsonObject;

import me.thomaspj10.library.ClassBuilder;
import me.thomaspj10.library.inventory.AItem;

public class AItemBuilder extends ClassBuilder<AItem, JsonObject> {
	
	public AItemBuilder() {
		this.setRequiredKeys(new String[] {
			"material"
		});
	}
	
	public AItem build() {
		AItem item = new AItem(Material.valueOf(this.getJson().get("material").getAsString()));
		
		if (this.getJson().has("amount")) item.setAmount(this.getJson().get("amount").getAsInt());
		if (this.getJson().has("name")) item.setName(this.getJson().get("name").getAsString());
		
		return item;
	}
	
}
