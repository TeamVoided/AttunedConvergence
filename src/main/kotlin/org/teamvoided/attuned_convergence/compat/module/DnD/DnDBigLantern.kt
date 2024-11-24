package org.teamvoided.attuned_convergence.compat.module.DnD

import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
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
import org.teamvoided.dusk_autumn.block.big.BigLanternBlock
import org.teamvoided.dusk_autumn.util.bigLanternSound
import org.teamvoided.dusk_autumn.util.datagen.registerBigLantern

class DnDBigLantern(
    val modId: String, name: String, lantern: Block,
    val torch: Block, val ingot: Item, val nugget: Item
) : Module {
    override fun modId(): String = modId
    val bigLantern = register("${name}_big_chain", BigLanternBlock(copy(lantern).sounds(bigLanternSound)))
    val condition = mods(DUSKS_AND_DUNGEONS, modId())

    init {
        ACBlocks.CUTOUT_BLOCKS.add(bigLantern)
    }

    override fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder) {
    }

    override fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter) {
        var e = makeConditional(condition)
        ShapedRecipeJsonFactory.create(RecipeCategory.BUILDING_BLOCKS, bigLantern)
            .ingredient('#', Ingredient.ofItems(torch))
            .ingredient('O', Ingredient.ofItems(ingot))
            .ingredient('X', Ingredient.ofItems(nugget))
            .pattern("XOX")
            .pattern("O#O")
            .pattern("XOX")
            .crit(torch)
            .offerTo(e)
    }

    override fun lootTables(rawGen: FabricBlockLootTableProvider) {
        var gen = rawGen.withConditions(condition)
        gen.addDrop(bigLantern)
    }

    override fun models(gen: BlockStateModelGenerator) {
        gen.registerBigLantern(bigLantern)
    }

    override fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible> = listOf(bigLantern)
}