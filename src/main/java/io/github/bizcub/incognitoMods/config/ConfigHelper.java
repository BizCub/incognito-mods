package io.github.bizcub.incognitoMods.config;

/*? fabric*/ import io.github.bizcub.incognitoMods.IncognitoMods;
import io.github.bizcub.simpleConfigLib.autoconfig.gui.ConfigScreens;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.Screen;
/*? forge*/ //import net.minecraftforge.fml.ModList;
/*? neoforge*/ //import net.neoforged.fml.ModList;

public class ConfigHelper {

    public static boolean isModLoaded(String modId) {
        /*? fabric*/ return FabricLoader.getInstance().isModLoaded(modId);
        /*? (forge && <26.1) || neoforge*/ //return ModList.get().isLoaded(modId);
        /*? forge && >=26.1*/ //return ModList.isLoaded(modId);
    }

    public static boolean isConfigLoaded() {
        return isModLoaded("simple_config_lib");
    }

    public static Screen getScreen(Screen parent) {
        return ConfigHelper.isConfigLoaded()
                ? ConfigScreens.open(IncognitoMods.MOD_ID, parent)
                : parent;
    }
}
