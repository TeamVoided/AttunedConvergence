package org.teamvoided.attuned_convergence.init

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroup.EntrySupplier
import net.minecraft.item.ItemStack
import net.minecraft.registry.Holder
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import org.teamvoided.attuned_convergence.AttunedConvergence.MODID
import org.teamvoided.attuned_convergence.AttunedConvergence.id
import org.teamvoided.attuned_convergence.compat.CompatManager

object ACTabs {
    val AC_TAB = register("attuned_convergence", ACItems.ITEMS.random()) { params, entries ->
        CompatManager.COMPAT_LIST.forEach {
            entries.addStacks(it.getTabEntire(params).map(::ItemStack))
        }
    }

    fun init() = Unit
    fun register(id: String, icon: ItemConvertible, entires: EntrySupplier): Holder.Reference<ItemGroup> {
        return Registry.registerHolder(Registries.ITEM_GROUP, id(id),
            FabricItemGroup.builder()
                .name(Text.translatable("itemGroup.$MODID.$id"))
                .icon { ItemStack(icon) }
                .entries(entires)
                .build()
        )
    }
}