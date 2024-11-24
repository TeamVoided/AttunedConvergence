package org.teamvoided.attuned_convergence.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.registry.RegistrySetBuilder
import org.teamvoided.attuned_convergence.AttunedConvergence.log
import org.teamvoided.attuned_convergence.data.gen.provider.EnLangProvider
import org.teamvoided.attuned_convergence.data.gen.provider.LootTableProvider
import org.teamvoided.attuned_convergence.data.gen.provider.ModelProvider
import org.teamvoided.attuned_convergence.data.gen.provider.RecipeProvider
import org.teamvoided.attuned_convergence.data.gen.tag.BlockTagProvider
import org.teamvoided.attuned_convergence.data.gen.tag.ItemTagProvider

@Suppress("unused")
object AttunedConvergenceData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
        val pack = gen.createPack()

        pack.addProvider(::ModelProvider)
        pack.addProvider(::EnLangProvider)

        val blockTags = pack.addProvider(::BlockTagProvider)
        pack.addProvider { o, r -> ItemTagProvider(o, r, blockTags) }
        pack.addProvider(::LootTableProvider)
        pack.addProvider(::RecipeProvider)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
//        gen.add(RegistryKeys.BIOME, TemplateBiomes::boostrap)
    }
}
