package net.kraftw.fieryglass.painting;

import net.kraftw.fieryglass.FieryGlassMod;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings {

    public static final PaintingVariant DEPTHS = registerPainting("depths", new PaintingVariant(16, 48));
    public static final PaintingVariant POSTER = registerPainting("poster", new PaintingVariant(32, 48));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(FieryGlassMod.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings() {

    }

}
