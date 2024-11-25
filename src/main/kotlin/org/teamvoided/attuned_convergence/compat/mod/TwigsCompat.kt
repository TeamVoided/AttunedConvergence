package org.teamvoided.attuned_convergence.compat.mod

import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.module.APNub
import org.teamvoided.attuned_convergence.compat.module.Module
import org.teamvoided.attuned_convergence.compat.module.VVCracked
import com.ninni.twigs.registry.TwigsBlocks as TBlocks
import org.teamvoided.attuned_convergence.compat.CompatVariables.TWIGS as ID

object TwigsCompat : Compat {
    override fun populate(c: MutableSet<Module>) {
        if (CompatVariables.ArchitectsPalette) {
            c.add(APNub(ID, "schist", TBlocks.SCHIST))
            c.add(APNub(ID, "rhyolite", TBlocks.RHYOLITE))
        }
        if (CompatVariables.VoidedVariance) {
//            c.add(VVCracked(ID, "cracked_brick", TBlocks.CRACKED_BRICKS))
            c.add(VVCracked(ID, "cracked_cobblestone_brick", TBlocks.CRACKED_COBBLESTONE_BRICKS))
            c.add(VVCracked(ID, "cracked_polished_tuff_brick", TBlocks.CRACKED_POLISHED_TUFF_BRICKS))
            c.add(VVCracked(ID, "cracked_polished_calcite_brick", TBlocks.CRACKED_POLISHED_CALCITE_BRICKS))
            c.add(VVCracked(ID, "cracked_polished_schist_brick", TBlocks.CRACKED_POLISHED_SCHIST_BRICKS))
            c.add(VVCracked(ID, "cracked_polished_rhyolite_brick", TBlocks.CRACKED_POLISHED_RHYOLITE_BRICKS))
            c.add(VVCracked(ID, "cracked_polished_bloodstone_brick", TBlocks.CRACKED_POLISHED_BLOODSTONE_BRICKS))
//            c.add(VVCracked(ID, "cracked_silt_brick", TBlocks.CRACKED_SILT_BRICKS))
        }
    }
}