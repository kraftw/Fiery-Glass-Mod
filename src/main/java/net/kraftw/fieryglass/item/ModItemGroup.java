package net.kraftw.fieryglass.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kraftw.fieryglass.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup FIERY_GLASS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(net.kraftw.fieryglass.FieryGlassMod.MOD_ID, "fiery_glass_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fiery_glass_group"))
                    .icon(() -> new ItemStack(ModItems.FIERY_GLASS_SHARD)).entries((displayContext, entries) -> {

                        entries.add(ModItems.FIERY_GLASS_SHARD);
                        entries.add(ModItems.FIERY_TORCH_ITEM);
                        entries.add(ModBlocks.FIERY_GLASS_LANTERN);
                        entries.add(ModBlocks.FIERY_GLASS);
                        entries.add(ModBlocks.FIERY_GLASS_PANE);
                        entries.add(ModBlocks.FIERY_LANTERN);
                        entries.add(ModBlocks.FIERY_BLOCK);
                        entries.add(ModBlocks.FIERY_STAIRS);
                        entries.add(ModBlocks.FIERY_SLAB);
                        entries.add(ModItems.FIERY_PICKAXE);
                        entries.add(ModBlocks.DEEPSLATE_FIERY_GLASS_ORE);

                    }).build());

    public static void registerItemGroups() {

    }

}
