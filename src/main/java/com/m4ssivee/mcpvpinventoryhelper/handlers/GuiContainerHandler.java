package com.m4ssivee.mcpvpinventoryhelper.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.*;
import com.m4ssivee.mcpvpinventoryhelper.IGuiScreenHandler;
import com.m4ssivee.mcpvpinventoryhelper.MouseButton;
import com.m4ssivee.mcpvpinventoryhelper.api.MouseTweaksDisableWheelTweak;
import com.m4ssivee.mcpvpinventoryhelper.api.MouseTweaksIgnore;
import com.m4ssivee.mcpvpinventoryhelper.mixin.AbstractContainerScreenAccessor;

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
        return screenAccessor.mcpvpinvhelper$invokeGetHoveredSlot(mouseX, mouseY);
    }

    @Override
    public boolean disableRMBDraggingFunctionality() {
        screenAccessor.mcpvpinvhelper$setSkipNextRelease(true);

        if (screenAccessor.mcpvpinvhelper$getIsQuickCrafting() && screenAccessor.mcpvpinvhelper$getQuickCraftingButton() == 1) {
            screenAccessor.mcpvpinvhelper$setIsQuickCrafting(false);
            return true;
        }

        return false;
    }

    @Override
    public void clickSlot(Slot slot, MouseButton mouseButton, boolean shiftPressed) {
        screenAccessor.mcpvpinvhelper$invokeSlotClicked(
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
