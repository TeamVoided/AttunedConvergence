package org.teamvoided.attuned_convergence.compat.mod

import com.ninni.twigs.registry.TwigsBlocks
import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.CompatVariables.TWIGS
import org.teamvoided.attuned_convergence.compat.module.ArchitectsPaletteNub
import org.teamvoided.attuned_convergence.compat.module.Module

object TwigsCompat : Compat {
    override fun populate(content: MutableSet<Module>) {
        if (CompatVariables.ArchitectsPalette) {
            content.add(ArchitectsPaletteNub(TWIGS, "schist", TwigsBlocks.SCHIST))
            content.add(ArchitectsPaletteNub(TWIGS, "rhyolite", TwigsBlocks.RHYOLITE))
        }
    }
}