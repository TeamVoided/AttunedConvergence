package org.teamvoided.attuned_convergence.compat

import org.teamvoided.attuned_convergence.compat.mod.ArchitectsPaletteCompat
import org.teamvoided.attuned_convergence.compat.mod.DusksAndDungeonsCompat
import org.teamvoided.attuned_convergence.compat.mod.MakeItGothCompat
import org.teamvoided.attuned_convergence.compat.mod.TwigsCompat
import org.teamvoided.attuned_convergence.compat.module.Module

object CompatManager {
    val COMPAT_LIST = mutableSetOf<Module>()

    fun init() {
        if (CompatVariables.DusksAndDungeons) DusksAndDungeonsCompat.populate(COMPAT_LIST)
        if (CompatVariables.ArchitectsPalette) ArchitectsPaletteCompat.populate(COMPAT_LIST)
        if (CompatVariables.Twigs) TwigsCompat.populate(COMPAT_LIST)
        if (CompatVariables.MakeItGoth) MakeItGothCompat.populate(COMPAT_LIST)
    }
}