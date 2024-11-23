package org.teamvoided.attuned_convergence.init.mod

import architectspalette.content.blocks.RailingBlock
import com.ninni.twigs.block.TableBlock
import net.minecraft.block.AbstractBlock.Settings.copy
import net.minecraft.block.Block
import net.minecraft.block.SlabBlock
import net.minecraft.block.StairsBlock
import net.minecraft.block.WallBlock
import org.teamvoided.attuned_convergence.init.ACBlocks.register
import org.teamvoided.dusk_autumn.init.blocks.DnDWoodBlocks

object DusksAndDungeonsCompat {
    fun init() = Unit

    //
    // WOOD COMPAT
    //
    /*
    - Twigs Table
    - Railings
    - Boards & there Stairs, Slabs, Walls
     */
    // CASCADE

    val CASCADE_TABLE = register("cascade_table", TableBlock(copy(DnDWoodBlocks.CASCADE_PLANKS)))
    val CASCADE_RAILING = register("cascade_railing", RailingBlock(copy(DnDWoodBlocks.CASCADE_PLANKS)))
    val CASCADE_BOARDS = register("cascade_boards", Block(copy(DnDWoodBlocks.CASCADE_PLANKS)))
    val CASCADE_BOARD_STAIRS = register(
        "cascade_board_stairs",
        StairsBlock(DnDWoodBlocks.CASCADE_PLANKS.defaultState, copy(DnDWoodBlocks.CASCADE_PLANKS))
    )
    val CASCADE_BOARD_SLAB = register("cascade_board_slab", SlabBlock(copy(DnDWoodBlocks.CASCADE_PLANKS)))
    val CASCADE_BOARD_WALL = register("cascade_board_wall", WallBlock(copy(DnDWoodBlocks.CASCADE_PLANKS)))


}