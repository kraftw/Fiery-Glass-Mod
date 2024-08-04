package net.kraftw.fieryglass.block.custom;

import net.kraftw.fieryglass.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.function.ToIntFunction;

public class FieryGlassLanternBlock extends LanternBlock {

    public FieryGlassLanternBlock(Settings settings) {
        super(settings.luminance(new ToIntFunction<BlockState>() {
            @Override
            public int applyAsInt(BlockState value) {
                return 15;
            }
        }));
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + 0.5;
        double e = (double)pos.getY() + 0.5;
        double f = (double)pos.getZ() + 0.5;
        world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0, 0.0, 0.0);
        world.addParticle(ModParticles.FIERY_FLAME_PARTICLE, d, e, f, 0.0, 0.0, 0.0);
    }

}
