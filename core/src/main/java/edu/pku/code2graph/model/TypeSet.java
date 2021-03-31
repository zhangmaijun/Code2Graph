/*
 * This file is part of GumTree.
 *
 * GumTree is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GumTree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GumTree.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2015-2017 Floréal Morandat <florealm@gmail.com>
 */
package edu.pku.code2graph.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TypeSet implements Serializable {
  private static final long serialVersionUID = -1614103266188826641L;

  private static final TypeFactoryImplementation implementation = new TypeFactoryImplementation();

  public static Type type(String name) {
    return implementation.makeOrGetType(name);
  }

  public static Type type(String name, boolean isEntity) {
    return implementation.makeOrGetType(name, isEntity);
  }

  private static class TypeFactoryImplementation extends Type.TypeFactory {
    private final Map<String, Type> types = new HashMap<>();

    public Type makeOrGetType(String name) {
      //            return types.computeIfAbsent(name == null ? "" : name, (key) -> makeType(key));
      if (name == null) name = "";

      Type sym = types.get(name);
      if (sym == null) {
        sym = makeType(name);
        types.put(name, sym);
      }

      return sym;
    }

    public Type makeOrGetType(String name, boolean isEntity) {
      //            return types.computeIfAbsent(name == null ? "" : name, (key) -> makeType(key));
      if (name == null) name = "";

      Type sym = types.get(name);
      if (sym == null) {
        sym = makeType(name, isEntity);
        types.put(name, sym);
      }

      return sym;
    }
  }
}
