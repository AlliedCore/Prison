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

package me.sirfaizdat.prison.api;

import me.sirfaizdat.prison.Prison;

/**
 * A class that extends Extension will be considered the main
 * class for your extension. All initialization shall go here.
 *
 * @author SirFaizdat
 */
public abstract class Extension {

    /**
     * Called when the extension is being enabled.
     */
    public void onEnable() {
    }

    /**
     * Called when the extension is being disabled.
     */
    public void onDisable() {
    }

    /**
     * Register all command annotations (se.ranzdo.bukkit.methodcommand.@Command) from
     * an object into the plugin.
     *
     * @param commandObject The Object containing the annotations to register.
     */
    public final void registerCommands(Object commandObject) {
        Prison.get().commandHandler.registerCommands(commandObject);
    }

}
