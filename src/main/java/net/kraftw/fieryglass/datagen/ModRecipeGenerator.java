package net.kraftw.fieryglass.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kraftw.fieryglass.block.ModBlocks;
import net.kraftw.fieryglass.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        // -COMPACTING RECIPES-
        // FIERY SHARDS <-> FIERY LAMP BLOCk
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.FIERY_GLASS_SHARD,
                RecipeCategory.MISC, ModBlocks.FIERY_LAMP_BLOCK);

        // -SMELTING RECIPES-
        // DEEPSLATE FIERY GLASS ORE -> FIERY GLASS SHARD
        offerSmelting(exporter, List.of(ModBlocks.DEEPSLATE_FIERY_GLASS_ORE), RecipeCategory.MISC, ModItems.FIERY_GLASS_SHARD,
                0.7f, 200, "fiery_glass");

        // -BLASTING RECIPES-
        // DEEPSLATE FIERY GLASS ORE -> FIERY GLASS SHARD
        offerBlasting(exporter, List.of(ModBlocks.DEEPSLATE_FIERY_GLASS_ORE), RecipeCategory.MISC, ModItems.FIERY_GLASS_SHARD,
                0.7f, 100, "fiery_glass");

        // -WALLS/PANES-
        // FIERY GLASS PANE
        offerWallRecipe(exporter, RecipeCategory.MISC, ModBlocks.FIERY_GLASS_PANE, ModBlocks.FIERY_GLASS);

    }

}
