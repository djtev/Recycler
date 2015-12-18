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
			
			if (e.getPlayer().getItemInHand().hasItemMeta() && e.getPlayer().getItemInHand().getItemMeta().hasEnchants()==true){
				e.getPlayer().sendMessage("Item " + type + " has enchants. Sorry but it is not Recyclable");
				}
			else if (itemToRecycle.getType() == Material.HOPPER && itemToRecycle.getAmount() >= 1){
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
			else if (itemToRecycle.getType() == Material.BOW && itemToRecycle.getAmount() >= 1){
				if (e.getPlayer().getItemInHand().getDurability()<=300){
					e.getPlayer().sendMessage("Item " + type + " Is too damaged. Sorry but it is not Recyclable");
					}
				else {
				e.getPlayer().getInventory().removeItem(new ItemStack(Material.BOW, 1));
				e.getPlayer().getInventory().addItem(new ItemStack(Material.STRING, 3));
				e.getPlayer().getInventory().addItem(new ItemStack(Material.STICK, 3));
				e.getPlayer().sendMessage("Item " + type + " Recycled");
			}}
			else if ((itemToRecycle.getType() == Material.FLINT) || (itemToRecycle.getType() == Material.RECORD_3) || (itemToRecycle.getType() == Material.RECORD_10) || (itemToRecycle.getType() == Material.RECORD_11) || (itemToRecycle.getType() == Material.RECORD_12) || (itemToRecycle.getType() == Material.RECORD_4) || (itemToRecycle.getType() == Material.RECORD_5) || (itemToRecycle.getType() == Material.RECORD_6) || (itemToRecycle.getType() == Material.RECORD_7) || (itemToRecycle.getType() == Material.RECORD_8) || (itemToRecycle.getType() == Material.RECORD_9) || (itemToRecycle.getType() == Material.FEATHER) || (itemToRecycle.getType() == Material.RED_ROSE) || (itemToRecycle.getType() == Material.APPLE) || (itemToRecycle.getType() == Material.DIAMOND) || (itemToRecycle.getType() == Material.GOLD_NUGGET)|| (itemToRecycle.getType() == Material.NAME_TAG)){
				e.getPlayer().sendMessage(type + "is not recyclable");
			}
				else {
				e.getPlayer().sendMessage("You don't have enough of " + type + " to recycle");
			}
			Bukkit.getPluginManager().callEvent(new PlayerClickRecyclerEvent(e.getPlayer(), itemToRecycle));
		}
	}

}
