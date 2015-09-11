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

import org.bukkit.command.CommandSender;
import se.ranzdo.bukkit.methodcommand.CommandArgument;
import se.ranzdo.bukkit.methodcommand.TransformError;

public class DoubleArgumentHandler extends NumberArgumentHandler<Double> {
    public DoubleArgumentHandler() {
        setMessage("parse_error", "The parameter [%p] is not a number");
    }

    @Override
    public Double transform(CommandSender sender, CommandArgument argument, String value) throws TransformError {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new TransformError(argument.getMessage("parse_error"));
        }
    }
}
