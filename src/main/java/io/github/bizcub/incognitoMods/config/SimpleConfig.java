package io.github.bizcub.incognitoMods.config;

import io.github.bizcub.incognitoMods.IncognitoMods;
import io.github.bizcub.simpleConfigLib.autoconfig.ConfigHolder;
import io.github.bizcub.simpleConfigLib.autoconfig.ConfigSide;
import io.github.bizcub.simpleConfigLib.autoconfig.annotation.*;

import java.util.List;

@AutoConfig(name = IncognitoMods.MOD_ID, side = ConfigSide.CLIENT, snakeCaseKeys = true, translate = true)
public class SimpleConfig implements Config {

    public static ConfigHolder<SimpleConfig> getInstance() {
        return ConfigHolder.register(SimpleConfig.class);
    }

    @Tooltip
    public Mode mode = Config.super.mode();

    @Tooltip
    public List<String> customEntries = Config.super.customEntries();

    @Override
    public Mode mode() {
        return this.mode;
    }

    @Override
    public List<String> customEntries() {
        return this.customEntries;
    }
}
