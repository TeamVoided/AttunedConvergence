package org.teamvoided.attuned_convergence.data.gen.provider

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.registry.HolderLookup
import org.teamvoided.attuned_convergence.compat.CompatManager
import java.util.concurrent.CompletableFuture

internal class LootTableProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricBlockLootTableProvider(o, r) {
    override fun generate() {
        CompatManager.COMPAT_LIST.forEach { it.lootTables(this) }
    }
}