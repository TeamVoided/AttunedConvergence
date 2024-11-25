package org.teamvoided.attuned_convergence.compat.module

import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.minecraft.block.AbstractBlock.Settings.copy
import net.minecraft.block.Block
import net.minecraft.block.SlabBlock
import net.minecraft.block.StairsBlock
import net.minecraft.block.WallBlock
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import org.teamvoided.attuned_convergence.compat.CompatVariables.VOIDED_VARIANCE
import org.teamvoided.attuned_convergence.init.ACBlocks.register
import org.teamvoided.attuned_convergence.util.mods
import org.teamvoided.attuned_convergence.util.opt
import org.teamvoided.voided_variance.utils.datagen.createSlab
import org.teamvoided.voided_variance.utils.datagen.createStair
import org.teamvoided.voided_variance.utils.datagen.createWall
import org.teamvoided.voided_variance.utils.datagen.slab
import org.teamvoided.voided_variance.utils.datagen.stairs
import org.teamvoided.voided_variance.utils.datagen.wall

class VVCracked(val modId: String, name: String, val block: Block) : Module {
    val condition = mods(VOIDED_VARIANCE, modId)
    var stairs = register("${name}_stairs", StairsBlock(block.defaultState, copy(block)))
    var slab = register("${name}_slab", SlabBlock(copy(block)))
    var wall = register("${name}_wall", WallBlock(copy(block)))
    override fun modId() = modId
    override fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder) {
        tagBuilder(BlockTags.PICKAXE_MINEABLE).opt(stairs).opt(slab).opt(wall)
        tagBuilder(BlockTags.STAIRS).opt(stairs)
        tagBuilder(BlockTags.SLABS).opt(slab)
        tagBuilder(BlockTags.WALLS).opt(wall)
    }

    override fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter) {
        var e = makeConditional(condition)
        e.createStair(stairs, block, true)
        e.createSlab(slab, block, true)
        e.createWall(wall, block, true)
    }

    override fun lootTables(rawGen: FabricBlockLootTableProvider) {
        var e = rawGen.withConditions(condition)
        e.addDrop(stairs)
        e.addDrop(slab)
        e.addDrop(wall)
    }

    override fun models(gen: BlockStateModelGenerator) {
        gen.stairs(stairs, block)
        gen.slab(slab, block)
        gen.wall(wall, block)
    }

    override fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible> = listOf(stairs, slab, wall)
}