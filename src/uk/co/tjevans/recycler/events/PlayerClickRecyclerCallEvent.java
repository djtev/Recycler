package uk.co.tjevans.recycler.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

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
			if (clickedBlock.getType() != recyclerMat) {
				return;
			}
			ItemStack itemToRecycle = e.getPlayer().getItemInHand();
			Material type = itemToRecycle.getType();
			if (itemToRecycle == null || itemToRecycle.getType() == Material.AIR) {
				return;
			}
			else if (itemToRecycle.getType() == Material.HOPPER && itemToRecycle.getAmount() >= 1){
				;
				e.getPlayer().getInventory().removeItem(new ItemStack(Material.HOPPER, 1));
				e.getPlayer().getInventory().addItem(new ItemStack(Material.IRON_INGOT, 5));
				e.getPlayer().getInventory().addItem(new ItemStack(Material.CHEST, 1));
				e.getPlayer().sendMessage("Item " + type + " Recycled");
			}
			else if (itemToRecycle.getType() == Material.ARROW && itemToRecycle.getAmount() >= 4){
				e.getPlayer().getInventory().removeItem(new ItemStack(Material.ARROW, 4));
				e.getPlayer().getInventory().addItem(new ItemStack(Material.FLINT, 1));
				e.getPlayer().getInventory().addItem(new ItemStack(Material.STICK, 1));
				e.getPlayer().getInventory().addItem(new ItemStack(Material.FEATHER, 1));
				e.getPlayer().sendMessage("Item " + type + " Recycled");
			}
			else {
				e.getPlayer().sendMessage("You don't have enough of " + type + " to recycle");
			}
			Bukkit.getPluginManager().callEvent(new PlayerClickRecyclerEvent(e.getPlayer(), itemToRecycle));
		}
	}

}
