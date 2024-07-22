package net.kraftw.fieryglass.particle;


import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class FieryFlameParticle extends SpriteBillboardParticle {

    protected FieryFlameParticle(ClientWorld world, double xCoord, double yCoord, double zCoord,
                                 SpriteProvider spriteSet, double xDirection, double yDirection, double zDirection) {

        super(world, xCoord, yCoord, zCoord, xDirection, yDirection, zDirection);

        this.velocityMultiplier = 0.5f;
        this.velocityX = xDirection;
        this.velocityY = yDirection;
        this.velocityZ = zDirection;

        this.scale *= 1.25f;
        this.maxAge = 10;
        this.setSpriteForAge(spriteSet);

        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;

    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {

        private final SpriteProvider sprites;
        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld,
                                       double x, double y, double z, double xd, double yd, double zd) {

            return new FieryFlameParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);

        }

    }

}
