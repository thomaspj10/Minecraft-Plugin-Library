package me.thomaspj10.library.player;

import java.util.function.Consumer;
import java.util.function.Predicate;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

import me.thomaspj10.library.Main;
import me.thomaspj10.library.event.IEventListener;

public class APlayer implements IEventListener<PlayerEvent> {
	
	private Player player;
	private Predicate<PlayerEvent> filter = e -> {
		return e.getPlayer().getUniqueId() == this.player.getUniqueId();
	};
	
	public APlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}

	@Override
	public <T extends PlayerEvent> void on(Class<T> clazz, Consumer<T> callback) {
		Main.eventManager.register(clazz, callback, this.filter);
	}
	
}
