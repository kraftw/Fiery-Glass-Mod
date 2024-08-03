package net.kraftw.fieryglass.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.kraftw.fieryglass.FieryGlassMod;
import net.kraftw.fieryglass.block.ModBlocks;
import net.kraftw.fieryglass.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {

    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.FIERY_GLASS_SHARD),
                        Text.translatable("advancements.fieryglass.fiery_glass.title"), Text.translatable("advancements.fieryglass.fiery_glass.description"),
                        new Identifier(FieryGlassMod.MOD_ID, "textures/block/fiery_block.png"), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_fiery_glass", InventoryChangedCriterion.Conditions.items(ModBlocks.FIERY_GLASS))
                .build(consumer, FieryGlassMod.MOD_ID + ":fieryglass");
    }

}
