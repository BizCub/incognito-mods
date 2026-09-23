//? fabric {
package io.github.bizcub.incognitoMods.platform;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.bizcub.incognitoMods.IncognitoMods;
import io.github.bizcub.incognitoMods.config.ConfigHelper;
import net.fabricmc.api.ClientModInitializer;

public class FabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        IncognitoMods.init();
    }

    public static class ModMenu implements ModMenuApi {

        @Override
        public ConfigScreenFactory<?> getModConfigScreenFactory() {
            return ConfigHelper::getScreen;
        }
    }
}//?}
