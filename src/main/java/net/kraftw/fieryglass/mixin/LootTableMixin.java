package net.kraftw.fieryglass.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.kraftw.fieryglass.item.custom.FieryPickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LootTable.class)
public class LootTableMixin {

    @ModifyReturnValue(method = "generateLoot(Lnet/minecraft/loot/context/LootContext;)Lit/unimi/dsi/fastutil/objects/ObjectArrayList;", at = @At("RETURN"))
    public ObjectArrayList<ItemStack> getDroppedStacks(ObjectArrayList<ItemStack> original, LootContext context) {
        return FieryPickaxeItem.getModifiedBlockDrops(original, context, ConventionalBlockTags.ORES, ConventionalItemTags.RAW_ORES);
    }
}
