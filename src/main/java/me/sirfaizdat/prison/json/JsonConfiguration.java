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

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * A custom configuration file that holds keys and their associated values.
 *
 * @author SirFaizdat
 */
public class JsonConfiguration {

    // == Variables

    HashMap<String, Object> entries = new HashMap<>();
    @GsonFactory.Ignore
    HashMap<String, Object> defaults = new HashMap<>();
    @GsonFactory.Ignore
    File configurationFile;

    // == Constructor

    /**
     * Creates a new JSON Configuration that will write to a certain file.
     *
     * @param configurationFile The File to write to.
     */
    public JsonConfiguration(File configurationFile) {
        this.configurationFile = configurationFile;
    }

    // == Methods

    /**
     * Loads all of the variables from this config file.
     * This must be called after calling addDefault, and before
     * trying to access any variables.
     *
     * @throws IOException If the config file couldn't be loaded.
     */
    public void load() throws IOException {
        if (!configurationFile.exists()) save();
        JsonConfiguration configuration = GsonUtil.deserialize(configurationFile, JsonConfiguration.class);
        this.entries.putAll(configuration.entries); // Transfer all of the entries from the deserialized map to our map.
        // Check defaults to see if a key is missing.
        boolean defaultsAdded = false;
        for (String key : defaults.keySet()) {
            if (!this.entries.containsKey(key)) {
                // This default doesn't exist in the config, write it.
                this.entries.put(key, defaults.get(key));
                defaultsAdded = true;
            }
        }
        if (defaultsAdded) save();
    }

    /**
     * Saves the configuration file to disk (in pretty-printed JSON)
     *
     * @throws IOException If the configuration could not be serialized to JSON.
     */
    public void save() throws IOException {
        if (!configurationFile.exists()) configurationFile.createNewFile();
        GsonUtil.serialize(configurationFile, this);
    }

    /**
     * Clears all current entries and loads again.
     * This will also add any new defaults if they're added.
     *
     * @throws IOException If the config couldn't be loaded.
     */
    public void reload() throws IOException {
        this.entries.clear();
        load();
    }

    /**
     * Adds a default value to the configuration. If a default value
     * can't be found, it will be added upon load, which is useful for
     * when the plugin updates and there are new variables.
     *
     * @param key   The key (name) of the default value to be stored.
     * @param value The value of to associate with this key.
     */
    public void addDefault(String key, Object value) {
        defaults.put(key, value);
    }

    // == Getters and setters

    /*
     * Do-it-yourself getters
     */

    public Object get(String key) {
        return this.entries.get(key);
    }

    public <T> T get(String key, Class<T> clazz) {
        return clazz.cast(get(key));
    }


    public int getInt(String key) {
        return (int) get(key);
    }


    public short getShort(String key) {
        return (short) get(key);
    }


    public double getDouble(String key) {
        return (double) get(key);
    }


    public long getLong(String key) {
        return (long) get(key);
    }


    public String getString(String key) {
        return (String) get(key);
    }


    public List<Integer> getIntList(String key) {
        return (List<Integer>) get(key);
    }


    public List<Short> getShortList(String key) {
        return (List<Short>) get(key);
    }


    public List<Double> getDoubleList(String key) {
        return (List<Double>) get(key);
    }


    public List<Long> getLongList(String key) {
        return (List<Long>) get(key);
    }


    public List<String> getStringList(String key) {
        return (List<String>) get(key);
    }

    public HashMap<String, Object> getEntries() {
        return entries;
    }
}
