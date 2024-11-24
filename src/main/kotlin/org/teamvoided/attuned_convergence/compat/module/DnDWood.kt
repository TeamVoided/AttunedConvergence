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
import org.teamvoided.attuned_convergence.compat.CompatVariables.DUSKS_AND_DUNGEONS
import org.teamvoided.attuned_convergence.init.ACBlocks.register
import org.teamvoided.attuned_convergence.util.mods
import org.teamvoided.attuned_convergence.util.slab
import org.teamvoided.attuned_convergence.util.stair
import org.teamvoided.attuned_convergence.util.wall
import org.teamvoided.dusk_autumn.data.tags.DnDBlockTags
import org.teamvoided.dusk_autumn.util.datagen.genPsudoFamily

class DnDWood(val modId: String, name: String, var log: Block) : Module {
    override fun modId() = modId
    val stairs = register("${name}_wood_stairs", StairsBlock(log.defaultState, copy(log).mapColor(log.defaultMapColor)))
    val slab = register("${name}_wood_slab", SlabBlock(copy(log).mapColor(log.defaultMapColor)))
    val wall = register("${name}_wood_wall", WallBlock(copy(log).mapColor(log.defaultMapColor)))

    override fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder) {
        tagBuilder(BlockTags.WOODEN_SLABS).add(slab)
        tagBuilder(DnDBlockTags.WOOD_SLABS).add(slab)
        tagBuilder(DnDBlockTags.WOOD_SLABS_THAT_BURN).add(slab)

        tagBuilder(BlockTags.WOODEN_STAIRS).add(stairs)
        tagBuilder(DnDBlockTags.WOOD_STAIRS).add(stairs)
        tagBuilder(DnDBlockTags.WOOD_STAIRS_THAT_BURN).add(stairs)

        tagBuilder(DnDBlockTags.WOODEN_WALLS).add(wall)
        tagBuilder(DnDBlockTags.WOODEN_WALLS_THAT_BURN).add(wall)
        tagBuilder(BlockTags.AXE_MINEABLE).add(wall)
    }

    override fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter) {
        var e = makeConditional(mods(DUSKS_AND_DUNGEONS, modId()))
        stair(e, stairs, log)
        slab(e, slab, log)
        wall(e, wall, log)
    }

    override fun lootTables(gen: FabricBlockLootTableProvider) =
        listOf(stairs, slab, wall).forEach(gen::addDrop)

    override fun models(gen: BlockStateModelGenerator) {
        gen.genPsudoFamily(stairs, slab, wall, log)
    }

    override fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible> = listOf(stairs, slab, wall)
}
