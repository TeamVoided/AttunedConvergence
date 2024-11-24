package org.teamvoided.attuned_convergence.util.model

import net.minecraft.data.client.model.BlockStateVariant
import net.minecraft.data.client.model.MultipartBlockStateSupplier
import net.minecraft.data.client.model.VariantSettings
import net.minecraft.data.client.model.VariantSettings.Rotation
import net.minecraft.data.client.model.When
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.Identifier

fun MultipartBlockStateSupplier.modelNoLock(identifier: Identifier) =
    this.with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.UVLOCK, false))


fun MultipartBlockStateSupplier.modelNoLock(condition: When, identifier: Identifier) = this.with(
    condition, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.UVLOCK, false)
)

fun MultipartBlockStateSupplier.modelNoLock(condition: When, rotation: Rotation, identifier: Identifier) = this.with(
    condition, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.UVLOCK, false)
        .put(VariantSettings.Y, rotation)
)

fun whenTrue(property: BooleanProperty) = When.PropertyCondition().set(property, true)