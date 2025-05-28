package com.maplesugar365.peaceful_depletion;

import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import com.maplesugar365.peaceful_depletion.network.Data;

@Mod(PeacefulDepletion.MODID)
public class PeacefulDepletion {
    public static final String MODID = "peaceful_depletion";

    public PeacefulDepletion(IEventBus modEventBus) {
        modEventBus.addListener(this::registrarDataChannel);
    }

    @SuppressWarnings("null")
    private void registrarDataChannel(RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(MODID)
                .versioned("1.0.2");
        registrar.playToClient(Data.TYPE, Data.STREAM_CODEC, null);
    }
}