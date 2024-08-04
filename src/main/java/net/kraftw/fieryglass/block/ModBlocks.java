package net.kraftw.fieryglass.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kraftw.fieryglass.block.custom.FieryGlassBlock;
import net.kraftw.fieryglass.block.custom.FieryGlassLanternBlock;
import net.kraftw.fieryglass.block.custom.FieryGlassPaneBlock;
import net.kraftw.fieryglass.particle.ModParticles;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // -BLOCK REGISTERING-
    // DECORATION
    public static final Block FIERY_GLASS = registerBlock("fiery_glass",
            new FieryGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).luminance(12).nonOpaque()));
    public static final Block FIERY_GLASS_PANE = registerBlock("fiery_glass_pane",
            new FieryGlassPaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).luminance(12).nonOpaque()));
    public static final Block FIERY_LANTERN = registerBlock("fiery_lantern",
            new Block(FabricBlockSettings.copyOf(Blocks.GLOWSTONE)));
    public static final Block FIERY_GLASS_LANTERN = registerBlock("fiery_glass_lantern",
            new FieryGlassLanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN).luminance(15)));
    // TORCH
    public static final Block FIERY_TORCH = registerBlock("fiery_torch",
            new TorchBlock(FabricBlockSettings.create().noCollision().breakInstantly().luminance(15).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY), ModParticles.FIERY_FLAME_PARTICLE));
    public static final Block WALL_FIERY_TORCH = registerBlock("wall_fiery_torch",
            new WallTorchBlock(FabricBlockSettings.create().noCollision().breakInstantly().luminance(15).sounds(BlockSoundGroup.WOOD).dropsLike(Blocks.TORCH).pistonBehavior(PistonBehavior.DESTROY), ModParticles.FIERY_FLAME_PARTICLE));
    // COMPACTING
    public static final Block FIERY_BLOCK = registerBlock("fiery_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GLOWSTONE)));
    // ORE
    public static final Block DEEPSLATE_FIERY_GLASS_ORE = registerBlock("deepslate_fiery_glass_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COAL_ORE).luminance(8)));



    // -HELPER METHODS-
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(net.kraftw.fieryglass.FieryGlassMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(net.kraftw.fieryglass.FieryGlassMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

}
