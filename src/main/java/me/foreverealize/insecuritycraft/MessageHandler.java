package me.foreverealize.insecuritycraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.UUID;

public class MessageHandler {
    public MessageHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChatMessage(final ClientChatEvent event) {
        if (event.getMessage().startsWith("!")) {
            if (event.getMessage().startsWith("!getchestcode")) {
                String[] cmd = event.getMessage().split(" ");
                LocalPlayer player = Minecraft.getInstance().player;
                if (cmd.length == 4) {
                    String message = "Chest code: " + Utils.getChestCode(Integer.valueOf(cmd[1]), Integer.valueOf(cmd[2]), Integer.valueOf(cmd[3]));
                    assert player != null;
                    sendMessage(player, message, player.getUUID());
                } else {
                    String message1 = "Gets a chest's code.";
                    String message2 = "Usage: !getchestcode X Y Z";
                    assert player != null;
                    sendMessage(player, message1, player.getUUID());
                    sendMessage(player, message2, player.getUUID());
                }
                event.setCanceled(true);
            }
        }
    }

    public void sendMessage(LocalPlayer player, String message, UUID uuid) {
        player.sendMessage(new TextComponent(message), uuid);
    }
}
