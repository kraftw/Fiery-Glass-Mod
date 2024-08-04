package net.kraftw.fieryglass.item.custom;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.kraftw.fieryglass.item.ModItems;
import net.kraftw.fieryglass.item.ModToolMaterial;
import net.minecraft.block.Block;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class FieryPickaxeItem extends PickaxeItem {

    private static final Inventory inventory = new SimpleInventory(3);

    @Nullable
    private static Identifier lastRecipe;

    public FieryPickaxeItem(Settings settings) {
        super(ModToolMaterial.FIERY, 2, -2.8f, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        target.setFireTicks(60);

        return super.postHit(stack, target, attacker);
    }

    // CREDIT GOES TO OCHOTONIDA FOR THE AUTOSMELT IMPLEMENTATION https://github.com/ochotonida/artifacts
    public static ObjectArrayList<ItemStack> getModifiedBlockDrops(ObjectArrayList<ItemStack> items, LootContext context, TagKey<Block> ores, TagKey<Item> rawOres) {
        if (context.hasParameter(LootContextParameters.BLOCK_STATE)
                && context.hasParameter(LootContextParameters.THIS_ENTITY)
                && context.hasParameter(LootContextParameters.ORIGIN)
                && context.get(LootContextParameters.THIS_ENTITY) instanceof LivingEntity entity
                && entity.getEntityWorld() instanceof ServerWorld serverWorld
                && ((LivingEntity) context.get(LootContextParameters.THIS_ENTITY)).isHolding(ModItems.FIERY_PICKAXE)
                && context.get(LootContextParameters.BLOCK_STATE).isIn(ores)
        ) {
            ObjectArrayList<ItemStack> result = new ObjectArrayList<>(items.size());
            float experience = 0;
            for (ItemStack item : items) {
                ItemStack resultItem = item;
                if (item.isIn(rawOres)) {
                    Optional<AbstractCookingRecipe> recipe = getRecipeFor(item, serverWorld);
                    if (recipe.isPresent()) {
                        resultItem = recipe.get().craft(inventory, serverWorld.getRegistryManager());
                        resultItem.setCount(resultItem.getCount() * item.getCount());
                        experience += recipe.get().getExperience();
                    }
                }
                result.add(resultItem);
            }
            awardExperience(serverWorld, context.get(LootContextParameters.ORIGIN), experience);
            return result;
        }

        return items;
    }

    private static void awardExperience(ServerWorld serverWorld, Vec3d position, float experience) {
        int amount = MathHelper.floor(experience);
        if (Math.random() < MathHelper.fractionalPart(experience)) {
            amount++;
        }
        ExperienceOrbEntity.spawn(serverWorld, position, amount);
    }

    public static Optional<AbstractCookingRecipe> getRecipeFor(ItemStack item, World world) {
        inventory.clear();
        inventory.setStack(0, item);
        RecipeManager recipeManager = world.getRecipeManager();
        Optional<com.mojang.datafixers.util.Pair<Identifier, SmeltingRecipe>> optional = recipeManager.getFirstMatch(RecipeType.SMELTING, inventory, world, lastRecipe);
        if (optional.isPresent()) {
            Pair<Identifier, SmeltingRecipe> pair = optional.get();
            lastRecipe = pair.getFirst();
            return Optional.of(pair.getSecond());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.fieryglass.fiery_pickaxe.tooltip").formatted(Formatting.GOLD));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
