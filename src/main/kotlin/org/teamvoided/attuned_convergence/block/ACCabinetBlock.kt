package org.teamvoided.attuned_convergence.block

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityType
import vectorwing.farmersdelight.common.block.CabinetBlock
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes

class ACCabinetBlock(properties: Settings) : CabinetBlock(properties) {
    companion object {
        @JvmStatic
        fun isCabinet(state: BlockState, type: BlockEntityType<*>): Boolean =
            type == ModBlockEntityTypes.CABINET.get() && state.block is ACCabinetBlock
    }
}