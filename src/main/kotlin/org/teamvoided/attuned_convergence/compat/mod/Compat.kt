package org.teamvoided.attuned_convergence.compat.mod

import org.teamvoided.attuned_convergence.compat.module.Module

interface Compat {
    fun populate(content: MutableSet<Module>)
    /*
        // --- WOOD COMPAT ---
        - Leaf Piles
        - Wood Stairs, Slabs, Walls
        - Log Piles
        - Twigs Table
        - Railings
        - Boards & there Stairs, Slabs, Walls

        // --- BIG COMPAT ---
        - Big Lantern
        - Lamp (Twigs Big Lamp)
        - Big Chain

        // --- STONE COMPAT ---
        - Cracked Stairs, Slabs, Walls
        - Mossy -> Overgrown
        - Pillar
        - Big and Small Grave
        - Column
        - Bricks -> Heavy Bricks
        - Infested

        // --- FIRE COMPAT ---
        (if missing)
        - Torch
        - Campfire
        ---
        - Candles
        - Big Candles
        - Candelabras

        // --- MICRO-BLOCK COMPAT ---
        - Nubs
        - "Better" walls

    */
}
