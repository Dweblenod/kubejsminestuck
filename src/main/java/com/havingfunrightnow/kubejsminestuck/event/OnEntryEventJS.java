package com.havingfunrightnow.kubejsminestuck.event;

import com.mraof.minestuck.player.PlayerIdentifier;
import com.mraof.minestuck.event.OnEntryEvent;
import dev.latvian.mods.kubejs.event.EventJS;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.server.MinecraftServer;

@SuppressWarnings("unused")
public class OnEntryEventJS extends EventJS {
    final OnEntryEvent event;

    public OnEntryEventJS(OnEntryEvent event) {
        this.event = event;
    }

    @Info("the minecraft server this event happened in")
    public MinecraftServer getMinecraftServer() {
        return this.event.getMcServer();
    }

    @Info("the player who activated this event")
    public PlayerIdentifier getPlayer() {
        return this.event.getPlayer();
    }
}
