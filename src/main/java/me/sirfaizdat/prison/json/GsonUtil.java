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

package me.sirfaizdat.prison.json;

import org.apache.commons.lang.Validate;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Simple static methods that allow you to easily serialize and deserialize objects.
 *
 * @author SirFaizdat
 */
public class GsonUtil {

    // Prevent accidental instantiation
    private GsonUtil() {
    }

    /**
     * Deserializes a JSON file to an object.
     *
     * @param jsonFile
     * @param clazz    The class to deserialize this object into.
     * @return The deserialized JSON object, in the form of the class specified.
     * @throws IOException If the file could not be read.
     */
    public static <T> T deserialize(File jsonFile, Class<T> clazz) throws IOException {
        Validate.notNull(jsonFile);
        Validate.notNull(clazz);
        if (!jsonFile.exists()) throw new IOException(jsonFile.getName() + " does not exist.");
        FileReader reader = new FileReader(jsonFile);
        T returnValue = GsonFactory.getCompactGson().fromJson(reader, clazz);
        reader.close();
        return returnValue;
    }

    /**
     * Serialize an object to pretty-printed JSON.
     *
     * @param jsonFile The file to write to. If it doesn't exist, it will be created.
     * @param obj      The Object to serialize.
     * @throws IOException If the file couldn't be created or if the object could not be serialized.
     */
    public static void serialize(File jsonFile, Object obj) throws IOException {
        Validate.notNull(jsonFile);
        Validate.notNull(obj);
        // Actually serialize the object to JSON.
        String json = GsonFactory.getPrettyGson().toJson(obj);
        // File IO stuff
        if (!jsonFile.exists()) jsonFile.createNewFile();
        FileWriter writer = new FileWriter(jsonFile);
        writer.write(json);
        writer.close();
    }

}
