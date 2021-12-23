package me.thomaspj10.library.events.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockCookEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.block.BlockExpEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFertilizeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.BlockShearEntityEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.block.FluidLevelChangeEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.MoistureChangeEvent;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.block.SpongeAbsorbEvent;

import me.thomaspj10.library.events.EventManager;

public class BlockEventListener implements Listener {

	private EventManager eventManager;
	
	public BlockEventListener(EventManager eventManager) {
		this.eventManager = eventManager;
	}
	
	@EventHandler
	public void on(BlockBreakEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockBurnEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockCanBuildEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockCookEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockDamageEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockDispenseArmorEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockDispenseEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockDropItemEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockExpEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockExplodeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockFadeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockFertilizeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockFormEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockFromToEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockGrowEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockIgniteEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockMultiPlaceEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockPhysicsEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockPistonExtendEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockPistonRetractEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockPlaceEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockRedstoneEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockShearEntityEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(BlockSpreadEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(CauldronLevelChangeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(EntityBlockFormEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(FluidLevelChangeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(LeavesDecayEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(MoistureChangeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(NotePlayEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(SignChangeEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
	@EventHandler
	public void on(SpongeAbsorbEvent event) {
		this.eventManager.execute(event.getClass(), event);
	}
	
}
