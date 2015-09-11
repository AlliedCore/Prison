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
import se.ranzdo.bukkit.methodcommand.*;
import se.ranzdo.bukkit.methodcommand.VerifyError;


public class StringArgumentHandler extends ArgumentHandler<String> {
    public StringArgumentHandler() {
        setMessage("min_error", "The parameter [%p] must be more than %1 characters.");
        setMessage("max_error", "The parameter [%p] can't be more than %1 characters.");

        addVerifier("min", new ArgumentVerifier<String>() {
            @Override
            public void verify(CommandSender sender, CommandArgument argument, String verifyName, String[] verifyArgs, String value, String valueRaw) throws VerifyError {
                if (verifyArgs.length != 1)
                    throw new InvalidVerifyArgument(argument.getName());

                try {
                    int min = Integer.parseInt(verifyArgs[0]);
                    if (value.length() < min)
                        throw new VerifyError(argument.getMessage("min_error", verifyArgs[0]));
                } catch (NumberFormatException e) {
                    throw new InvalidVerifyArgument(argument.getName());
                }
            }
        });


        addVerifier("max", new ArgumentVerifier<String>() {
            @Override
            public void verify(CommandSender sender, CommandArgument argument, String verifyName, String[] verifyArgs, String value, String valueRaw) throws VerifyError {
                if (verifyArgs.length != 1)
                    throw new InvalidVerifyArgument(argument.getName());

                try {
                    int max = Integer.parseInt(verifyArgs[0]);
                    if (value.length() > max)
                        throw new VerifyError(argument.getMessage("max_error", verifyArgs[0]));
                } catch (NumberFormatException e) {
                    throw new InvalidVerifyArgument(argument.getName());
                }
            }
        });
    }

    @Override
    public String transform(CommandSender sender, CommandArgument argument, String value) throws TransformError {
        return value;
    }
}
