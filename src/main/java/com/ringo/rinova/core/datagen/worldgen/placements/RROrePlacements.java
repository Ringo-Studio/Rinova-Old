package com.ringo.rinova.core.datagen.worldgen.placements;

import com.ringo.rinova.core.datagen.worldgen.features.RROreFeatures;
import com.ringo.rinova.core.datagen.worldgen.utils.RRPlacedFeatureUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class RROrePlacements {

    // 1. "Паспорт" для PlacedFeature
    public static final ResourceKey<PlacedFeature> OVERWORLD_PINKYLITE_ORE =
            RRPlacedFeatureUtils.registerKey("overworld_pinkylite_ore");

    // 2. Метод, вызываемый из утилиты
    public static void bootstrap(BootstapContext<PlacedFeature> context) {

        // 3. Получаем доступ к реестру ConfiguredFeature
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // 4. Регистрируем PlacedFeature через утилиту
        RRPlacedFeatureUtils.register(
                context,
                OVERWORLD_PINKYLITE_ORE,
                configuredFeatures.getOrThrow(RROreFeatures.OVERWORLD_PINKYLITE_ORE),
                RRPlacedFeatureUtils.OrePlacement.commonOrePlacement(
                        10,  // 10 жил на чанк
                        HeightRangePlacement.triangle(
                                VerticalAnchor.aboveBottom(-10),  // минимальная высота
                                VerticalAnchor.absolute(45)       // максимальная высота
                        )
                )
        );
    }
}
