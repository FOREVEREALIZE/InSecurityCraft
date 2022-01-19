package me.foreverealize.insecuritycraft;

import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("insecuritycraft")
public class InSecurityCraft {
    public InSecurityCraft() {
        MessageHandler.init();
    }
}
