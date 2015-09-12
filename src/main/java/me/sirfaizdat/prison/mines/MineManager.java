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

import me.sirfaizdat.prison.Prison;
import org.apache.commons.lang.Validate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Responsible for loading, saving, and storing mines.
 *
 * @author SirFaizdat
 */
public class MineManager {

    // == Variables

    private List<Mine> mines;
    private File minesFolder;

    // == Constructor

    public MineManager() {
        mines = new ArrayList<>();
        minesFolder = new File(Prison.get().getDataFolder(), "mines");
        if (!minesFolder.exists()) minesFolder.mkdirs();
    }

    // == Methods

    /**
     * Loop through all files in the mines folder, deserialize them, and add them to the Mines list.
     */
    public void load() {
        File[] files = minesFolder.listFiles();
        for (File file : files) {
            try {
                mines.add(Mine.deserialize(file));
            } catch (IOException e) {
                // Print a warning to the console, an just attempt to load the next one.
                Prison.l().log(Level.WARNING, "Could not load mine " + file.getName() + ".", e);
            }
        }
        // All mines loaded, log success message.
        Prison.l().info("Successfully loaded " + mines.size() + " files.");
    }

    // == Private methods

    // == Static methods

    // == Getters and setters

    /**
     * Retrieves a mine by name.
     *
     * @param mineName The name of the mine to get.
     * @return The Mine object, or null if none was found by the specified name.
     */
    public Mine getMine(String mineName) {
        Validate.notNull(mineName);
        for (Mine mine : mines) if (mine.getMineName().equals(mineName)) return mine;
        return null;
    }

}
