package com.m4ssivee.mousetweaksmcpvp.mixin;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(AbstractContainerScreen.class)
public interface AbstractContainerScreenAccessor {
    @Invoker("findSlot")
    Slot mousetweaksmcpvp$invokeFindSlot(double x, double y);

    @Invoker("slotClicked")
    void mousetweaksmcpvp$invokeSlotClicked(Slot slot, int index, int button, ClickType clickType);

    @Accessor("isQuickCrafting")
    boolean mousetweaksmcpvp$getIsQuickCrafting();

    @Accessor("isQuickCrafting")
    void mousetweaksmcpvp$setIsQuickCrafting(boolean value);

    @Accessor("quickCraftingButton")
    int mousetweaksmcpvp$getQuickCraftingButton();

    @Accessor("skipNextRelease")
    void mousetweaksmcpvp$setSkipNextRelease(boolean value);
}
