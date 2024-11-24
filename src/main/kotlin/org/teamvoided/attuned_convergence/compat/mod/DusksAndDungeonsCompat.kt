package org.teamvoided.attuned_convergence.compat.mod

import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.CompatVariables.DUSKS_AND_DUNGEONS
import org.teamvoided.attuned_convergence.compat.module.ArchitectsPaletteNub
import org.teamvoided.attuned_convergence.compat.module.ArchitectsPalettePlanks
import org.teamvoided.attuned_convergence.compat.module.Module
import org.teamvoided.attuned_convergence.compat.module.TwigsTable
import org.teamvoided.dusk_autumn.DusksAndDungeons
import org.teamvoided.dusk_autumn.init.blocks.DnDNetherBrickBlocks as Nether
import org.teamvoided.dusk_autumn.init.blocks.DnDWoodBlocks as Wood

object DusksAndDungeonsCompat : Compat {
    override fun populate(content: MutableSet<Module>) {
        DusksAndDungeons.init()
        if (CompatVariables.ArchitectsPalette) {
            content.add(ArchitectsPalettePlanks(DUSKS_AND_DUNGEONS, "cascade", Wood.CASCADE_PLANKS))
            content.add(
                ArchitectsPaletteNub(DUSKS_AND_DUNGEONS, "polished_nether_brick", Nether.POLISHED_NETHER_BRICKS)
            )
            content.add(
                ArchitectsPaletteNub(
                    DUSKS_AND_DUNGEONS, "polished_red_nether_brick", Nether.POLISHED_RED_NETHER_BRICKS
                )
            )
            content.add(
                ArchitectsPaletteNub(
                    DUSKS_AND_DUNGEONS, "polished_blue_nether_brick", Nether.POLISHED_BLUE_NETHER_BRICKS
                )
            )
            content.add(
                ArchitectsPaletteNub(
                    DUSKS_AND_DUNGEONS, "polished_gray_nether_brick", Nether.POLISHED_GRAY_NETHER_BRICKS
                )
            )
        }
        if (CompatVariables.Twigs) content.add(
            TwigsTable(DUSKS_AND_DUNGEONS, "cascade", Wood.CASCADE_PLANKS, Wood.CASCADE_SLAB, Wood.CASCADE_FENCE)
        )
    }
}