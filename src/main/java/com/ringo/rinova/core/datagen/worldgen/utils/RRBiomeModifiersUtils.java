package com.ringo.rinova.core.datagen.worldgen.utils;

import com.ringo.rinova.RinovaMod;
import com.ringo.rinova.core.datagen.worldgen.biome_modifiers.RROreBiomeModifiers;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class RRBiomeModifiersUtils {
    // Точка входа для всех BiomeModifier нашего мода
    public static void bootstrap(BootstapContext<BiomeModifier> bootstrap) {
        // Сюда будем добавлять вызовы для групп фич
        RROreBiomeModifiers.bootstrap(bootstrap);
    }

    // Создаёт "паспорт" для BiomeModifier
    public static ResourceKey<BiomeModifier> registerKey(String path) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(RinovaMod.MOD_ID, path));
    }
}
