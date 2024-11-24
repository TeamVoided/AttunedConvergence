package org.teamvoided.attuned_convergence.compat.module

import com.ninni.twigs.block.LampBlock
import com.ninni.twigs.registry.TwigsBlocks
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.minecraft.block.AbstractBlock.Settings.copy
import net.minecraft.block.Block
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator.createBooleanModelMap
import net.minecraft.data.client.model.Models
import net.minecraft.data.client.model.Texture
import net.minecraft.data.client.model.TextureKey
import net.minecraft.data.client.model.VariantsBlockStateSupplier
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.recipe.RecipeCategory
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import net.minecraft.state.property.Properties
import org.teamvoided.attuned_convergence.compat.CompatVariables.TWIGS
import org.teamvoided.attuned_convergence.init.ACBlocks.register
import org.teamvoided.attuned_convergence.util.crit
import org.teamvoided.attuned_convergence.util.model.model
import org.teamvoided.attuned_convergence.util.mods
import org.teamvoided.attuned_convergence.util.opt

class TwigsMetalLamp(
    val modId: String, name: String, val torch: Item, val ingot: Item, val reagent: Item
) : Module {
    override fun modId() = modId
    val condition = mods(TWIGS, modId())
    val lamp = register("${name}_lamp", LampBlock(copy(TwigsBlocks.LAMP)))
    override fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder) {
        tagBuilder(BlockTags.PICKAXE_MINEABLE).opt(lamp)
    }

    override fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter) {
        var e = makeConditional(condition)
        ShapedRecipeJsonFactory.create(RecipeCategory.BUILDING_BLOCKS, lamp)
            .pattern("iii")
            .pattern("iTi")
            .pattern("iRi")
            .ingredient('i', ingot)
            .ingredient('T', torch)
            .ingredient('R', reagent)
            .crit(ingot)
            .crit(torch)
            .offerTo(e)

    }

    override fun lootTables(rawGen: FabricBlockLootTableProvider) {
        val gen = rawGen.withConditions(condition)
        gen.addDrop(lamp)
    }

    override fun models(gen: BlockStateModelGenerator) {
        var tex = Texture()
            .put(TextureKey.TOP, lamp.model("_top"))
            .put(TextureKey.SIDE, lamp.model("_side"))
            .put(TextureKey.BOTTOM, lamp.model("_bottom"))

        var on = Models.CUBE_BOTTOM_TOP.upload(lamp, tex, gen.modelCollector)
        var off = Models.CUBE_BOTTOM_TOP.upload(
            lamp, "_off", tex.copyAndAdd(TextureKey.SIDE, lamp.model("_side_off")), gen.modelCollector
        )
        gen.blockStateCollector.accept(
            VariantsBlockStateSupplier.create(lamp).coordinate(createBooleanModelMap(Properties.LIT, on, off))
        )
        gen.registerParentedItemModel(lamp, on)
    }

    override fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible> = listOf(lamp)
}