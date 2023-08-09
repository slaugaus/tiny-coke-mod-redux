package com.slaugaus.tinycokeredux;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, TinyCoke.MODID);
    
    // TINY COKE
    public static final RegistryObject<Item> TINY = ITEMS.register("tiny_coke",
            () -> new Item(new Item.Properties()));
    
    // HALF COKE
    public static final RegistryObject<Item> HALF = ITEMS.register("half_coke",
        () -> new Item(new Item.Properties()));
    
    // Actually register the items now that they're defined
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
