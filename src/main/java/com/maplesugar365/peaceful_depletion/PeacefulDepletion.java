package com.maplesugar365.peaceful_depletion;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import com.maplesugar365.peaceful_depletion.network.Data;

@Mod(PeacefulDepletion.MODID)
public class PeacefulDepletion {
    public static final String MODID = "peaceful_depletion";
    private static final String PROTOCOL_VERSION = "1.0.2";
    public static SimpleChannel CHANNEL;

    public PeacefulDepletion() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        CHANNEL = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(MODID, "data_channel"))
                .networkProtocolVersion(() -> PROTOCOL_VERSION)
                .clientAcceptedVersions(PROTOCOL_VERSION::equals)
                .serverAcceptedVersions(PROTOCOL_VERSION::equals)
                .simpleChannel();

        CHANNEL.registerMessage(0, Data.class,
                Data::encode,
                Data::decode,
                Data::handle);
    }
}