package org.teamvoided.attuned_convergence.compat

import net.fabricmc.loader.api.FabricLoader


object CompatVariables {
    var DUSKS_AND_DUNGEONS = "dusk_autumn"
    var ARCHITECTS_PALETTE = "architects_palette"
    var TWIGS = "twigs"
    var MAKE_IT_GOTH = "makeitgoth"
    var VOIDED_VARIANCE = "voided_variance"

    var DusksAndDungeons = false
    var ArchitectsPalette = false
    var Twigs = false
    var MakeItGoth = false
    var VoidedVariance = false

    internal fun init() {
        if (loaded(DUSKS_AND_DUNGEONS)) DusksAndDungeons = true
        if (loaded(ARCHITECTS_PALETTE)) ArchitectsPalette = true
        if (loaded(TWIGS)) Twigs = true
        if (loaded(MAKE_IT_GOTH)) MakeItGoth = true
        if (loaded(VOIDED_VARIANCE)) VoidedVariance = true
    }

    fun loaded(modId: String) = FabricLoader.getInstance().isModLoaded(modId)
}