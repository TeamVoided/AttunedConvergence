package org.teamvoided.attuned_convergence.compat.module

import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.minecraft.block.AbstractBlock.Settings.copy
import net.minecraft.block.Block
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.particle.DefaultParticleType
import net.minecraft.registry.tag.TagKey
import org.teamvoided.attuned_convergence.compat.CompatVariables.DUSKS_AND_DUNGEONS
import org.teamvoided.attuned_convergence.init.ACBlocks.register
import org.teamvoided.attuned_convergence.util.mods
import org.teamvoided.attuned_convergence.util.opt
import org.teamvoided.dusk_autumn.block.FallingLeafPileBlock
import org.teamvoided.dusk_autumn.block.LeafPileBlock
import org.teamvoided.dusk_autumn.data.tags.DnDBlockTags
import org.teamvoided.dusk_autumn.util.datagen.createLeafPile
import org.teamvoided.dusk_autumn.util.datagen.createPiles
import org.teamvoided.dusk_autumn.util.datagen.leafPile

class DnDLeaves(val modId: String, name: String, val leaves: Block, particle: DefaultParticleType? = null) : Module {
    val leafPile = register(
        "${name}_leaf_pile",
        if (particle != null) FallingLeafPileBlock(particle, copy(leaves)) else LeafPileBlock(copy(leaves))
    )

    override fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder) {
        tagBuilder(DnDBlockTags.LEAF_PILES).opt(leafPile)
    }

    override fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter) {
        var e = makeConditional(mods(DUSKS_AND_DUNGEONS, modId()))
        e.createPiles(leafPile, leaves)
    }

    override fun lootTables(gen: FabricBlockLootTableProvider) {
        gen.add(leafPile, gen.leafPile(leafPile, leaves))
    }

    override fun models(gen: BlockStateModelGenerator) {
        gen.createLeafPile(leafPile, leaves)
    }

    override fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible> = listOf(leafPile)

    override fun modId(): String = modId

    override fun getCutout(): List<Block> = listOf(leaves)
}