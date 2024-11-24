package org.teamvoided.attuned_convergence.data.gen.tag

import com.ninni.twigs.TwigsTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.ItemTags
import java.util.concurrent.CompletableFuture

internal class ItemTagProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>, blockTags: BlockTagProvider) :
    FabricTagProvider.ItemTagProvider(o, r, blockTags) {
    override fun configure(wrapperLookup: HolderLookup.Provider) {
        copyTags()
    }

    fun copyTags() {
        copy(BlockTags.STAIRS, ItemTags.STAIRS)
        copy(BlockTags.SLABS, ItemTags.SLABS)
        copy(BlockTags.WALLS, ItemTags.WALLS)
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS)
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS)

        // Modded
        copy(TwigsTags.TABLES_BLOCK, TwigsTags.TABLES_ITEM)
    }
}