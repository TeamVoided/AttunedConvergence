package org.teamvoided.attuned_convergence.compat.mod

import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.CompatVariables.MAKE_IT_GOTH
import org.teamvoided.attuned_convergence.compat.module.APNub
import org.teamvoided.attuned_convergence.compat.module.APPlanks
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDLogs
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDWood
import org.teamvoided.attuned_convergence.compat.module.Module
import org.teamvoided.attuned_convergence.compat.module.TwigsTable
import net.leah.makeitgoth.block.ModBlocks as GothBlocks

object MakeItGothCompat : Compat {
    override fun populate(content: MutableSet<Module>) {
        if (CompatVariables.ArchitectsPalette){
            content.add(APPlanks(MAKE_IT_GOTH, "rotwood", GothBlocks.ROTWOOD_PLANKS))
            content.add(APNub(MAKE_IT_GOTH, "gothstone", GothBlocks.GOTHSTONE))
        }
        if (CompatVariables.DusksAndDungeons) {
            content.add(DnDWood(MAKE_IT_GOTH, "rotwood", GothBlocks.ROTWOOD_WOOD, GothBlocks.ROTWOOD_LOG))
            content.add(DnDLogs(MAKE_IT_GOTH, "rotwood", GothBlocks.ROTWOOD_LOG))
        }
        if (CompatVariables.Twigs) content.add(
            TwigsTable(
                MAKE_IT_GOTH, "rotwood",
                GothBlocks.ROTWOOD_PLANKS, GothBlocks.ROTWOOD_SLAB, GothBlocks.ROTWOOD_FENCE
            )
        )
    }
}