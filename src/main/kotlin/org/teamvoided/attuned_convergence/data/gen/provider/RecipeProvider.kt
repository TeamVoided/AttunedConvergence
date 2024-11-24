package org.teamvoided.attuned_convergence.data.gen.provider

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.registry.HolderLookup
import org.teamvoided.attuned_convergence.compat.CompatManager
import java.util.concurrent.CompletableFuture

internal class RecipeProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricRecipeProvider(o, r) {
    override fun generateRecipes(e: RecipeExporter) {
        CompatManager.COMPAT_LIST.forEach { it.recipes { c: ResourceCondition -> this.withConditions(e, c) } }
    }
}