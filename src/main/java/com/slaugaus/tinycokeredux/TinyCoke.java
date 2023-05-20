package com.slaugaus.tinycokeredux;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TinyCoke.MODID)
public class TinyCoke
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tinycoke2";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TinyCoke()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Register the Deferred Register to the mod event bus so items get registered
        ModItems.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the items to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    // Places custom items in the "Ingredients" Creative Mode tab
    private void addCreative(CreativeModeTabEvent.BuildContents event){
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.TINY);
            event.accept(ModItems.HALF);
        }
    }

    @Mod.EventBusSubscriber(modid = MODID)
    public static class SomeEvents
    {
        // When "FurnaceFuelBurnTimeEvent" fires, this code runs
        // Sets the fuel properties of my 2 custom items
        @SubscribeEvent
        public static void setBurnTimes(FurnaceFuelBurnTimeEvent event) {
            Item item = event.getItemStack().getItem();
            // Tiny Coke smelts 1 item
            if (item == ModItems.TINY.get()) {
                event.setBurnTime(200);
            }
            // Half Coke smelts 8 items (same as normal coal)
            else if (item == ModItems.HALF.get()) {
                event.setBurnTime(1600);
            }
        }
    }
}
