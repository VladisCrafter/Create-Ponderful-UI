package com.vladiscrafter.ponderfului;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.vladiscrafter.ponderfului.config.PonderfulUIConfigs;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.event.config.ModConfigEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(PonderfulUI.MOD_ID)
public class PonderfulUI {
    public static final String MOD_ID = "ponderful_ui";
    // public static final String NAME = "Create: Ponderful UI";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(PonderfulUI.MOD_ID);

    public PonderfulUI(IEventBus modEventBus, ModContainer modContainer) {
        IEventBus forgeBus = NeoForge.EVENT_BUS;
        modEventBus.addListener(this::commonSetup);
        ModLoadingContext mlContext = ModLoadingContext.get();

        PonderfulUI.REGISTRATE.registerEventListeners(modEventBus);

        PonderfulUIConfigs.registerConfigs(mlContext.getActiveContainer()::registerConfig);

        modEventBus.addListener(this::onLoadConfig);
        modEventBus.addListener(this::onReloadConfig);

        // NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        // modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        // modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    private void onLoadConfig(ModConfigEvent.Loading evt) {
        PonderfulUIConfigs.onLoad(evt.getConfig());
    }

    private void onReloadConfig(ModConfigEvent.Reloading evt) {
        PonderfulUIConfigs.onReload(evt.getConfig());
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
