package org.teamvoided.attuned_convergence.compat.mod

import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.CompatVariables.MAKE_IT_GOTH
import org.teamvoided.attuned_convergence.compat.module.ArchitectsPalettePlanks
import org.teamvoided.attuned_convergence.compat.module.DnDWood
import org.teamvoided.attuned_convergence.compat.module.Module
import net.leah.makeitgoth.block.ModBlocks as GothBlocks

object MakeItGothCompat : Compat {
    override fun populate(content: MutableList<Module>) {
        if (CompatVariables.ArchitectsPalette)
            content.add(ArchitectsPalettePlanks(MAKE_IT_GOTH, "rotwood", GothBlocks.ROTWOOD_PLANKS))
        if (CompatVariables.DusksAndDungeons) content.add(
            DnDWood(MAKE_IT_GOTH, "rotwood", GothBlocks.ROTWOOD_WOOD, GothBlocks.ROTWOOD_LOG)
        )
    }
}