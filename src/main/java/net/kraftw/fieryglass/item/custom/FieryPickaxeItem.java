package net.kraftw.fieryglass.item.custom;

import net.kraftw.fieryglass.item.ModToolMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FieryPickaxeItem extends PickaxeItem {

    public FieryPickaxeItem(Settings settings) {
        super(ModToolMaterial.FIERY, 2, -2.8f, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        target.setFireTicks(60);

        return super.postHit(stack, target, attacker);
    }



    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.fieryglass.fiery_pickaxe.tooltip").formatted(Formatting.GOLD));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
