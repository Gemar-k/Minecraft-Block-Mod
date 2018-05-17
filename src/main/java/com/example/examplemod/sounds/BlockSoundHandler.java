package com.example.examplemod.sounds;

import com.example.examplemod.ExampleMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//registreert alle custom geluiden die in de sounds.json beschreven staan
@Mod.EventBusSubscriber
public class BlockSoundHandler {

    public static SoundEvent jukeboxBlock = createSoundEvent("jukeboxblock_sound");


    public static SoundEvent createSoundEvent(String soundName) {
        final ResourceLocation soundID = new ResourceLocation(ExampleMod.MODID, soundName);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }

    @SubscribeEvent
    public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(jukeboxBlock);
    }
}
