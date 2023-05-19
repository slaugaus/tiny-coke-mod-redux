package com.slaugaus.tinycokeredux.init;

import com.slaugaus.tinycokeredux.TinyCoke;
import net.minecraft.world.item.*;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TinyCoke.MODID);
    
    public static final RegistryObject<Item> TINY = ITEMS.register("tinycoke",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HALF = ITEMS.register("halfcoke",
            () -> new Item(new Item.Properties()));

//    private void addCreative(CreativeModeTabEvent.BuildContents event)
//    {
//        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
//            event.accept();
//    }
    
//    public static class ModCreativeTab extends CreativeModeTab {
//        private ModCreativeTab(int index, String label) {
//            super(index, label);
//        }
//        
//        @Override
//        public ItemStack makeIcon() {
//            return new ItemStack(TINY.get());
//        }
//
//        public static final ModCreativeTab instance = 
//                new ModCreativeTab(CreativeModeTab.TABS.length, TinyCoke.MODID);
//    }
}
