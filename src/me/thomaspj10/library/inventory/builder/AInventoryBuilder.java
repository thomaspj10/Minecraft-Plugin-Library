package me.thomaspj10.library.inventory.builder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import me.thomaspj10.library.Builder;
import me.thomaspj10.library.inventory.AInventory;
import me.thomaspj10.library.inventory.AItem;
import me.thomaspj10.library.logger.Logger;
import me.thomaspj10.library.logger.Logger.LogType;

public class AInventoryBuilder extends Builder<AInventory, JsonObject> {
	
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
