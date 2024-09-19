package net.kraftw.fieryglass.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kraftw.fieryglass.block.ModBlocks;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {

    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        // SELF DROPPING
        addDrop(ModBlocks.FIERY_BLOCK);
        addDrop(ModBlocks.FIERY_STAIRS);
        addDrop(ModBlocks.FIERY_SLAB, slabDrops(ModBlocks.FIERY_SLAB));
        addDrop(ModBlocks.FIERY_TORCH);
        addDrop(ModBlocks.FIERY_LANTERN);
        addDrop(ModBlocks.FIERY_GLASS_LANTERN);
        addDrop(ModBlocks.FIERY_GLASS_DOOR, doorDrops(ModBlocks.FIERY_GLASS_DOOR));
        addDrop(ModBlocks.FIERY_GLASS_TRAPDOOR);

    }

}
