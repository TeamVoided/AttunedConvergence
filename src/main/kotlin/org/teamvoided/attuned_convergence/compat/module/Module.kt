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

interface Module {
    fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder)
    fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter)
    fun lootTables(gen: FabricBlockLootTableProvider)
    fun models(gen: BlockStateModelGenerator)
    fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible>
    fun modId(): String
}