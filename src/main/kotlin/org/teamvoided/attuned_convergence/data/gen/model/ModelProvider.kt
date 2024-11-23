package org.teamvoided.attuned_convergence.data.gen.model

import architectspalette.core.registry.util.BlockNode
import architectspalette.core.registry.util.BlockNode.BlockType.BASE
import architectspalette.core.registry.util.BlockNode.BlockType.SLAB
import architectspalette.core.registry.util.BlockNode.BlockType.STAIRS
import architectspalette.core.registry.util.BlockNode.BlockType.VERTICAL_SLAB
import architectspalette.core.registry.util.BlockNode.BlockType.WALL
import architectspalette.core.util.model.BoardModelGenerator.board
import architectspalette.core.util.model.BoardModelGenerator.boardSlab
import architectspalette.core.util.model.BoardModelGenerator.boardStairs
import architectspalette.core.util.model.BoardModelGenerator.boardVerticalSlab
import architectspalette.core.util.model.BoardModelGenerator.boardWall
import architectspalette.core.util.model.BoardModelGenerator.processNode
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
        processNode(gen,DusksAndDungeonsCompat.CASCADE_BOARDS)
    }

    override fun generateItemModels(gen: ItemModelGenerator) {
    }
}