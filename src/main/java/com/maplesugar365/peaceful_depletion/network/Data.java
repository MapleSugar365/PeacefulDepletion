package com.maplesugar365.peaceful_depletion.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;

public class Data {
    private final int data;

    public Data(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(data);
    }

    public static Data decode(FriendlyByteBuf buffer) {
        return new Data(buffer.readInt());
    }

    public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
        });
        context.setPacketHandled(true);
    }
}