package com.example.examplemod.blocks;
import com.example.examplemod.ExampleMod;
import com.example.examplemod.sounds.BlockSoundHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.awt.*;
import java.util.logging.Logger;

public class BlockBasic extends Block{
    public BlockBasic(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    boolean music_state = true;

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Logger.getLogger(ExampleMod.MODID).info("CLICK DETECTED" + this.getUnlocalizedName());


        if (worldIn.isRemote){//check of world client side of server side is
            if (this.getUnlocalizedName().equals("tile.jukeboxBlock")){ //check of de aangeklikte block mijn jukebox block is
                if (music_state){
                    worldIn.playSound(playerIn, pos, BlockSoundHandler.jukeboxBlock, SoundCategory.BLOCKS, 1.0F, 1.0F); //start eigen audio
                    playerIn.sendMessage(new TextComponentString("Gemar's Jukebox: Playing Angel in the morning")); //send een chat bericht naar de player die de block aantikt
                    music_state = false;
                }else {
                    Minecraft.getMinecraft().getSoundHandler().stopSounds();
                    playerIn.sendMessage(new TextComponentString("Gemar's Jukebox: Stopping music"));
                    music_state = true;
                }
                return true; //true is click wordt geregistreerd
            }
        }

        return false; //false is click wordt niet geregistreerd
    }
}
