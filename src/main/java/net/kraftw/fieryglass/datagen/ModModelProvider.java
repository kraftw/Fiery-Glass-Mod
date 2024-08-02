package net.kraftw.fieryglass.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kraftw.fieryglass.block.ModBlocks;
import net.kraftw.fieryglass.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        // CUBES
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIERY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_FIERY_GLASS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIERY_LANTERN);

        // GLASS/PANES
        blockStateModelGenerator.registerGlassPane(ModBlocks.FIERY_GLASS, ModBlocks.FIERY_GLASS_PANE);

        // TORCHES
        blockStateModelGenerator.registerTorch(ModBlocks.FIERY_TORCH, ModBlocks.WALL_FIERY_TORCH);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.FIERY_GLASS_SHARD, Models.GENERATED);

    }

}
