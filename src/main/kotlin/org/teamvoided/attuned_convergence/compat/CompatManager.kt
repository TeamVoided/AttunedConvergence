package org.teamvoided.attuned_convergence.compat

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityType
import org.teamvoided.attuned_convergence.compat.mod.ArchitectsPaletteCompat
import org.teamvoided.attuned_convergence.compat.mod.DusksAndDungeonsCompat
import org.teamvoided.attuned_convergence.compat.mod.MakeItGothCompat
import org.teamvoided.attuned_convergence.compat.mod.TwigsCompat
import org.teamvoided.attuned_convergence.compat.module.Module


typealias BECompatCheck = (sate: BlockState, type: BlockEntityType<*>) -> Boolean

object CompatManager {
    val COMPAT_LIST = mutableSetOf<Module>()
    @JvmField
    val BE_COMPAT_CHECKS = mutableMapOf<BlockEntityType<*>, BECompatCheck>()

    fun init() {
        if (CompatVariables.DusksAndDungeons) DusksAndDungeonsCompat.populate(COMPAT_LIST)
        if (CompatVariables.ArchitectsPalette) ArchitectsPaletteCompat.populate(COMPAT_LIST)
        if (CompatVariables.Twigs) TwigsCompat.populate(COMPAT_LIST)
        if (CompatVariables.MakeItGoth) MakeItGothCompat.populate(COMPAT_LIST)
    }
}