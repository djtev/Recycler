package uk.co.tjevans.recycler.customevents;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * Recycler's custom event for when a player clicks on the Recycler.
 *
 */
public class PlayerClickRecyclerEvent extends Event {
	
	private static final HandlerList handlers = new HandlerList();
	private Player playerWhoClicked;
	private ItemStack itemToRecycle;
	
	public PlayerClickRecyclerEvent(Player playerWhoClicked, ItemStack itemToRecycle) {
		this.playerWhoClicked = playerWhoClicked;
		this.itemToRecycle = itemToRecycle;
	}
	
	/**
	 * Gets the player who clicked on the Recycler block.
	 * 
	 * @return the player
	 */
	public Player getPlayer() {
		return playerWhoClicked;
	}

	/**
	 * Gets the item the player wants to recycle.
	 * 
	 * @return the item
	 */
	public ItemStack getItemToRecycle() {
		return itemToRecycle;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}

}
