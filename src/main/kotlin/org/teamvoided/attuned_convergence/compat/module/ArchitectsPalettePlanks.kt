package org.teamvoided.attuned_convergence.compat.module

import architectspalette.content.blocks.RailingBlock
import architectspalette.core.registry.APBlocks
import architectspalette.core.util.RecipeHelper.boardRecipe
import architectspalette.core.util.RecipeHelper.railingRecipe
import architectspalette.core.util.model.BoardModelGenerator.board
import architectspalette.core.util.model.BoardModelGenerator.boardSlab
import architectspalette.core.util.model.BoardModelGenerator.boardStairs
import architectspalette.core.util.model.BoardModelGenerator.boardWall
import architectspalette.core.util.model.ModelHelpers.railing
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.minecraft.block.AbstractBlock.Settings.copy
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.SlabBlock
import net.minecraft.block.StairsBlock
import net.minecraft.block.WallBlock
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import org.teamvoided.attuned_convergence.compat.CompatVariables.ARCHITECTS_PALETTE
import org.teamvoided.attuned_convergence.init.ACBlocks.register
import org.teamvoided.attuned_convergence.util.*

class ArchitectsPalettePlanks(val modId: String, name: String, val planks: Block) : Module {
    override fun modId() = modId
    val railing = register("${name}_railing", RailingBlock(copy(planks)))
    val boards = register("${name}_boards", Block(copy(planks)))
    val boardStairs = register("${name}_board_stairs", StairsBlock(planks.defaultState, copy(planks)))
    val boardSlab = register("${name}_board_slab", SlabBlock(copy(planks)))
    val boardWall = register("${name}_board_wall", WallBlock(copy(planks)))
    override fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder) {
        tagBuilder(BlockTags.AXE_MINEABLE).add(railing).add(boards).add(boardWall)
        tagBuilder(BlockTags.WOODEN_SLABS).add(boardSlab)
        tagBuilder(BlockTags.WOODEN_STAIRS).add(boardStairs)
        tagBuilder(BlockTags.WALLS).add(boardWall)
    }

    override fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter) {
        var e = makeConditional(mods(ARCHITECTS_PALETTE, modId()))
        railingRecipe(e, railing, planks)
        boardRecipe(e, boards, planks)
        stair(e, boardStairs, boards)
        slab(e, boardSlab, boards)
        wall(e, boardWall, boards)
    }

    override fun lootTables(gen: FabricBlockLootTableProvider) =
        listOf(railing, boards, boardStairs, boardSlab, boardWall).forEach { gen.addDrop(it) }

    override fun models(gen: BlockStateModelGenerator) {
        railing(gen, railing, planks)
        board(gen, boards)
        boardStairs(gen, boardStairs, boards)
        boardSlab(gen, boardSlab, boards)
        boardWall(gen, boardWall, boards)
    }

    override fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible> =
        listOf(boards, boardStairs, boardSlab, boardWall, railing)
}