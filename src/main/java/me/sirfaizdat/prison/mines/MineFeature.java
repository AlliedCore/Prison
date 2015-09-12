/*
 * Copyright (C) 2015 SirFaizdat
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package me.sirfaizdat.prison.mines;

import me.sirfaizdat.prison.api.Feature;

/**
 * @author SirFaizdat
 */
public class MineFeature implements Feature {

    // == Variables

    private MineManager mineManager;

    // == Methods

    @Override
    public void init() {
        mineManager = new MineManager();
        mineManager.load(); // Load all mines
    }

    @Override
    public void deinit() {

    }

    // == Private methods

    // == Static methods

    // == Getters and setters

}
