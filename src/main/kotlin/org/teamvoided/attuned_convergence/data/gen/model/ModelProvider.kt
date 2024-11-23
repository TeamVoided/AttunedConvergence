package org.teamvoided.attuned_convergence.data.gen.model

import architectspalette.core.util.model.BoardModelGenerator.board
import architectspalette.core.util.model.BoardModelGenerator.boardSlab
import architectspalette.core.util.model.BoardModelGenerator.boardStairs
import architectspalette.core.util.model.BoardModelGenerator.boardWall
import architectspalette.core.util.model.ModelHelpers.railing
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator
import org.teamvoided.attuned_convergence.init.mod.DusksAndDungeonsCompat
import org.teamvoided.dusk_autumn.init.blocks.DnDWoodBlocks

class ModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        railing(gen, DusksAndDungeonsCompat.CASCADE_RAILING, DnDWoodBlocks.CASCADE_PLANKS)
        board(gen, DusksAndDungeonsCompat.CASCADE_BOARDS)
        boardStairs(gen, DusksAndDungeonsCompat.CASCADE_BOARD_STAIRS, DusksAndDungeonsCompat.CASCADE_BOARDS)
        boardSlab(gen, DusksAndDungeonsCompat.CASCADE_BOARD_SLAB, DusksAndDungeonsCompat.CASCADE_BOARDS)
        boardWall(gen, DusksAndDungeonsCompat.CASCADE_BOARD_WALL, DusksAndDungeonsCompat.CASCADE_BOARDS)
    }

    override fun generateItemModels(gen: ItemModelGenerator) {
    }
}