package org.teamvoided.attuned_convergence.compat.module

import architectspalette.content.blocks.NubBlock
import architectspalette.content.blocks.RailingBlock
import architectspalette.core.registry.APTags
import architectspalette.core.util.RecipeHelper.cuttingName
import architectspalette.core.util.model.ModelHelpers.nub
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.minecraft.block.AbstractBlock.Settings.copy
import net.minecraft.block.Block
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.SingleItemRecipeJsonFactory.createStonecuttingRecipe
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.RecipeCategory
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import org.teamvoided.attuned_convergence.compat.CompatVariables.ARCHITECTS_PALETTE
import org.teamvoided.attuned_convergence.init.ACBlocks.register
import org.teamvoided.attuned_convergence.util.*

class ArchitectsPaletteNub(val modId: String, name: String, val block: Block) : Module {
    override fun modId() = modId
    val nub = register("${name}_nub", NubBlock(copy(block).nonOpaque().solid()))

    val condition = mods(ARCHITECTS_PALETTE, modId())
    override fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder) {
        tagBuilder(BlockTags.PICKAXE_MINEABLE).opt(nub)
        tagBuilder(APTags.NUBS).opt(nub)
    }

    override fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter) {
        var e = makeConditional(condition)
        createStonecuttingRecipe(Ingredient.ofItems(block), RecipeCategory.BUILDING_BLOCKS, nub, 2)
            .crit(block).offerTo(e, cuttingName(nub, block))

    }

    override fun lootTables(rawGen: FabricBlockLootTableProvider) {
        val gen = rawGen.withConditions(condition)
        gen.addDrop(nub)
    }
    override fun models(gen: BlockStateModelGenerator) = nub(gen, nub)
    override fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible> = listOf(nub)
}