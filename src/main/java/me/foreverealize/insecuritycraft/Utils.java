package me.foreverealize.insecuritycraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class Utils {
    public static String getChestCode(Integer x, Integer y, Integer z) {
        ClientLevel world = Minecraft.getInstance().level;
        assert world != null;
        BlockState block = world.getBlockState(new BlockPos(x, y, z));
        System.out.println(block.getProperties());
        block.getProperties().forEach((prop) -> {
            System.out.println(prop.getName() + ": " + prop.getValue(prop.getName()));
        });
        return "Shut up IDEA";
    }
}
