package org.teamvoided.attuned_convergence.util

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Block

fun FabricTagProvider<Block>.FabricTagBuilder.opt(block: Block): FabricTagProvider<Block>.FabricTagBuilder {
    this.addOptional(block.id)
    return this
}