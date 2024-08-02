package net.kraftw.fieryglass.util;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kraftw.fieryglass.block.ModBlocks;
import net.kraftw.fieryglass.item.ModItems;
import net.kraftw.fieryglass.particle.FieryFlameParticle;
import net.kraftw.fieryglass.particle.ModParticles;
import net.minecraft.client.render.RenderLayer;

public class ModRegistries {

    // -SERVER-
    public static void registerServerModUtil() {
        registerFuels();
    }

    // -CLIENT-
    public static void registerClientModUtil() {

        // RENDER LAYERS
        registerTranslucentBlocks();
        registerTransparentBlocks();

        // PARTICLES
        ParticleFactoryRegistry.getInstance().register(ModParticles.FIERY_FLAME_PARTICLE, FieryFlameParticle.Factory::new);

    }



    // -REGISTERING METHODS-
    private static void registerTransparentBlocks() {

        BlockRenderLayerMap registry = BlockRenderLayerMap.INSTANCE;

        registry.putBlock(ModBlocks.FIERY_TORCH, RenderLayer.getCutout());
        registry.putBlock(ModBlocks.WALL_FIERY_TORCH, RenderLayer.getCutout());

    }

    private static void registerTranslucentBlocks() {

        BlockRenderLayerMap registry = BlockRenderLayerMap.INSTANCE;

        registry.putBlock(ModBlocks.FIERY_GLASS, RenderLayer.getTranslucent());
        registry.putBlock(ModBlocks.FIERY_GLASS_PANE, RenderLayer.getTranslucent());

    }

    private static void registerFuels() {

        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.FIERY_GLASS_SHARD, 2400);
        registry.add(ModBlocks.FIERY_BLOCK, 24000);

    }

}
