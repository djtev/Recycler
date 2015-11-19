package uk.co.tjevans.recycler.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import uk.co.tjevans.recycler.Recycler;
import uk.co.tjevans.recycler.customevents.PlayerClickRecyclerEvent;

/**
 * Recycler's call to PlayerClickRecyclerEvent.
 *
 */
public class PlayerClickRecyclerCallEvent implements Listener {
	
	private Recycler recycler;
	
	public PlayerClickRecyclerCallEvent(Recycler recycler) {
		this.recycler = recycler;
	}
	
	@EventHandler
	public void onPlayerClickRecycler(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block clickedBlock = e.getClickedBlock();
			// Checks if the block is null
			if (clickedBlock == null || clickedBlock.getType() == Material.AIR) {
				return;
			}
			Material recyclerMat = recycler.getRecyclerConfig().getRecyclerMaterial();
			if (clickedBlock.getType() == recyclerMat) {
				PlayerClickRecyclerEvent recyclerEvent = new PlayerClickRecyclerEvent(e.getPlayer());
				Bukkit.getPluginManager().callEvent(recyclerEvent);
			}
		}
	}

}
