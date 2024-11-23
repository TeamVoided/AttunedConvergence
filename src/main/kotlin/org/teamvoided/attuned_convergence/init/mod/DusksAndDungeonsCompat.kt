package org.teamvoided.attuned_convergence.init.mod

import architectspalette.content.blocks.RailingBlock
import com.ninni.twigs.block.TableBlock
import net.minecraft.block.AbstractBlock.Settings.copy
import net.minecraft.block.Block
import org.teamvoided.attuned_convergence.init.ACBlocks
import org.teamvoided.attuned_convergence.init.ACBlocks.createBoardNode
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

    val CASCADE_TABLE = ACBlocks.register("cascade_table", TableBlock(copy(DnDWoodBlocks.CASCADE_PLANKS)))
    val CASCADE_RAILING = ACBlocks.register("cascade_railing", RailingBlock(copy(DnDWoodBlocks.CASCADE_PLANKS)))
    val CASCADE_BOARDS = createBoardNode("cascade_boards", Block(copy(DnDWoodBlocks.CASCADE_PLANKS)))


}