package org.teamvoided.attuned_convergence.util.model

import net.minecraft.block.Block
import net.minecraft.data.client.model.Model
import net.minecraft.data.client.model.ModelIds
import net.minecraft.data.client.model.TextureKey
import net.minecraft.data.client.model.TextureKey.*
import net.minecraft.util.Identifier
import java.util.Optional

val TABLE_INVENTORY = model("twigs:block/template_table_inventory", "_inventory", SIDE, BOTTOM, TOP, PARTICLE)
var TABLE_LEG = model("twigs:block/template_table_leg", "_leg", SIDE, BOTTOM, TOP, PARTICLE)
var TABLE_TOP = model("twigs:block/template_table_top", "_top", SIDE, BOTTOM, TOP, PARTICLE)

fun model(parent: String, suffix: String, vararg textureSlots: TextureKey): Model {
    return model(Identifier.parse(parent), suffix, *textureSlots)
}
fun model(parent: Identifier, suffix: String, vararg textureSlots: TextureKey): Model {
    return Model(Optional.of<Identifier>(parent), Optional.of(suffix), *textureSlots)
}

fun Block.model(): Identifier = ModelIds.getBlockModelId(this)
fun Block.model(suffix: String): Identifier = this.model().suffix(suffix)
fun Identifier.suffix(str: String) = Identifier.of(this.namespace, "${this.path}$str")

