package org.teamvoided.attuned_convergence.init

import architectspalette.core.registry.util.BlockNode
import architectspalette.core.registry.util.BlockNode.DataFlag
import architectspalette.core.registry.util.BlockNode.Tool
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.attuned_convergence.AttunedConvergence.id
import org.teamvoided.attuned_convergence.init.mod.ArchitectsPaletteCompat
import org.teamvoided.attuned_convergence.init.mod.DusksAndDungeonsCompat
import org.teamvoided.attuned_convergence.init.mod.MakeItGothCompat

object ACBlocks {
    fun init() {
        DusksAndDungeonsCompat.init()
        ArchitectsPaletteCompat.init()
        MakeItGothCompat.init()

    }

    internal fun register(id: String, block: Block): Block {
        val regBlock = registerNoItem(id, block)
        ACItems.register(id, BlockItem(regBlock, Item.Settings()))
        return regBlock
    }

    internal fun createBoardNode(name: String, block: Block): BlockNode {
        val regBlock = register(name, block)
        var node = BlockNode.Builder()
            .tool(Tool.AXE)
            .base { regBlock }
            .commonVariants()
            .flag(DataFlag.BOARDS)
            .build()
//        APBlocks.boards.add(node)
        return node
    }

    internal fun registerNoItem(id: String, block: Block): Block {
        val regBlock = Registry.register(Registries.BLOCK, id(id), block)
        return regBlock
    }
}