package uk.co.tjevans.recycler;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.tjevans.recycler.events.PlayerClickRecyclerCallEvent;

/**
 * Recycler's main class. Sets up its config, registers its events, and more.
 *
 */
public class Recycler extends JavaPlugin {
	
	private RecyclerConfig config;
	
	public Recycler() {
		this.config = new RecyclerConfig(this);
	}
	
	@Override
	public void onEnable() {
		config.addDefaultValues();
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new PlayerClickRecyclerCallEvent(this), this);
	}
	
	@Override
	public void onDisable() {
		// to do
	}
	
	public RecyclerConfig getRecyclerConfig() {
		return config;
	}

}
