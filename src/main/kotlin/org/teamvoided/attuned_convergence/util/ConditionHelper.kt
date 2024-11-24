package org.teamvoided.attuned_convergence.util

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions

fun mods(vararg mods: String): ResourceCondition {
    return ResourceConditions.allModsLoaded(*mods)
}