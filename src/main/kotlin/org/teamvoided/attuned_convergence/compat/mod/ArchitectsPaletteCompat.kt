package org.teamvoided.attuned_convergence.compat.mod

import architectspalette.core.registry.APBlocks
import architectspalette.core.registry.util.StoneBlockSet.SetComponent.SLAB
import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.CompatVariables.ARCHITECTS_PALETTE
import org.teamvoided.attuned_convergence.compat.module.DnDLeaves
import org.teamvoided.attuned_convergence.compat.module.DnDLogs
import org.teamvoided.attuned_convergence.compat.module.DnDWood
import org.teamvoided.attuned_convergence.compat.module.Module
import org.teamvoided.attuned_convergence.compat.module.TwigsTable

object ArchitectsPaletteCompat : Compat {
    override fun populate(content: MutableList<Module>) {
        if (CompatVariables.DusksAndDungeons) {
            content.add(DnDWood(ARCHITECTS_PALETTE, "twisted", APBlocks.TWISTED_WOOD.get(), APBlocks.TWISTED_LOG.get()))
            content.add(DnDLeaves(ARCHITECTS_PALETTE, "twisted", APBlocks.TWISTED_LEAVES.get()))
            content.add(DnDLogs(ARCHITECTS_PALETTE, "twisted", APBlocks.TWISTED_LOG.get()))
        }
        if (CompatVariables.Twigs) {
            content.add(
                TwigsTable(
                    ARCHITECTS_PALETTE, "twisted",
                    APBlocks.TWISTED_PLANKS.get(), APBlocks.TWISTED_PLANKS.getPart(SLAB), APBlocks.TWISTED_FENCE.get()
                )
            )
        }
    }
}