package org.teamvoided.attuned_convergence.data.gen.tag

import com.ninni.twigs.TwigsTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.ItemTags
import org.teamvoided.dusk_autumn.data.tags.DnDBlockTags
import org.teamvoided.dusk_autumn.data.tags.DnDItemTags
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
        copy(DnDBlockTags.LEAF_PILES, DnDItemTags.LEAF_PILES)
        copy(DnDBlockTags.LOG_PILES_THAT_BURN, DnDItemTags.LOG_PILES_THAT_BURN)
        copy(DnDBlockTags.LOG_PILES, DnDItemTags.LOG_PILES)
    }
}