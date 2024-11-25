package org.teamvoided.attuned_convergence.compat.mod

import architectspalette.core.registry.APBlocks.*
import architectspalette.core.registry.APItems.*
import architectspalette.core.registry.util.BlockNode
import architectspalette.core.registry.util.BlockNode.BlockType.BRICKS
import architectspalette.core.registry.util.BlockNode.BlockType.CRACKED
import architectspalette.core.registry.util.StoneBlockSet.SetComponent.SLAB
import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.compat.module.Module
import org.teamvoided.attuned_convergence.compat.module.TwigsMetalLamp
import org.teamvoided.attuned_convergence.compat.module.TwigsTable
import org.teamvoided.attuned_convergence.compat.module.VVCracked
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDBigLantern
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDChain
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDLeaves
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDLogs
import org.teamvoided.attuned_convergence.compat.module.dnd.DnDWood
import architectspalette.core.registry.APItems as I
import org.teamvoided.attuned_convergence.compat.CompatVariables.ARCHITECTS_PALETTE as ID

object ArchitectsPaletteCompat : Compat {
    override fun populate(c: MutableSet<Module>) {
        if (CompatVariables.DusksAndDungeons) {
            c.add(DnDWood(ID, "twisted", TWISTED_WOOD.get(), TWISTED_LOG.get()))
            c.add(DnDLeaves(ID, "twisted", TWISTED_LEAVES.get()))
            c.add(DnDLogs(ID, "twisted", TWISTED_LOG.get()))
            c.add(
                DnDChain(ID, "nether_brass", NETHER_BRASS_CHAIN.get(), I.NETHER_BRASS.get(), NETHER_BRASS_NUGGET.get())
            )
            c.add(
                DnDBigLantern(
                    ID, "nether_brass",
                    NETHER_BRASS_LANTERN.get(), I.NETHER_BRASS_TORCH.get(),
                    I.NETHER_BRASS.get(), NETHER_BRASS_NUGGET.get()
                )
            )
        }
        if (CompatVariables.Twigs) {
            c.add(TwigsTable(ID, "twisted", TWISTED_PLANKS.get(), TWISTED_PLANKS.getPart(SLAB), TWISTED_FENCE.get()))
            c.add(
                TwigsMetalLamp(
                    ID, "nether_brass", I.NETHER_BRASS_TORCH.get(), I.NETHER_BRASS.get(), NETHER_BRASS_NUGGET.get()
                )
            )
        }
        if (CompatVariables.VoidedVariance) {
            c.add(VVCracked(ID, "cracked_olivestone_brick", CRACKED_OLIVESTONE_BRICKS.get()))
            c.add(VVCracked(ID, "cracked_olivestonne_tile", CRACKED_OLIVESTONE_TILES.get()))
            c.add(VVCracked(ID, "cracked_algal_brick", CRACKED_ALGAL_BRICKS.get()))
            c.add(VVCracked(ID, "cracked_end_stone_brick", CRACKED_END_STONE_BRICKS.get()))
            c.add(VVCracked(ID, "cracked_basalt_tile", CRACKED_BASALT_TILES.get()))

            c.add(VVCracked(ID, "cracked_coal_brick", COAL_BRICKS.getCracked()))
            c.add(VVCracked(ID, "cracked_lapis_brick", LAPIS_BRICKS.getCracked()))
            c.add(VVCracked(ID, "cracked_redstone_brick", REDSTONE_BRICKS.getCracked()))
            c.add(VVCracked(ID, "cracked_iron_brick", IRON_BRICKS.getCracked()))
            c.add(VVCracked(ID, "cracked_gold_brick", GOLD_BRICKS.getCracked()))
            c.add(VVCracked(ID, "cracked_emerald_brick", EMERALD_BRICKS.getCracked()))
            c.add(VVCracked(ID, "cracked_diamond_brick", DIAMOND_BRICKS.getCracked()))
            c.add(VVCracked(ID, "cracked_moonshale_brick", MOONSHALE.getBricks()!!.getCracked()))
        }
    }
    fun BlockNode.getCracked() = this.getChild(CRACKED).get()
    fun BlockNode.getBricks() = this.children.find { it.type == BRICKS }
}