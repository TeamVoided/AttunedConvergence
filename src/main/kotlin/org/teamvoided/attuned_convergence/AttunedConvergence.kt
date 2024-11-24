package org.teamvoided.attuned_convergence

import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.attuned_convergence.compat.CompatManager
import org.teamvoided.attuned_convergence.compat.CompatVariables
import org.teamvoided.attuned_convergence.init.ACTabs
import org.teamvoided.dusk_autumn.DusksAndDungeons

@Suppress("unused")
object AttunedConvergence {
    const val MODID = "attuned_convergence"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(AttunedConvergence::class.simpleName)
    private var isInit = false

    fun init() {
        if (isInit) return
        isInit = true
        log.info("Attuning Convergences...")
        DusksAndDungeons.init()
        CompatVariables.init()
        CompatManager.init()
        ACTabs.init()
    }

    fun id(path: String) = Identifier.of(MODID, path)
}
