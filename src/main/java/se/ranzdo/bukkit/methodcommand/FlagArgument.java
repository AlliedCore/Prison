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

package se.ranzdo.bukkit.methodcommand;

import org.bukkit.command.CommandSender;


public class FlagArgument extends CommandArgument {
    private final Flag flag;

    public FlagArgument(Arg commandArgAnnotation, Class<?> argumentClass, ArgumentHandler<?> argumentHandler, Flag flag) {
        super(commandArgAnnotation, argumentClass, argumentHandler);
        this.flag = flag;
    }

    public FlagArgument(String name, String description, String def, String verifiers, Class<?> argumentClass, ArgumentHandler<?> handler, Flag flag) {
        super(name, description, def, verifiers, argumentClass, handler);
        this.flag = flag;
    }

    @Override
    public Object execute(CommandSender sender, Arguments args) throws CommandError {
        String arg;
        if (!args.flagExists(flag))
            arg = getDefault();
        else if (!args.hasNext(flag))
            throw new CommandError("The argument s [" + getName() + "] to the flag -" + flag.getIdentifier() + " is not defined");
        else
            arg = CommandUtil.escapeArgumentVariable(args.nextFlagArgument(flag));

        return getHandler().handle(sender, this, arg);
    }

    public Flag getFlag() {
        return flag;
    }
}
