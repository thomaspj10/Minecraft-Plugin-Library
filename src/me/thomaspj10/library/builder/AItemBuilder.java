package me.thomaspj10.library.builder;

import org.bukkit.Material;

import me.thomaspj10.library.api.inventory.AItem;

public class AItemBuilder extends ClassBuilder<AItem> {
	
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
