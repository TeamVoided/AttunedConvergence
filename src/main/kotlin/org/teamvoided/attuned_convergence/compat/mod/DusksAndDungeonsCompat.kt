package org.teamvoided.attuned_convergence.compat.mod

import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.CompatVariables.DUSKS_AND_DUNGEONS
import org.teamvoided.attuned_convergence.compat.module.ArchitectsPalettePlanks
import org.teamvoided.attuned_convergence.compat.module.Module
import org.teamvoided.attuned_convergence.compat.module.TwigsTable
import org.teamvoided.dusk_autumn.init.blocks.DnDWoodBlocks

object DusksAndDungeonsCompat : Compat {
    override fun populate(content: MutableList<Module>) {
        if (CompatVariables.ArchitectsPalette)
            content.add(ArchitectsPalettePlanks(DUSKS_AND_DUNGEONS, "cascade", DnDWoodBlocks.CASCADE_PLANKS))
        if (CompatVariables.Twigs) content.add(
            TwigsTable(
                DUSKS_AND_DUNGEONS, "cascade",
                DnDWoodBlocks.CASCADE_PLANKS, DnDWoodBlocks.CASCADE_SLAB, DnDWoodBlocks.CASCADE_FENCE
            )
        )
    }
}