package org.teamvoided.attuned_convergence.data.gen.tag

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.HolderLookup
import org.teamvoided.attuned_convergence.compat.CompatManager
import java.util.concurrent.CompletableFuture

internal class BlockTagProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.BlockTagProvider(o, r) {
    override fun configure(wrapperLookup: HolderLookup.Provider) {
        CompatManager.COMPAT_LIST.forEach { it.blockTags(this::getOrCreateTagBuilder) }
    }
}