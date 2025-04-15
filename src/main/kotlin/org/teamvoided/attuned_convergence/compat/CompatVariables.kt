package org.teamvoided.attuned_convergence.compat

import net.fabricmc.loader.api.FabricLoader


object CompatVariables {
    var DUSKS_AND_DUNGEONS = "dusk_autumn"
    var ARCHITECTS_PALETTE = "architects_palette"
    var TWIGS = "twigs"
    var FARMERS_DELIGHT = "farmersdelight"
    var MAKE_IT_GOTH = "makeitgoth"
    var VOIDED_VARIANCE = "voided_variance"

    var DusksAndDungeons = false
    var ArchitectsPalette = false
    var Twigs = false
    var FarmersDelight = false
    var MakeItGoth = false
    var VoidedVariance = false

    internal fun init() {
        loaded(DUSKS_AND_DUNGEONS) { DusksAndDungeons = true }
        loaded(ARCHITECTS_PALETTE) { ArchitectsPalette = true }
        loaded(TWIGS) { Twigs = true }
        loaded(FARMERS_DELIGHT) { FarmersDelight = true }
        loaded(MAKE_IT_GOTH) { MakeItGoth = true }
        loaded(VOIDED_VARIANCE) { VoidedVariance = true }
    }

    fun loaded(modId: String, fn: () -> Unit) {
        if (FabricLoader.getInstance().isModLoaded(modId)) fn()
    }
}