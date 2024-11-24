package org.teamvoided.attuned_convergence.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static org.teamvoided.attuned_convergence.AttunedConvergence.log;

@Debug(export = true)
@Mixin(BlockItem.class)
public abstract class BlockItemMixin {
    @Inject(method = "getBlock", at = @At("HEAD"))
    void x(CallbackInfoReturnable<Block> cir) {
        log.info("{}", Registries.ITEM.getId((Item) (Object) this));
    }
}
