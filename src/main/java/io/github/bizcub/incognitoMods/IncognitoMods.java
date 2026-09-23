package io.github.bizcub.incognitoMods;

import io.github.bizcub.incognitoMods.config.Config;
import io.github.bizcub.incognitoMods.config.ConfigHelper;
import io.github.bizcub.incognitoMods.config.SimpleConfig;

public class IncognitoMods {
    public static final String MOD_ID = /*$ mod_id*/ "incognito_mods";

    public static void init() {
        if (ConfigHelper.isConfigLoaded()) {
            Config.set(SimpleConfig.getInstance().get());
        }
    }
}
