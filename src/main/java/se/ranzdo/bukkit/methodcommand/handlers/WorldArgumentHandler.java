/*
 * Copyright (C) 2015 The Apocalypse MC.
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

package se.ranzdo.bukkit.methodcommand.handlers;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import se.ranzdo.bukkit.methodcommand.*;


public class WorldArgumentHandler extends ArgumentHandler<World> {
    public WorldArgumentHandler() {
        setMessage("world_not_found", "The world \"%1\" was not found");

        addVariable("sender", "The command executor", new ArgumentVariable<World>() {
            @Override
            public World var(CommandSender sender, CommandArgument argument, String varName) throws CommandError {
                if (!(sender instanceof Player))
                    throw new CommandError(argument.getMessage("cant_as_console"));

                return ((Player) sender).getWorld();
            }
        });
    }

    @Override
    public World transform(CommandSender sender, CommandArgument argument, String value) throws TransformError {
        World world = Bukkit.getWorld(value);
        if (world == null)
            throw new TransformError(argument.getMessage("world_not_found", value));
        return world;
    }
}
