package org.teamvoided.attuned_convergence.compat.mod

import architectspalette.core.registry.APBlocks.*
import architectspalette.core.registry.APItems
import architectspalette.core.registry.APItems.*
import architectspalette.core.registry.util.StoneBlockSet.SetComponent.SLAB
import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.CompatVariables.ARCHITECTS_PALETTE
import org.teamvoided.attuned_convergence.compat.module.Module
import org.teamvoided.attuned_convergence.compat.module.TwigsMetalLamp
import org.teamvoided.attuned_convergence.compat.module.TwigsTable
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDBigLantern
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDChain
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDLeaves
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDLogs
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDWood

object ArchitectsPaletteCompat : Compat {
    override fun populate(content: MutableSet<Module>) {
        if (CompatVariables.DusksAndDungeons) {
            content.add(DnDWood(ARCHITECTS_PALETTE, "twisted", TWISTED_WOOD.get(), TWISTED_LOG.get()))
            content.add(DnDLeaves(ARCHITECTS_PALETTE, "twisted", TWISTED_LEAVES.get()))
            content.add(DnDLogs(ARCHITECTS_PALETTE, "twisted", TWISTED_LOG.get()))
            content.add(
                DnDChain(
                    ARCHITECTS_PALETTE, "nether_brass",
                    NETHER_BRASS_CHAIN.get(), APItems.NETHER_BRASS.get(), NETHER_BRASS_NUGGET.get()
                )
            )
            content.add(
                DnDBigLantern(
                    ARCHITECTS_PALETTE, "nether_brass",
                    NETHER_BRASS_LANTERN.get(), APItems.NETHER_BRASS_TORCH.get(),
                    APItems.NETHER_BRASS.get(), NETHER_BRASS_NUGGET.get()
                )
            )
        }
        if (CompatVariables.Twigs) {
            content.add(
                TwigsTable(
                    ARCHITECTS_PALETTE, "twisted",
                    TWISTED_PLANKS.get(), TWISTED_PLANKS.getPart(SLAB), TWISTED_FENCE.get()
                )
            )
            content.add(
                TwigsMetalLamp(
                    ARCHITECTS_PALETTE, "nether_brass",
                    APItems.NETHER_BRASS_TORCH.get(), APItems.NETHER_BRASS.get(), NETHER_BRASS_NUGGET.get()
                )
            )
        }
    }
}