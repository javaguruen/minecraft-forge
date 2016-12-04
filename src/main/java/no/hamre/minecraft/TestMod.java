package no.hamre.minecraft;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = TestMod.MODID, version = TestMod.VERSION)
public class TestMod {
    public static final String MODID = "TestMod";
    public static final String VERSION = "1.1";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("TestMod init");
        //MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
        MinecraftForge.EVENT_BUS.register(new TreeSaver());
        MinecraftForge.EVENT_BUS.register(new DiamondPig());
    }

    @EventHandler
    public void registerCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new FlamingCows());
    }
}





