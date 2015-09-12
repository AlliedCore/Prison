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

import me.sirfaizdat.prison.json.GsonUtil;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;

/**
 * JSON-serializable data class that stores information about the mines.
 *
 * @author SirFaizdat
 */
public class Mine {

    // Variables
    private String mineName;
    private String mineWorld;
    private Location startX, endX;

    // Methods

    /**
     * Serialize the Mine object into a file.
     *
     * @param file The file to serialize into. If it was not found, it will be created.
     * @throws IOException If the file could not be created or could not be written to.
     */
    public void serialize(File file) throws IOException {
        if (!file.exists()) file.createNewFile();
        GsonUtil.serialize(file, this);
    }

    /**
     * Deserialize a file into a Mine object.
     *
     * @param file The File to deseriaize.
     * @return The Mine object.
     * @throws IOException If the file was not found or could not be deserialized.
     */
    public static Mine deserialize(File file) throws IOException {
        return GsonUtil.deserialize(file, Mine.class);
    }

    // Getters and setters

    public String getMineName() {
        return mineName;
    }

    public String getMineWorld() {
        return mineWorld;
    }

    public Location getStartX() {
        return startX;
    }

    public Location getEndX() {
        return endX;
    }

}
