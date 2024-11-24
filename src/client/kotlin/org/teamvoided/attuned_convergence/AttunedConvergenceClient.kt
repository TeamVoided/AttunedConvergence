package org.teamvoided.attuned_convergence

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer
import org.teamvoided.attuned_convergence.AttunedConvergence.log
import org.teamvoided.attuned_convergence.compat.CompatManager

@Suppress("unused")
object AttunedConvergenceClient {
    fun init() {
        CompatManager.COMPAT_LIST.flatMap { it.getCutout() }.forEach { block ->
            log.info("Adding $block to cutout")
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout())
        }
    }
}
