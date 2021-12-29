package me.thomaspj10.library.event.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerChannelEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerItemMendEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerLocaleChangeEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRecipeDiscoverEvent;
import org.bukkit.event.player.PlayerRegisterChannelEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerRiptideEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerTakeLecternBookEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import org.bukkit.event.player.PlayerUnregisterChannelEvent;
import org.bukkit.event.player.PlayerVelocityEvent;

import me.thomaspj10.library.event.EventManager;

public class PlayerEventListener implements Listener {

	private EventManager eventManager;
	
	public PlayerEventListener(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	
	@EventHandler
	public void on(AsyncPlayerChatEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(AsyncPlayerPreLoginEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerAdvancementDoneEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerAnimationEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerArmorStandManipulateEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerBedEnterEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerBedLeaveEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerBucketEmptyEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerBucketFillEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerChangedMainHandEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerChangedWorldEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerChannelEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerCommandPreprocessEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerCommandSendEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerDropItemEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerEditBookEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerEggThrowEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerExpChangeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerFishEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerGameModeChangeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerHarvestBlockEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerInteractAtEntityEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerInteractEntityEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerInteractEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerItemBreakEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerItemConsumeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerItemDamageEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerItemHeldEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerItemMendEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerJoinEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerKickEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerLevelChangeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerLocaleChangeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerLoginEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerMoveEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerPickupArrowEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerPortalEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerQuitEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerRecipeDiscoverEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerRegisterChannelEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerResourcePackStatusEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerRespawnEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerRiptideEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerShearEntityEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerStatisticIncrementEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerSwapHandItemsEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerTakeLecternBookEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerTeleportEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerToggleFlightEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerToggleSneakEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerToggleSprintEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerUnleashEntityEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerUnregisterChannelEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(PlayerVelocityEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
}
