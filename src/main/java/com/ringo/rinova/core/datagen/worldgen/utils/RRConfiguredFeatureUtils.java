package com.ringo.rinova.core.datagen.worldgen.utils;

import com.ringo.rinova.RinovaMod;
import com.ringo.rinova.core.datagen.worldgen.features.RROreFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class RRConfiguredFeatureUtils {

    // Точка входа для всех ConfiguredFeature нашего мода
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> bootstrap) {
        // Сюда мы будем добавлять вызовы для разных групп фич
        RROreFeatures.bootstrap(bootstrap);
    }

    // Создаёт уникальный "паспорт" (ResourceKey) для нашей фичи
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String path) {
        return ResourceKey.create(
                Registries.CONFIGURED_FEATURE,
                new ResourceLocation(RinovaMod.MOD_ID, path)
        );
    }

    // Универсальный метод регистрации ConfiguredFeature
    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
