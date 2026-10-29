package com.ringo.rinova.core.datagen.worldgen.utils;

import com.ringo.rinova.RinovaMod;
import com.ringo.rinova.core.datagen.worldgen.placements.RROrePlacements;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class RRPlacedFeatureUtils {
    // Точка входа для всех PlacedFeature нашего мода
    public static void bootstrap(BootstapContext<PlacedFeature> bootstrap) {
        // Сюда будем добавлять вызовы для групп фич
        RROrePlacements.bootstrap(bootstrap);
    }

    // Создаёт "паспорт" для PlacedFeature
    public static ResourceKey<PlacedFeature> registerKey(String path) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(RinovaMod.MOD_ID, path));
    }

    // Универсальный метод регистрации PlacedFeature
    public static void register(
            BootstapContext<PlacedFeature> context,
            ResourceKey<PlacedFeature> key,
            Holder<ConfiguredFeature<?, ?>> configuration,
            List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    // Вспомогательные методы для рудных размещений
    public static class OrePlacement {
        public static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
            return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
        }

        public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier height) {
            return orePlacement(CountPlacement.of(count), height);
        }

        public static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier height) {
            return orePlacement(RarityFilter.onAverageOnceEvery(chance), height);
        }
    }
}
