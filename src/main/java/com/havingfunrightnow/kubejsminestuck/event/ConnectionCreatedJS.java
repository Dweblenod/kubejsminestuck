package com.havingfunrightnow.kubejsminestuck.event;

import com.mraof.minestuck.skaianet.ActiveConnection;
import com.mraof.minestuck.event.SburbEvent;
import dev.latvian.mods.kubejs.event.EventJS;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.server.MinecraftServer;

@SuppressWarnings("unused")
public class ConnectionCreatedJS extends EventJS {
    final SburbEvent.ConnectionCreated event;

    public ConnectionCreatedJS(SburbEvent.ConnectionCreated event) {
        this.event = event;
    }

    @Info("the primary connection of the player this event happened to")
    public ActiveConnection getConnection() {
        return this.event.getConnection();
    }

    @Info("the minecraft server this event happened in")
    public MinecraftServer getMinecraftServer() {
        return this.event.getMinecraftServer();
    }

    @Info("the type of connection between the players this event happened to")
    public SburbEvent.ConnectionCreated.ConnectionType getConnectionType() {
        return this.event.getConnectionType();
    }
}
