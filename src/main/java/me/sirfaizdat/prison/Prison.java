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

import se.ranzdo.bukkit.methodcommand.CommandHandler;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The main class for the Prison plugin. Initializes all features
 * and extensions.
 *
 * @author SirFaizdat
 */
public class Prison extends JavaPlugin {

    // == Variables
    private static Prison instance;
    private static PrisonLogger logger;

    private CommandHandler commandHandler;

    // == Methods

    public void onEnable() {
        // Initialize static variables
        instance = this;
        logger = new PrisonLogger();
        long startTime = System.currentTimeMillis(); // Time the enabling

        // Core initialization

        commandHandler = new CommandHandler(this);
        commandHandler.registerCommands(new PrisonCommands());

        // Feature initialization

        // Extension initialization

        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.info("Enabled Prison v" + getDescription().getVersion() + " in " + elapsedTime + "ms. Created by SirFaizdat.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Tell the CommandHandler about this command.
        return commandHandler.onCommand(sender, command, label, args);
    }

    // == Private methods

    // == Static methods

    public static Prison get() {
        return instance;
    }

    /**
     * Retrieve the PrisonLogger, which allows for colored log messages
     * and other functionalities.
     *
     * @return The PrisonLogger object.
     */
    public static PrisonLogger l() {
        return logger;
    }

    /**
     * Translates &-prefixed color codes to MC color codes.
     *
     * @param txt The String to transalte the color codes of.
     * @return The fully colored string.
     */
    public static String color(String txt) {
        return ChatColor.translateAlternateColorCodes('&', txt);
    }

    // == Getters and setters

}
