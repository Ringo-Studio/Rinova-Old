package com.ringo.rinova.core.datagen.worldgen;

import com.ringo.rinova.RinovaMod;
import com.ringo.rinova.core.datagen.worldgen.utils.RRBiomeModifiersUtils;
import com.ringo.rinova.core.datagen.worldgen.utils.RRConfiguredFeatureUtils;
import com.ringo.rinova.core.datagen.worldgen.utils.RRPlacedFeatureUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RWorldgenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, RRConfiguredFeatureUtils::bootstrap)
            .add(Registries.PLACED_FEATURE, RRPlacedFeatureUtils::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, RRBiomeModifiersUtils::bootstrap);

    public RWorldgenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(RinovaMod.MOD_ID));
    }
}
