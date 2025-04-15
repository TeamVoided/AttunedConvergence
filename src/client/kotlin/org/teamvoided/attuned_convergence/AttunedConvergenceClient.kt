package org.teamvoided.attuned_convergence

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer
import org.teamvoided.attuned_convergence.init.ACBlocks.CUTOUT_BLOCKS

@Suppress("unused")
object AttunedConvergenceClient {
    fun init() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), *CUTOUT_BLOCKS.toTypedArray())
    }
}
