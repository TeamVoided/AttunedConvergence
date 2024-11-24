package org.teamvoided.attuned_convergence.compat.module

import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.minecraft.block.Block
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.registry.tag.TagKey
import org.teamvoided.attuned_convergence.compat.CompatVariables.DUSKS_AND_DUNGEONS
import org.teamvoided.attuned_convergence.init.ACBlocks.register
import org.teamvoided.attuned_convergence.util.mods
import org.teamvoided.attuned_convergence.util.opt
import org.teamvoided.dusk_autumn.data.tags.DnDBlockTags
import org.teamvoided.dusk_autumn.util.datagen.createLogPile
import org.teamvoided.dusk_autumn.util.datagen.createPiles
import org.teamvoided.dusk_autumn.util.datagen.logPile
import org.teamvoided.dusk_autumn.util.logPile as createLogPile

class DnDLogs(val modId: String, name: String, var log: Block) : Module {
    var condition = mods(DUSKS_AND_DUNGEONS, modId())
    val logPile = register("${name}_log_pile", createLogPile(log, log.defaultMapColor))
    override fun modId() = modId

    override fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder) {
        tagBuilder(DnDBlockTags.LOG_PILES_THAT_BURN).opt(logPile)
    }

    override fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter) {
        var e = makeConditional(condition)
        e.createPiles(logPile, log)
    }

    override fun lootTables(rawGen: FabricBlockLootTableProvider) {
        var gen = rawGen.withConditions(condition)
        gen.logPile(logPile)
    }

    override fun models(gen: BlockStateModelGenerator) {
        gen.createLogPile(logPile, log)
    }

    override fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible> = listOf(logPile)
}