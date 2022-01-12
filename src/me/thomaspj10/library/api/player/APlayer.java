package me.thomaspj10.library.api.player;

import java.util.function.Predicate;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

import me.thomaspj10.library.entity.AEntity;
import me.thomaspj10.library.script.adapter.IAdaptable;

public class APlayer extends AEntity<PlayerEvent> implements IAdaptable<Player> {
	
	private Player player;
	
	public APlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}

	@Override
	public Predicate<PlayerEvent> getFilter() {
		return e -> {
			return e.getPlayer().getUniqueId() == this.player.getUniqueId();
		};
	}

	@Override
	public Player getBase() {
		return this.player;
	}

	@Override
	protected boolean matchesIdentifier(Object identifier) {
		return this.player.getUniqueId() == identifier;
	}
	
}
