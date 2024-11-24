package org.teamvoided.attuned_convergence.compat.module

import com.ninni.twigs.TwigsProperties
import com.ninni.twigs.TwigsTags
import com.ninni.twigs.block.TableBlock
import com.ninni.twigs.util.RecipeHelper.quickTableRecipe
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.minecraft.block.AbstractBlock.Settings.copy
import net.minecraft.block.Block
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.client.model.MultipartBlockStateSupplier
import net.minecraft.data.client.model.Texture
import net.minecraft.data.client.model.TextureKey
import net.minecraft.data.client.model.VariantSettings.Rotation
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import org.teamvoided.attuned_convergence.compat.CompatVariables.TWIGS
import org.teamvoided.attuned_convergence.init.ACBlocks.register
import org.teamvoided.attuned_convergence.util.model.TABLE_INVENTORY
import org.teamvoided.attuned_convergence.util.model.TABLE_LEG
import org.teamvoided.attuned_convergence.util.model.TABLE_TOP
import org.teamvoided.attuned_convergence.util.model.model
import org.teamvoided.attuned_convergence.util.model.modelNoLock
import org.teamvoided.attuned_convergence.util.model.whenTrue
import org.teamvoided.attuned_convergence.util.mods

class TwigsTable(val modId: String, name: String, var planks: Block, var slab: Block, var fence: Block) : Module {
    override fun modId() = modId
    val table = register("${name}_table", TableBlock(copy(planks)))
    override fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder) {
        tagBuilder(BlockTags.AXE_MINEABLE).add(table)
        tagBuilder(TwigsTags.TABLES_BLOCK).add(table)
    }

    override fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter) {
        var e = makeConditional(mods(TWIGS, modId()))
        quickTableRecipe(e, table, slab, fence, planks)
    }

    override fun lootTables(gen: FabricBlockLootTableProvider) = gen.addDrop(table)
    override fun models(gen: BlockStateModelGenerator) {
        var tex = Texture.particle(planks)
            .put(TextureKey.TOP, table.model("_top"))
            .put(TextureKey.SIDE, table.model())
            .put(TextureKey.BOTTOM, table.model("_bottom"))
        var inventory = TABLE_INVENTORY.upload(table, tex, gen.modelCollector)
        var side = TABLE_LEG.upload(table, tex, gen.modelCollector)
        var top = TABLE_TOP.upload(table, tex, gen.modelCollector)
        gen.blockStateCollector.accept(
            MultipartBlockStateSupplier.create(table)
                .modelNoLock(top)
                .modelNoLock(whenTrue(TwigsProperties.TABLE_LEG1), side)
                .modelNoLock(whenTrue(TwigsProperties.TABLE_LEG2), Rotation.R90, side)
                .modelNoLock(whenTrue(TwigsProperties.TABLE_LEG3), Rotation.R180, side)
                .modelNoLock(whenTrue(TwigsProperties.TABLE_LEG4), Rotation.R270, side)
        )
        gen.registerParentedItemModel(table, inventory)
    }

    override fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible> = listOf(table)
}