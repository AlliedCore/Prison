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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectionUtil {
    @SuppressWarnings("unchecked")
    public static <T extends Annotation> T getAnnotation(Class<T> clazz, Method method, int parameterIndex) {
        for (Annotation annotation : method.getParameterAnnotations()[parameterIndex]) {
            if (annotation.annotationType() == clazz) {
                return (T) annotation;
            }
        }
        return null;
    }
}
