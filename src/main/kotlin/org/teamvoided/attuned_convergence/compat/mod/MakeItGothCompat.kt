package org.teamvoided.attuned_convergence.compat.mod

import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.module.*
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDLogs
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDWood
import net.leah.makeitgoth.block.ModBlocks as GothBlocks
import org.teamvoided.attuned_convergence.compat.CompatVariables.MAKE_IT_GOTH as ID

object MakeItGothCompat : Compat {
    override fun populate(c: MutableSet<Module>) {
        if (CompatVariables.ArchitectsPalette) {
            c.add(APPlanks(ID, "rotwood", GothBlocks.ROTWOOD_PLANKS))
            c.add(APNub(ID, "gothstone", GothBlocks.GOTHSTONE))
        }
        if (CompatVariables.DusksAndDungeons) {
            c.add(DnDWood(ID, "rotwood", GothBlocks.ROTWOOD_WOOD, GothBlocks.ROTWOOD_LOG))
            c.add(DnDLogs(ID, "rotwood", GothBlocks.ROTWOOD_LOG))
        }
        if (CompatVariables.Twigs) c.add(
            TwigsTable(ID, "rotwood", GothBlocks.ROTWOOD_PLANKS, GothBlocks.ROTWOOD_SLAB, GothBlocks.ROTWOOD_FENCE)
        )
        if (CompatVariables.FarmersDelight) {
            c.add(FDCabinets(ID, "rotwood", GothBlocks.ROTWOOD_SLAB, GothBlocks.ROTWOOD_PRESSURE_PLATE))
        }
    }
}