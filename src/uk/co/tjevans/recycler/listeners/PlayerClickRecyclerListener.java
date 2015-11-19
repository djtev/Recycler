package uk.co.tjevans.recycler.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import uk.co.tjevans.recycler.customevents.PlayerClickRecyclerEvent;

public class PlayerClickRecyclerListener implements Listener {

	// to do
	// listen to the PlayerClickRecyclerEvent
	// execute recycling actions
	// profit - lol
	
	@EventHandler
	public void onPlayerClickRecycler(PlayerClickRecyclerEvent e) {
		switch (e.getItemToRecycle().getType()) {
		
		default:
			break;
		}
	}
	
}
