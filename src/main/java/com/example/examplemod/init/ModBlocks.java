package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.blocks.BlockBasic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid = ExampleMod.MODID)
public class ModBlocks {

    static Block javaBlock;
    static Block jukeboxBlock;

    public static void init(){
        javaBlock = new BlockBasic("javaBlock", Material.ROCK).setHardness(1.5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        jukeboxBlock = new BlockBasic("jukeboxBlock", Material.WOOD).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(javaBlock, jukeboxBlock);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(new ItemBlock(javaBlock).setRegistryName(javaBlock.getRegistryName()), new ItemBlock(jukeboxBlock).setRegistryName(jukeboxBlock.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(Item.getItemFromBlock(javaBlock));
        registerRender(Item.getItemFromBlock(jukeboxBlock));
    }

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
