package io.github.bizcub.incognitoMods.mixin;

import io.github.bizcub.incognitoMods.config.Config;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.ModListPayload;
import net.minecraft.network.protocol.common.custom.PropertyMap;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(Connection.class)
public abstract class ConnectionMixin {

    @Unique
    private static final ThreadLocal<Boolean> im$resending = ThreadLocal.withInitial(() -> false);

    @Inject(method = "send(Lnet/minecraft/network/protocol/Packet;)V", at = @At("HEAD"), cancellable = true)
    private void im$filterModList(Packet<?> packet, CallbackInfo ci) {
        if (im$resending.get()
                || !(packet instanceof ServerboundCustomPayloadPacket custom)
                || !(custom.payload() instanceof ModListPayload modList)) {
            return;
        }

        switch (Config.get().mode()) {
            case PASSTHROUGH -> { }
            case EMPTY -> {
                if (!modList.entries().isEmpty()) {
                    ci.cancel();
                    im$resend(new ModListPayload(Map.of()));
                }
            }
            case CUSTOM -> {
                ci.cancel();
                im$resend(new ModListPayload(im$parseEntries()));
            }
        }
    }

    @Unique
    private void im$resend(ModListPayload payload) {
        im$resending.set(true);
        try {
            ((Connection) (Object) this).send(new ServerboundCustomPayloadPacket(payload));
        } finally {
            im$resending.set(false);
        }
    }

    @Unique
    private static Map<Identifier, PropertyMap> im$parseEntries() {
        Map<Identifier, PropertyMap> map = new HashMap<>();
        for (String entry : Config.get().customEntries()) {
            Identifier id = Identifier.tryParse(entry.trim());
            if (id != null) {
                map.put(id, new PropertyMap(Map.of()));
            }
        }
        return map;
    }
}
