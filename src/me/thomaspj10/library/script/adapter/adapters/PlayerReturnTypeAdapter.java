package me.thomaspj10.library.script.adapter.adapters;

import org.bukkit.entity.Player;

import me.thomaspj10.library.api.player.APlayer;
import me.thomaspj10.library.script.adapter.IReturnTypeAdapter;

public class PlayerReturnTypeAdapter implements IReturnTypeAdapter<Player, APlayer> {

	@Override
	public Class<Player> getFromType() {
		return Player.class;
	}
	
	@Override
	public APlayer transform(Player object) {
		return new APlayer(object);
	}
	
}
