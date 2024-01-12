package dukefloppa.desolateddungeons;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DesolatedDungeons implements ModInitializer {
	public static final String MOD_ID = "desolateddungeons";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Desolated Dungeons mod :3");
	}
}