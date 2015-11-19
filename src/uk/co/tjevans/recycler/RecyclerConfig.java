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
		config.addDefault(opts + "Recycler-Material", "CAULDRON");
		config.options().copyDefaults(true);
		recycler.saveConfig();
	}
	
	public Material getRecyclerMaterial() {
		String recyclerMat = config.getString(opts + "Recycler-Material");
		Material recycler = Material.getMaterial(recyclerMat);
		if (recycler == null) {
			return Material.CAULDRON;
		}
		return recycler;
	}
	
}
