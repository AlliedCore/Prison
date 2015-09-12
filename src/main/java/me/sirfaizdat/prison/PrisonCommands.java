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

package me.sirfaizdat.prison;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import se.ranzdo.bukkit.methodcommand.Command;

/**
 * Contains all the commands that are contained within the /prison command.
 *
 * @author SirFaizdat
 */
public class PrisonCommands {

    private final String[] VERSION_STRING = {
            "&7================ &3< &bPrison v" + Prison.get().getDescription().getVersion() + " &3>&7================",
            "&7Created by &bSirFaizdat &7(lead developer), and several other &btalented developers&7.",
            "&7Licensed under the GNU GPL v2 license.",
            "&7Type &b/prison help &7for help using the /prison command."
    };

    @Command(identifier = "prison", description = "Manage Prison itself.", onlyPlayers = false, permissions = {"prison.manage"})
    public void rootCommand(CommandSender sender) {
        versionCommand(sender); // Just calls the equivalent of /prison version, nothing special here.
    }

    @Command(identifier = "prison version", description = "Check Prison's version.", onlyPlayers = false, permissions = {"prison.manage"})
    public void versionCommand(CommandSender sender) {
        // Just send them the version string, after coloring it of course.
        for (String msg : VERSION_STRING) sender.sendMessage(Prison.color(msg));
    }

    @Command(identifier = "prison extensions", description = "Lists all loaded Prison extentions.", onlyPlayers = false, permissions = {"prison.manage"})
    public void listExtentions(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "Not supported yet.");
    }

    @Command(identifier = "prison reload", description = "Reload the plugin entirely.", onlyPlayers = false, permissions = {"prison.manage"})
    public void reloadPlugin(CommandSender sender) {
        long startTime = System.currentTimeMillis(); // Time this
        Prison.get().reload(); // Reload
        long endTime = System.currentTimeMillis() - startTime;
        sender.sendMessage(Prison.lang().get("successful-reload", endTime)); // Brag about how fast it was ;)
    }

}
