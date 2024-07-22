package net.kraftw.fieryglass.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final DefaultParticleType FIERY_FLAME_PARTICLE =
            registerParticle("fiery_flame_particle", FabricParticleTypes.simple());



    // -HELPER METHOD-
    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(net.kraftw.fieryglass.FieryGlassMod.MOD_ID, name), particleType);
    }

    public static void registerModParticles() {

    }

}
