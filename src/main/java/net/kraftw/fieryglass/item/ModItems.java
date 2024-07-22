package net.kraftw.fieryglass.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kraftw.fieryglass.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModItems {

    // -ITEM REGISTERING-
    public static final Item FIERY_GLASS_SHARD = registerItem("fiery_glass_shard",
            new Item(new FabricItemSettings()));
    public static final Item FIERY_TORCH_ITEM = registerItem("fiery_torch_item",
            new VerticallyAttachableBlockItem(ModBlocks.FIERY_TORCH, ModBlocks.WALL_FIERY_TORCH, new FabricItemSettings(), Direction.DOWN));



    // -HELPER METHOD-
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(net.kraftw.fieryglass.FieryGlassMod.MOD_ID, name), item);
    }

}
