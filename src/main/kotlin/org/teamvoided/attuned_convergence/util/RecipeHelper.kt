package org.teamvoided.attuned_convergence.util

import net.minecraft.advancement.criterion.InventoryChangedCriterionTrigger
import net.minecraft.block.Block
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeJsonFactory
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory
import net.minecraft.item.Item
import net.minecraft.recipe.RecipeCategory
import net.minecraft.registry.Registries

fun stair(e: RecipeExporter, block: Block, base: Block) {
    ShapedRecipeJsonFactory.create(RecipeCategory.BUILDING_BLOCKS, block, 4)
        .pattern("#  ")
        .pattern("## ")
        .pattern("###")
        .ingredient('#', base)
        .crit(base)
        .offerTo(e)
}

fun slab(e: RecipeExporter, block: Block, base: Block) {
    ShapedRecipeJsonFactory.create(RecipeCategory.BUILDING_BLOCKS, block, 6)
        .pattern("###")
        .ingredient('#', base)
        .crit(base)
        .offerTo(e)
}

fun wall(e: RecipeExporter, block: Block, base: Block) {
    ShapedRecipeJsonFactory.create(RecipeCategory.BUILDING_BLOCKS, block, 6)
        .pattern("###")
        .pattern("###")
        .ingredient('#', base)
        .crit(base)
        .offerTo(e)
}


fun RecipeJsonFactory.crit(base: Block): RecipeJsonFactory {
    return this.criterion("has_${base.id.path}", InventoryChangedCriterionTrigger.Conditions.create(base))
}

fun RecipeJsonFactory.crit(base: Item): RecipeJsonFactory {
    return this.criterion("has_${base.id.path}", InventoryChangedCriterionTrigger.Conditions.create(base))
}

val Block.id get() = Registries.BLOCK.getId(this)
val Item.id get() = Registries.ITEM.getId(this)
