package me.thomaspj10.library.inventory.builder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import me.thomaspj10.library.ClassBuilder;
import me.thomaspj10.library.Logger;
import me.thomaspj10.library.Logger.LogType;
import me.thomaspj10.library.inventory.AInventory;
import me.thomaspj10.library.inventory.AItem;

public class AInventoryBuilder extends ClassBuilder<AInventory> {
	
	public AInventory build() {
		AInventory inventory = new AInventory(this.getJson().get("name").getAsString(), this.getJson().get("size").getAsInt());
		
		for (JsonElement itemElement : this.getJson().get("items").getAsJsonArray()) {
			JsonObject itemObject = itemElement.getAsJsonObject();
			
			int slot = itemObject.get("slot").getAsInt();
			AItem item = new AItemBuilder().json(itemObject.get("item").getAsJsonObject()).build();
			
			if (slot < 0 || slot > inventory.getSize()) Logger.log(LogType.WARN, "The item slot is not in bound of the inventory size.");
			
			inventory.setItem(slot, item);
		}
		
		return inventory;
	}
	
}
