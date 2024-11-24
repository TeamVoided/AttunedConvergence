package org.teamvoided.attuned_convergence.compat.module.DnD

import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags
import net.minecraft.block.AbstractBlock.Settings.copy
import net.minecraft.block.Block
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.RecipeCategory
import net.minecraft.registry.tag.TagKey
import org.teamvoided.attuned_convergence.compat.CompatVariables.DUSKS_AND_DUNGEONS
import org.teamvoided.attuned_convergence.compat.module.Module
import org.teamvoided.attuned_convergence.init.ACBlocks
import org.teamvoided.attuned_convergence.init.ACBlocks.register
import org.teamvoided.attuned_convergence.util.crit
import org.teamvoided.attuned_convergence.util.mods
import org.teamvoided.attuned_convergence.util.opt
import org.teamvoided.dusk_autumn.block.big.BigChainBlock
import org.teamvoided.dusk_autumn.init.blocks.DnDBigBlocks
import org.teamvoided.dusk_autumn.util.bigChainSound
import org.teamvoided.dusk_autumn.util.datagen.registerBigChain

class DnDChain(val modId: String, name: String, chain: Block, val ingot: Item, val nugget: Item) : Module {
    override fun modId(): String = modId
    val bigChain = register("${name}_big_chain", BigChainBlock(copy(chain).sounds(bigChainSound)))
    val condition = mods(DUSKS_AND_DUNGEONS, modId())

    init {
        ACBlocks.CUTOUT_BLOCKS.add(bigChain)
    }

    override fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder) {
        tagBuilder(ConventionalBlockTags.CHAINS).opt(DnDBigBlocks.BIG_CHAIN)
    }

    override fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter) {
        var e = makeConditional(condition)
        ShapedRecipeJsonFactory.create(RecipeCategory.BUILDING_BLOCKS, bigChain, 1)
            .pattern("I")
            .pattern("N")
            .pattern("I")
            .ingredient('I', Ingredient.ofItems(ingot))
            .ingredient('N', Ingredient.ofItems(nugget))
            .crit(nugget)
            .crit(ingot)
            .offerTo(e)
    }

    override fun lootTables(rawGen: FabricBlockLootTableProvider) {
        var gen = rawGen.withConditions(condition)
        gen.addDrop(bigChain)
    }

    override fun models(gen: BlockStateModelGenerator) {
        gen.registerBigChain(bigChain)
    }

    override fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible> = listOf(bigChain)
}