package com.maplesugar365.peaceful_depletion.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record Data(int data) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<Data> TYPE = new CustomPacketPayload.Type<>(
            ResourceLocation.fromNamespaceAndPath("peaceful_depletion", "data_channel"));
    public static final StreamCodec<ByteBuf, Data> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT,
            Data::data,
            Data::new);

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
