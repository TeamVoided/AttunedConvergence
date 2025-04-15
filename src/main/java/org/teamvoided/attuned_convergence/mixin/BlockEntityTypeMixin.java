package org.teamvoided.attuned_convergence.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.teamvoided.attuned_convergence.block.ACCabinetBlock;

@Mixin(value = BlockEntityType.class, remap = false)
public abstract class BlockEntityTypeMixin {
    @ModifyReturnValue(method = "supports", at = @At("RETURN"))
    private boolean x(boolean original, BlockState state) {
        return original || ACCabinetBlock.isCabinet(state, (BlockEntityType<?>) (Object) this);
    }
}
