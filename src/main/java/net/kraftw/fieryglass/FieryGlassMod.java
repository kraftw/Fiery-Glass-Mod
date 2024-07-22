package net.kraftw.fieryglass;

import net.fabricmc.api.ModInitializer;
import net.kraftw.fieryglass.item.ModItemGroup;
import net.kraftw.fieryglass.util.ModRegistries;
import net.kraftw.fieryglass.world.gen.ModWorldGeneration;

public class FieryGlassMod implements ModInitializer {

    public static final String MOD_ID = "fieryglass";

    @Override
    public void onInitialize() {

        ModItemGroup.registerItemGroups();
        ModRegistries.registerServerModUtil();
        ModWorldGeneration.generateModWorldGeneration();

    }
}
