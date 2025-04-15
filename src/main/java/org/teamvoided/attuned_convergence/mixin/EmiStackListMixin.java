package org.teamvoided.attuned_convergence.mixin;

import dev.emi.emi.registry.EmiStackList;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static org.teamvoided.attuned_convergence.AttunedConvergence.log;

@Mixin(value = EmiStackList.class, remap = false)
public abstract class EmiStackListMixin {
    @Redirect(method = "isHiddenFromRecipeViewers", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/BlockItem;getBlock()Lnet/minecraft/block/Block;"))
    private static Block x(BlockItem instance) {
        var x = instance.getBlock();
        if (x == null) log.info("Block item is null: {}", Registries.ITEM.getId(instance));
        return x;
    }
}
