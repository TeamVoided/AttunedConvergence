package org.teamvoided.attuned_convergence

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer
import org.teamvoided.attuned_convergence.init.ACBlocks

@Suppress("unused")
object AttunedConvergenceClient {
    fun init() {
        ACBlocks.CUTOUT_BLOCKS.forEach { BlockRenderLayerMap.INSTANCE.putBlock(it, RenderLayer.getCutout()) }
    }
}
