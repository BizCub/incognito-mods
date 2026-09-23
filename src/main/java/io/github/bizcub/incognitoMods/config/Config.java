package io.github.bizcub.incognitoMods.config;

import java.util.List;

public interface Config {
    static Config get() {
        return Holder.INSTANCE;
    }

    static void set(final Config config) {
        if (config != null) {
            Holder.INSTANCE = config;
        }
    }

    class Holder {
        private static Config INSTANCE = new Config() { };
    }

    enum Mode {
        PASSTHROUGH,
        EMPTY,
        CUSTOM
    }

    default Mode mode() {
        return Mode.EMPTY;
    }

    default List<String> customEntries() {
        return List.of();
    }
}
