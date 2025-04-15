package org.teamvoided.attuned_convergence.block

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityType
import org.teamvoided.attuned_convergence.compat.CompatManager
import vectorwing.farmersdelight.common.block.CabinetBlock
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes

class ACCabinetBlock(properties: Settings) : CabinetBlock(properties) {
    init {
        CompatManager.BE_COMPAT_CHECKS.putIfAbsent(ModBlockEntityTypes.CABINET.get(), ::isCabinet)
    }

    companion object {
        @JvmStatic
        fun isCabinet(state: BlockState, type: BlockEntityType<*>): Boolean =
            type == ModBlockEntityTypes.CABINET.get() && state.block is ACCabinetBlock
    }
}