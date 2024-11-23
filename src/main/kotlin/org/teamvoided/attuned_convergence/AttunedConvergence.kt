package org.teamvoided.attuned_convergence

import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("unused")
object AttunedConvergence {
    const val MODID = "attuned_convergence"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(AttunedConvergence::class.simpleName)

    fun init() {
        log.info("Hello from Common")
    }

    fun id(path: String) = Identifier.of(MODID, path)
}
