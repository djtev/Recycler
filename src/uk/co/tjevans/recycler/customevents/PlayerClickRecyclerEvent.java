package uk.co.tjevans.recycler.customevents;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Recycler's custom event for when a player clicks on the Recycler.
 *
 */
public class PlayerClickRecyclerEvent extends Event {
	
	private static final HandlerList handlers = new HandlerList();
	private Player playerWhoClicked;
	
	public PlayerClickRecyclerEvent(Player playerWhoClicked) {
		this.playerWhoClicked = playerWhoClicked;
	}
	
	public Player getPlayer() {
		return playerWhoClicked;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlersList() {
		return handlers;
	}

}
