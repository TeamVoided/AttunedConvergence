package org.teamvoided.attuned_convergence.init

import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.attuned_convergence.AttunedConvergence.id

object ACItems {
    val ITEMS = mutableListOf<Item>()
    fun register(id: String, item: Item): Item {
        val regItem = Registry.register(Registries.ITEM, id(id), item)
        ITEMS.add(regItem)
        return regItem
    }
}