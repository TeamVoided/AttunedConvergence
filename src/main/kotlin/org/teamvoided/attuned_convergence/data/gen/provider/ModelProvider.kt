package org.teamvoided.attuned_convergence.data.gen.provider

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator
import org.teamvoided.attuned_convergence.compat.CompatManager

internal class ModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        CompatManager.COMPAT_LIST.forEach { it.models(gen) }
    }

    override fun generateItemModels(gen: ItemModelGenerator) {
    }
}