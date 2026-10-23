package com.m4ssivee.mousetweaksmcpvp.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import com.m4ssivee.mousetweaksmcpvp.Main;
import com.m4ssivee.mousetweaksmcpvp.MouseButton;

public class MouseTweaksForMCPVPFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Main.initialize();

        ScreenEvents.BEFORE_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            ScreenMouseEvents.allowMouseClick(screen).register((_screen, x, y, eventButton) -> {
                MouseButton button = MouseButton.fromEventButton(eventButton);
                if (button != null)
                    return !Main.onMouseClicked(screen, x, y, button);
                return true;
            });

            ScreenMouseEvents.allowMouseRelease(screen).register((_screen, x, y, eventButton) -> {
                MouseButton button = MouseButton.fromEventButton(eventButton);
                if (button != null)
                    return !Main.onMouseReleased(screen, x, y, button);
                return true;
            });

            ScreenMouseEvents.afterMouseScroll(screen).register((_screen, x, y, horiz, vert) ->
                    Main.onMouseScrolled(screen, x, y, vert));
        });
    }
}
