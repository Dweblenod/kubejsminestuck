package com.havingfunrightnow.kubejsminestuck;

import com.google.common.collect.ImmutableMap;
import com.mraof.minestuck.alchemy.GristHelper;
import com.mraof.minestuck.api.alchemy.*;
import com.mraof.minestuck.player.*;
import net.minecraft.server.level.ServerPlayer;

import java.util.Objects;

@SuppressWarnings("unused")
public class KJSMPlayerData {
    private final PlayerData data;

    public KJSMPlayerData(ServerPlayer player) {
        this.data = PlayerSavedData.getData(player);
    }

    public int getColor() {
        return data.getColor();
    }
    public void setColor(int color) {
        data.trySetColor(color);
    }
    public String getModus() {
        return data.getModus().getName().getString();
    }
    public long getBoondollars() {
        return data.getBoondollars();
    }
    public void setBoondollars(long amount) {
        data.setBoondollars(amount);
    }
    public void addBoondollars(long amount) {
        data.addBoondollars(amount);
    }
    public void takeBoondollars(long amount) {
        data.takeBoondollars(amount);
    }

    public String getTitle() {
        var title = data.getTitle();
        return title != null ? title.toString() : "??? of ???";
    }
    public String getHeroClass() {
        var title = data.getTitle();
        return title != null ? title.getHeroClass().toString() : "???";
    }
    public String getHeroAspect() {
        var title = data.getTitle();
        return title != null ? title.getHeroAspect().toString() : "???";
    }
    public void setTitle(String titleClass, String titleAspect) {
        var enumClass = Objects.requireNonNull(EnumClass.fromString(titleClass));
        var enumAspect = Objects.requireNonNull(EnumAspect.fromString(titleAspect));
        data.setTitle(new Title(enumClass, enumAspect));
    }

    public int getRung() {
        return data.getEcheladder().getRung();
    }
    public float getRungProgress() {
        return data.getEcheladder().getProgress();
    }
    public void setRung(int rung) {
        data.getEcheladder().setByCommand(rung, 0);
    }
    public void setRung(int rung, float progress) {
        data.getEcheladder().setByCommand(rung, progress);
    }
    public void setRungProgress(float progress) {
        var echeladder = data.getEcheladder();
        echeladder.setByCommand(echeladder.getRung(), progress);
    }
    public void increaseRungProgress(int progress) {
        data.getEcheladder().increaseProgress(progress);
    }

    public ImmutableMap<GristType, Long> getGrist() {
        return (ImmutableMap<GristType, Long>) data.getGristCache().getGristSet().asMap();
    }
    public long getGrist(GristType type) {
        return data.getGristCache().getGristSet().getGrist(type);
    }
    public long addGrist(GristType type, long amount) {
        return data.getGristCache().addWithinCapacity(new GristAmount(type, amount), GristHelper.EnumSource.CONSOLE).getGrist(type);
    }
    public MutableGristSet addGrist(GristSet gristSet) {
        return data.getGristCache().addWithinCapacity(gristSet, GristHelper.EnumSource.CONSOLE);
    }
}
