package org.example;

import java.util.HashMap;

/*
    Context Class - Represents shared memory for expressions during evaluation
 */
public class Context {
    private HashMap map = new HashMap();

    public Object get(Object name) {
        return map.get(name);
    }

    public void addVariable(Object name, Object value) {
        map.put(name, value);
    }
}
