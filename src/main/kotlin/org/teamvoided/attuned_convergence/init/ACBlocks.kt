package org.teamvoided.attuned_convergence.init

import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.attuned_convergence.AttunedConvergence.id

object ACBlocks {
    val BLOCKS = mutableSetOf<Block>()
    val CUTOUT_BLOCKS = mutableSetOf<Block>()

    internal fun register(id: String, block: Block): Block {
        val regBlock = registerNoItem(id, block)
        ACItems.register(id, BlockItem(regBlock, Item.Settings()))
        return regBlock
    }

    internal fun registerNoItem(id: String, block: Block): Block {
        val regBlock = Registry.register(Registries.BLOCK, id(id), block)
        BLOCKS.add(regBlock)
        return regBlock
    }
}