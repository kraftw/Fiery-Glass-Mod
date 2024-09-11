package net.kraftw.fieryglass.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.Stainable;
import net.minecraft.util.DyeColor;

import java.util.function.ToIntFunction;

public class FieryGlassPaneBlock extends PaneBlock implements Stainable {

    public FieryGlassPaneBlock(Settings settings) {

        // Sets Light Level to 12
        super(settings.luminance(new ToIntFunction<BlockState>() {
            @Override
            public int applyAsInt(BlockState value) {
                return 12;
            }
        }));

    }

    @Override
    public DyeColor getColor() {
        return DyeColor.ORANGE;
    }
    
}
