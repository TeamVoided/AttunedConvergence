package org.teamvoided.attuned_convergence.data.gen.provider

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import org.teamvoided.attuned_convergence.init.ACItems
import org.teamvoided.attuned_convergence.init.ACTabs
import java.util.concurrent.CompletableFuture

@Suppress("MemberVisibilityCanBePrivate")
internal class EnLangProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) : FabricLanguageProvider(o, r) {
    override fun generateTranslations(lookup: HolderLookup.Provider, gen: TranslationBuilder) {
        ACItems.ITEMS.forEach { gen.add(it.translationKey, genLang(it.id)) }
        ACTabs.AC_TAB.registryKey.let{ gen.add(it, genLang(it.value)) }
    }

    private fun genLang(identifier: Identifier): String =
        identifier.path.split("_").joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }

    val Item.id get() = Registries.ITEM.getId(this)
    val Block.id get() = Registries.BLOCK.getId(this)
}