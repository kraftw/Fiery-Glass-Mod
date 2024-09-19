package net.kraftw.fieryglass.block.custom;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;

import java.util.function.ToIntFunction;

public class FieryGlassDoorBlock extends DoorBlock {

    public FieryGlassDoorBlock(Settings settings, BlockSetType blockSetType) {
        super(settings.luminance(new ToIntFunction<BlockState>() {
            @Override
            public int applyAsInt(BlockState value) {
                return 12;
            }
        }), blockSetType);
    }

}
