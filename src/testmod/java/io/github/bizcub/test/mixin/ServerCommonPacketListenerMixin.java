package io.github.bizcub.test.mixin;

import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.BrandPayload;
import net.minecraft.network.protocol.common.custom.ModListPayload;
import net.minecraft.server.network.ServerCommonPacketListenerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerCommonPacketListenerImpl.class)
public abstract class ServerCommonPacketListenerMixin {

    @Unique
    private static final Logger LOGGER = LoggerFactory.getLogger("testmod");

    @Inject(method = "handleCustomPayload", at = @At("HEAD"))
    private void testmod$logClientMods(ServerboundCustomPayloadPacket packet, CallbackInfo ci) {
        switch (packet.payload()) {
            case ModListPayload modList ->
                    LOGGER.info("Client mod list: {}", modList.entries());
            case BrandPayload(String brand) ->
                    LOGGER.info("Client brand: {}", brand);
            default -> { }
        }
    }
}
