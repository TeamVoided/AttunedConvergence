package org.teamvoided.attuned_convergence.compat.mod

import architectspalette.core.registry.APBlocks
import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.CompatVariables.ARCHITECTS_PALETTE
import org.teamvoided.attuned_convergence.compat.module.DnDWood
import org.teamvoided.attuned_convergence.compat.module.Module

object ArchitectsPaletteCompat : Compat {
    override fun populate(content: MutableList<Module>) {
        if (CompatVariables.DusksAndDungeons) content.add(DnDWood(ARCHITECTS_PALETTE, "twisted", APBlocks.TWISTED_LOG.get()))
    }
}