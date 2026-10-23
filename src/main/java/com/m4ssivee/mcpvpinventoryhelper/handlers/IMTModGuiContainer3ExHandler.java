package com.m4ssivee.mcpvpinventoryhelper.handlers;

import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import com.m4ssivee.mcpvpinventoryhelper.IGuiScreenHandler;
import com.m4ssivee.mcpvpinventoryhelper.MouseButton;
import com.m4ssivee.mcpvpinventoryhelper.api.IMTModGuiContainer3Ex;

import java.util.List;

public class IMTModGuiContainer3ExHandler implements IGuiScreenHandler {
    private final IMTModGuiContainer3Ex modGuiContainer;

    public IMTModGuiContainer3ExHandler(IMTModGuiContainer3Ex modGuiContainer) {
        this.modGuiContainer = modGuiContainer;
    }

    @Override
    public boolean isMouseTweaksDisabled() {
        return modGuiContainer.MT_isMouseTweaksDisabled();
    }

    @Override
    public boolean isWheelTweakDisabled() {
        return modGuiContainer.MT_isWheelTweakDisabled();
    }

    @Override
    public List<Slot> getSlots() {
        return modGuiContainer.MT_getSlots();
    }

    @Override
    public Slot getSlotUnderMouse(double mouseX, double mouseY) {
        return modGuiContainer.MT_getSlotUnderMouse(mouseX, mouseY);
    }

    @Override
    public boolean disableRMBDraggingFunctionality() {
        return modGuiContainer.MT_disableRMBDraggingFunctionality();
    }

    @Override
    public void clickSlot(Slot slot, MouseButton mouseButton, boolean shiftPressed) {
        modGuiContainer.MT_clickSlot(slot,
                mouseButton.getValue(),
                shiftPressed ? ClickType.QUICK_MOVE : ClickType.PICKUP);
    }

    @Override
    public boolean isCraftingOutput(Slot slot) {
        return modGuiContainer.MT_isCraftingOutput(slot);
    }

    @Override
    public boolean isIgnored(Slot slot) {
        return modGuiContainer.MT_isIgnored(slot);
    }
}
