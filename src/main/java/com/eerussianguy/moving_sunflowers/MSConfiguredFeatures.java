package com.eerussianguy.moving_sunflowers;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;

import static com.eerussianguy.moving_sunflowers.MovingSunflowers.MOD_ID;

public class MSConfiguredFeatures
{
    public static final ConfiguredFeature<?, ?> MOVING_SUNFLOWER_PATCH = createConfiguredFeature("sunflower_patch", Feature.RANDOM_PATCH.configured((
        new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(MSRegistry.SUNFLOWER.get().defaultBlockState()),
            new SunflowerBlockPlacer())).tries(64).noProjection().build()).decorated(Features.Placements.ADD_32)
            .decorated(Features.Placements.HEIGHTMAP_SQUARE).count(10));

    public static <FC extends IFeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String name, CF configuredFeature)
    {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(MOD_ID, name), configuredFeature);
        return configuredFeature;
    }
}
