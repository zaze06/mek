package me.alien.meksifi.mek;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Mek.ModID)
public class Mek {

    // Directly reference a log4j logger.
    public static final String ModID = "mek";
    private static final Logger LOGGER = LogManager.getLogger();

    public Mek() {
        Registration.register();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
