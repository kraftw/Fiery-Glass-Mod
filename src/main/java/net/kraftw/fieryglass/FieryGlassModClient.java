package net.kraftw.fieryglass;

import net.fabricmc.api.ClientModInitializer;
import net.kraftw.fieryglass.util.ModRegistries;

public class FieryGlassModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModRegistries.registerClientModUtil();

    }
}
