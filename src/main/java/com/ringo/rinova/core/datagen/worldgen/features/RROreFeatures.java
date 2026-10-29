package com.ringo.rinova.core.datagen.worldgen.features;

import com.ringo.rinova.core.datagen.worldgen.utils.RRConfiguredFeatureUtils;
import com.ringo.rinova.core.registry.RBlocks;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class RROreFeatures {

    // 1. Объявляем "паспорт" для нашей руды
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PINKYLITE_ORE =
            RRConfiguredFeatureUtils.registerKey("overworld_pinkylite_ore");

    // 2. Метод, который будет вызван из утилиты
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        // 3. Определяем, какие блоки можно заменять
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // 4. Говорим: "Заменяем глубокий сланец и камень на нашу руду"
        List<OreConfiguration.TargetBlockState> targets = List.of(
                OreConfiguration.target(deepslateReplaceable, RBlocks.DEEPSLATE_PINKYLITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(stoneReplaceable, RBlocks.PINKYLITE_ORE.get().defaultBlockState())
        );

        // 5. Регистрируем ConfiguredFeature через нашу утилиту
        RRConfiguredFeatureUtils.register(
                context,
                OVERWORLD_PINKYLITE_ORE,
                Feature.ORE,
                new OreConfiguration(targets, 3, 1.0f) // размер жилы = 3, сглаживание = 1.0
        );
    }
}