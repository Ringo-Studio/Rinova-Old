package com.ringo.rinova.core.datagen.worldgen.biome_modifiers;

import com.ringo.rinova.core.datagen.worldgen.placements.RROrePlacements;
import com.ringo.rinova.core.datagen.worldgen.utils.RRBiomeModifiersUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;


public class RROreBiomeModifiers {

    // 1. "Паспорт" для BiomeModifier
    public static final ResourceKey<BiomeModifier> OVERWORLD_PINKYLITE_ORE =
            RRBiomeModifiersUtils.registerKey("overworld_pinkylite_ore");

    // 2. Метод, вызываемый из утилиты
    public static void bootstrap(BootstapContext<BiomeModifier> context) {

        // 3. Получаем доступ к реестрам
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        // 4. Регистрируем BiomeModifier
        context.register(
                OVERWORLD_PINKYLITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(RROrePlacements.OVERWORLD_PINKYLITE_ORE)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
    }
}
