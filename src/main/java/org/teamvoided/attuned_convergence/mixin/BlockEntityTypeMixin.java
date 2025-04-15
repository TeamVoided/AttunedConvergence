package org.teamvoided.attuned_convergence.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.attuned_convergence.compat.CompatManager.BE_COMPAT_CHECKS;

@Mixin(value = BlockEntityType.class, remap = false)
public abstract class BlockEntityTypeMixin {
    @ModifyReturnValue(method = "supports", at = @At("RETURN"))
    private boolean x(boolean original, BlockState state) {
        if (!original) {
            var type = (BlockEntityType<?>) (Object) this;
            var check = BE_COMPAT_CHECKS.get(type);
            return (check != null) ? check.invoke(state, type) : false;
        }
        return true;
    }
}
