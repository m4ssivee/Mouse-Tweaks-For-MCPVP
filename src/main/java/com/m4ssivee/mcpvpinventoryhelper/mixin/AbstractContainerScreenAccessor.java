package com.m4ssivee.mcpvpinventoryhelper.mixin;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(AbstractContainerScreen.class)
public interface AbstractContainerScreenAccessor {
    @Invoker("getHoveredSlot")
    Slot mcpvpinvhelper$invokeGetHoveredSlot(double x, double y);

    @Invoker("slotClicked")
    void mcpvpinvhelper$invokeSlotClicked(Slot slot, int index, int button, ClickType clickType);

    @Accessor("isQuickCrafting")
    boolean mcpvpinvhelper$getIsQuickCrafting();

    @Accessor("isQuickCrafting")
    void mcpvpinvhelper$setIsQuickCrafting(boolean value);

    @Accessor("quickCraftingButton")
    int mcpvpinvhelper$getQuickCraftingButton();

    @Accessor("skipNextRelease")
    void mcpvpinvhelper$setSkipNextRelease(boolean value);
}
