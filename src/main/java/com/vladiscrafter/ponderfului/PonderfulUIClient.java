package com.vladiscrafter.ponderfului;

import net.createmod.catnip.config.ui.BaseConfigScreen;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;

import java.util.function.Supplier;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = PonderfulUI.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = PonderfulUI.MOD_ID, value = Dist.CLIENT)
public class PonderfulUIClient {
    public PonderfulUIClient(IEventBus modEventBus, ModContainer container) {
        IEventBus forgeBus = NeoForge.EVENT_BUS;
        modEventBus.addListener(PonderfulUIClient::onLoadComplete);
        // container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        PonderfulUI.LOGGER.info("HELLO FROM CLIENT SETUP");
        PonderfulUI.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    public static void onLoadComplete(FMLLoadCompleteEvent evt) {
        ModContainer container = ModList.get()
                .getModContainerById(PonderfulUI.MOD_ID)
                .orElseThrow(() -> new IllegalStateException("Create: Ponderful UI mod container missing on LoadComplete"));
        Supplier<IConfigScreenFactory> configScreen = () -> (mc, previousScreen) -> new BaseConfigScreen(previousScreen, PonderfulUI.MOD_ID);
        container.registerExtensionPoint(IConfigScreenFactory.class, configScreen);
    }
}