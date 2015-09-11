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
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import java.util.Random;
import java.util.logging.Level;

import static java.util.logging.Level.*;
import static net.md_5.bungee.api.ChatColor.*;

/**
 * A custom logger with a few extra features.
 *
 * @author SirFaizdat
 */
public class PrisonLogger {

    // == Variables
    ConsoleCommandSender consoleSender; // Allows colors in console.
    String coloredPrefix; // A fun, colorful prefix.
    boolean debugMode = false; // If true, debug (Level.FINE) messages will print.
    // A list of random chat colors to choose from (randomly chosen for the prefix)
    private ChatColor[] randomChatColors = {AQUA, GOLD, DARK_AQUA, RED, GREEN};

    // == Constructor

    public PrisonLogger() {
        this.consoleSender = Bukkit.getConsoleSender();
        // Construct a prefix with the Prison.get()'s name colored with a random color.
        this.coloredPrefix = Prison.color("&7[" + getRandomColor() + Prison.get().getName() + "&7]&r");
    }

    // == Methods

    /**
     * Logs a message to the console.
     *
     * @param level     The log level to log as. If the log level is Level.FINE, it will log as a debug message.
     * @param message   The message to log. This doesn't have to be pre-colored, this method colors it for you.
     * @param exception The exception thrown, or null if none was thrown.
     */
    public void log(Level level, String message, Throwable exception) {
        Validate.notNull(level);
        Validate.notNull(message);

        // Don't log debug messages if it isn't enabled.
        if (level == FINE && !debugMode) return;

        // Construct the full colored message
        String levelName = level.getName().toUpperCase();
        if (levelName.equals("FINE")) levelName = "DEBUG";

        StringBuilder builder = new StringBuilder();
        builder.append(coloredPrefix).append(" ");
        builder.append(getLevelColorCode(level)).append(levelName).append(": ");
        builder.append(message);
        String fullMessage = Prison.color(builder.toString());

        // Send the message
        consoleSender.sendMessage(fullMessage);

        // Print the stack trace of the exception
        if (exception != null) {
            severe("Below is the full error message, please report this and the line before this to the developer.");
            exception.printStackTrace();
        }
    }

    public void log(Level level, String message) {
        log(level, message, null);
    }

    public void debug(String message) {
        log(FINE, message);
    }

    public void info(String message) {
        log(INFO, message);
    }

    public void warning(String message) {
        log(WARNING, message);
    }

    public void severe(String message) {
        log(SEVERE, message);
    }

    // == Private methods

    private String getLevelColorCode(Level level) {
        if (level == FINE) return "&e";
        if (level == INFO) return "&a";
        if (level == WARNING) return "&6";
        if (level == SEVERE) return "&c";
        return "&7"; // Grey as default
    }

    // == Getters and setters

    /**
     * Choose a random color.
     *
     * @return The randomly selected ChatColor.
     */
    public ChatColor getRandomColor() {
        // Choose a random color ID
        int colorID = new Random().nextInt(randomChatColors.length);
        return randomChatColors[colorID];
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }
}
