package me.thomaspj10.library.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.thomaspj10.library.Main;
import me.thomaspj10.library.events.IEventListener;
import me.thomaspj10.library.inventory.events.AInventoryClickEvent;

public class AItem implements IEventListener<AInventoryClickEvent> {
	
	private ItemStack item;
	
	public AItem(ItemStack item) {
		this.item = item;
	}
	
	public AItem(Material material) {
		this.item = new ItemStack(material);
	}
	
	private Predicate<AInventoryClickEvent> filter = e -> {
		// Note: This is not perfect, the same item will still trigger.
		if (e.getItem() == null) return false;
		
		return this.item.equals(e.getItem().getItemStack());
	};

	@Override
	public <T extends AInventoryClickEvent> void on(Class<T> clazz, Consumer<T> callback) {
		Main.eventManager.register(clazz, callback, this.filter);
	}
	
	public ItemStack getItemStack() {
		return this.item;
	}
	
	public String getName() {
		return this.item.getItemMeta().hasDisplayName() ? this.item.getItemMeta().getDisplayName() : this.item.getType().name();
	}
	
	public boolean isUnbreakable() {
		return this.item.getItemMeta().isUnbreakable();
	}
	
	public int getAmount() {
		return this.item.getAmount();
	}
	
	private void modify(Consumer<ItemMeta> callback) {		
		ItemMeta itemMeta = this.item.getItemMeta();
		callback.accept(itemMeta);
		this.item.setItemMeta(itemMeta);
	}
	
	public void setAmount(int amount) {
		this.item.setAmount(amount);
	}
	
	public void setName(String name) {
		this.modify(itemMeta -> {
			itemMeta.setDisplayName(name);
		});
	}
	
	public void addLore(String line) { 
		this.modify(itemMeta -> {
			List<String> lore = new ArrayList<>();
			if (itemMeta.hasLore())
				lore = itemMeta.getLore();
			
			lore.add(line);
			itemMeta.setLore(lore);
		});
	}
	
	public void setLore(List<String> lore) {
		this.modify(itemMeta -> {
			itemMeta.setLore(lore);
		});
	}
	
	public void setIsUnbreakable(boolean isUnbreakable) {
		this.modify(itemMeta -> {
			itemMeta.setUnbreakable(isUnbreakable);
		});
	}
	
}
