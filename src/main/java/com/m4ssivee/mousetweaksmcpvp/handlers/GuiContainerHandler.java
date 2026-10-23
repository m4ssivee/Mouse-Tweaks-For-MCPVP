package com.m4ssivee.mousetweaksmcpvp.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.*;
import com.m4ssivee.mousetweaksmcpvp.IGuiScreenHandler;
import com.m4ssivee.mousetweaksmcpvp.MouseButton;
import com.m4ssivee.mousetweaksmcpvp.api.MouseTweaksDisableWheelTweak;
import com.m4ssivee.mousetweaksmcpvp.api.MouseTweaksIgnore;
import com.m4ssivee.mousetweaksmcpvp.mixin.AbstractContainerScreenAccessor;

import java.util.List;

public class GuiContainerHandler implements IGuiScreenHandler {
    Minecraft mc;
    private final AbstractContainerScreen screen;
    private final AbstractContainerScreenAccessor screenAccessor;

    public GuiContainerHandler(AbstractContainerScreen screen) {
        this.mc = Minecraft.getInstance();
        this.screen = screen;
        this.screenAccessor = (AbstractContainerScreenAccessor) screen;
    }

    @Override
    public boolean isMouseTweaksDisabled() {
        return screen.getClass().isAnnotationPresent(MouseTweaksIgnore.class);
    }

    @Override
    public boolean isWheelTweakDisabled() {
        return screen.getClass().isAnnotationPresent(MouseTweaksDisableWheelTweak.class);
    }

    @Override
    public List<Slot> getSlots() {
        return screen.getMenu().slots;
    }

    @Override
    public Slot getSlotUnderMouse(double mouseX, double mouseY) {
        return screenAccessor.mousetweaksmcpvp$invokeFindSlot(mouseX, mouseY);
    }

    @Override
    public boolean disableRMBDraggingFunctionality() {
        screenAccessor.mousetweaksmcpvp$setSkipNextRelease(true);

        if (screenAccessor.mousetweaksmcpvp$getIsQuickCrafting() && screenAccessor.mousetweaksmcpvp$getQuickCraftingButton() == 1) {
            screenAccessor.mousetweaksmcpvp$setIsQuickCrafting(false);
            return true;
        }

        return false;
    }

    @Override
    public void clickSlot(Slot slot, MouseButton mouseButton, boolean shiftPressed) {
        screenAccessor.mousetweaksmcpvp$invokeSlotClicked(
                slot,
                slot.index,
                mouseButton.getValue(),
                shiftPressed ? ClickType.QUICK_MOVE : ClickType.PICKUP
        );
    }

    @Override
    public boolean isCraftingOutput(Slot slot) {
        return (slot instanceof ResultSlot
                || slot instanceof FurnaceResultSlot
                || slot instanceof MerchantResultSlot);
    }

    @Override
    public boolean isIgnored(Slot slot) {
        return false;
    }
}
