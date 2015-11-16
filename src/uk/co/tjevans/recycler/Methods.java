package uk.co.tjevans.recycler;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Methods {

public void onInteract(PlayerInteractEvent event){
	
	Player player = event.getPlayer();
    Block block = event.getClickedBlock();
    Item item = (Item) event.getItem();
   
    if(block.getType() == Material.DIAMOND_BLOCK){
    	Action action = event.getAction();
    	if(action == Action.RIGHT_CLICK_BLOCK){
    	}
    }
}
}