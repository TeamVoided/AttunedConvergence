package org.teamvoided.attuned_convergence.compat.module

import com.ninni.twigs.util.RecipeHelper.quickTableRecipe
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.minecraft.block.AbstractBlock.Settings.copy
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.data.client.model.*
import net.minecraft.data.client.model.TexturedModel.ORIENTABLE
import net.minecraft.data.client.model.VariantSettings.Rotation
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.math.Direction
import org.teamvoided.attuned_convergence.block.ACCabinetBlock
import org.teamvoided.attuned_convergence.compat.CompatVariables.FARMERS_DELIGHT
import org.teamvoided.attuned_convergence.init.ACBlocks.register
import org.teamvoided.attuned_convergence.util.model.model
import org.teamvoided.attuned_convergence.util.mods
import org.teamvoided.attuned_convergence.util.opt
import vectorwing.farmersdelight.common.block.CabinetBlock

class FDCabinets(val modId: String, name: String, var slab: Block, var trapdoor: Block) : Module {
    override fun modId() = modId
    val condition = mods(FARMERS_DELIGHT, modId())
    val cabinet = register("${name}_cabinet", ACCabinetBlock(copy(Blocks.BARREL)))
    override fun blockTags(tagBuilder: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder) {
        tagBuilder(BlockTags.AXE_MINEABLE).opt(cabinet)
//        tagBuilder(FDTags.CABINETS).opt(cabinet)
    }

    override fun recipes(makeConditional: (ResourceCondition) -> RecipeExporter) {
        val e = makeConditional(condition)
        quickTableRecipe(e, cabinet, slab, trapdoor, trapdoor)
    }

    override fun lootTables(rawGen: FabricBlockLootTableProvider) {
        val gen = rawGen.withConditions(condition)
        gen.addDrop(cabinet)
    }

    override fun models(gen: BlockStateModelGenerator) {
        val openTexture = ORIENTABLE.updateTexture {
            it.put(TextureKey.FRONT, cabinet.model("_front_open"))
        }


        val cabinetModel = ORIENTABLE.create(cabinet, gen.modelCollector)
        val openModel = openTexture.createWithSuffix(cabinet, "_open", gen.modelCollector)
        gen.blockStateCollector.accept(
            VariantsBlockStateSupplier.create(cabinet).coordinate(
                BlockStateVariantMap.create(CabinetBlock.FACING, CabinetBlock.OPEN).register { facing, open ->
                    val variant = BlockStateVariant.create()
                    if (open) variant.put(VariantSettings.MODEL, openModel)
                    else variant.put(VariantSettings.MODEL, cabinetModel)
                    when (facing) {
                        Direction.EAST -> variant.put(VariantSettings.Y, Rotation.R90)
                        Direction.SOUTH -> variant.put(VariantSettings.Y, Rotation.R180)
                        Direction.WEST -> variant.put(VariantSettings.Y, Rotation.R270)
                        else -> Unit
                    }
                    variant
                }
            )
        )
        gen.registerParentedItemModel(cabinet, cabinetModel)
    }

    override fun getTabEntire(params: ItemGroup.DisplayParameters): List<ItemConvertible> = listOf(cabinet)
}