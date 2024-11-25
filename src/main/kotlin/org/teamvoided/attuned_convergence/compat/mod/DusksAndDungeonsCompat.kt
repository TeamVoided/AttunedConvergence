package org.teamvoided.attuned_convergence.compat.mod

import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.module.ArchitectsPaletteNub
import org.teamvoided.attuned_convergence.compat.module.ArchitectsPalettePlanks
import org.teamvoided.attuned_convergence.compat.module.Module
import org.teamvoided.attuned_convergence.compat.module.TwigsTable
import org.teamvoided.attuned_convergence.compat.module.VVCracked
import org.teamvoided.dusk_autumn.DusksAndDungeons
import org.teamvoided.attuned_convergence.compat.CompatVariables.DUSKS_AND_DUNGEONS as ID
import org.teamvoided.dusk_autumn.init.blocks.DnDNetherBrickBlocks as Nether
import org.teamvoided.dusk_autumn.init.blocks.DnDWoodBlocks as Wood

object DusksAndDungeonsCompat : Compat {
    override fun populate(c: MutableSet<Module>) {
        DusksAndDungeons.init()
        if (CompatVariables.ArchitectsPalette) {
            c.add(ArchitectsPalettePlanks(ID, "cascade", Wood.CASCADE_PLANKS))
            c.add(ArchitectsPaletteNub(ID, "polished_nether_brick", Nether.POLISHED_NETHER_BRICKS))
            c.add(ArchitectsPaletteNub(ID, "polished_red_nether_brick", Nether.POLISHED_RED_NETHER_BRICKS))
            c.add(ArchitectsPaletteNub(ID, "polished_blue_nether_brick", Nether.POLISHED_BLUE_NETHER_BRICKS))
            c.add(ArchitectsPaletteNub(ID, "polished_gray_nether_brick", Nether.POLISHED_GRAY_NETHER_BRICKS))
        }
        if (CompatVariables.Twigs)
            c.add(TwigsTable(ID, "cascade", Wood.CASCADE_PLANKS, Wood.CASCADE_SLAB, Wood.CASCADE_FENCE))
        if (CompatVariables.VoidedVariance){
            c.add(VVCracked(ID, "cracked_mixed_nether_brick", Nether.CRACKED_MIXED_NETHER_BRICKS))
            c.add(VVCracked(ID, "cracked_red_nether_brick", Nether.CRACKED_RED_NETHER_BRICKS))
            c.add(VVCracked(ID, "cracked_mixed_blue_nether_brick", Nether.CRACKED_MIXED_BLUE_NETHER_BRICKS))
            c.add(VVCracked(ID, "cracked_blue_nether_brick", Nether.CRACKED_BLUE_NETHER_BRICKS))
            c.add(VVCracked(ID, "cracked_mixed_gray_nether_brick", Nether.CRACKED_MIXED_GRAY_NETHER_BRICKS))
            c.add(VVCracked(ID, "cracked_gray_nether_brick", Nether.CRACKED_GRAY_NETHER_BRICKS))
        }
    }
}