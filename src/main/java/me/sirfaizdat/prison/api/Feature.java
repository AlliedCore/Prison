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

package me.sirfaizdat.prison.api;

/**
 * A Feature class contains initialization and deinitialization methods
 * that are called by the main class. Adding your own features is trivial;
 * just make one and register it using the API.
 *
 * @author SirFaizdat
 */
public interface Feature {

    /**
     * Initialize the feature here. This is called after the API loads,
     * so you can use the API in you initialization methods.
     */
    void init();

    /**
     * De-initialize your feature here. This will be called before the API
     * is unloaded, so feel free to do whatever you want with the API here.
     */
    void deinit();

}
