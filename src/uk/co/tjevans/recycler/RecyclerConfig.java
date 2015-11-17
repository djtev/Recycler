package uk.co.tjevans.recycler;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Recycler's config. Sets its default values to its config file and retrieves
 * values from its config file.
 *
 */
public class RecyclerConfig {

	private Recycler recycler;
	private FileConfiguration config;
	private String opts/*, msgs*/;
	
	public RecyclerConfig(Recycler recycler) {
		this.recycler = recycler;
		this.config = recycler.getConfig();
		this.opts = "Options.";
		//this.msgs = "Messages.";
	}
	
	public void addDefaultValues() {
		config.addDefault(opts + "Recycler", "CAULDRON");
		config.options().copyDefaults(true);
		recycler.saveConfig();
	}
	
	public Material getRecycler() {
		String recyclerBlock = config.getString(opts + "Recycler-Block");
		Material recycler = Material.getMaterial(recyclerBlock);
		if (recycler == null) {
			return Material.CAULDRON;
		}
		return recycler;
	}
	
}
