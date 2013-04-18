/*
 * Copyright (C) Qatar Computing Research Institute, 2013.
 * All rights reserved.
 */

package qa.qcri.nadeef.core.datamodel;

import java.util.*;

/**
 * Tuple class.
 * TODO: consider using Trove for better hashmap performance.
 * TODO: use better index instead of string
 */
public class Tuple {

    //<editor-fold desc="Private Fields">
    private HashMap<Cell, Object> dict;
    private String[] tableNames;
    private int tupleId;
    //</editor-fold>

    //<editor-fold desc="Public Members">

    /**
     * Constructor.
     */
    public Tuple(int tupleId, Cell[] cells, Object[] values) {
        if (cells == null || values == null || tupleId < 1) {
            throw new IllegalArgumentException("Input attribute/value cannot be null.");
        }
        if (cells.length != values.length) {
            throw new IllegalArgumentException("Incorrect input with attributes and values");
        }

        dict = new HashMap(cells.length);
        HashSet<String> tableSet = new HashSet();
        for (int i = 0; i < cells.length; i ++) {
            dict.put(cells[i], values[i]);
            tableSet.add(cells[i].getTableName());
        }
        tableNames = tableSet.toArray(new String[tableSet.size()]);
        this.tupleId = tupleId;

    }

    /**
     * Gets the value from the tuple.
     * @param key The attribute key
     * @return Output Value
     */
    public Object get(Cell key) {
        return dict.get(key);
    }

    /**
     * Gets Tuple Id.
     * @return tuple id.
     */
    public int getTupleId() {
        return this.tupleId;
    }

    /**
     * Gets all the values in the tuple.
     * @return value collections.
     */
    public Collection<Object> getValues() {
        return dict.values();
    }

    /**
     * Gets all the cells in the tuple.
     * @return Attribute collection
     */
    public Cell[] getCells() {
        Set<Cell> keySet = dict.keySet();
        return keySet.toArray(new Cell[keySet.size()]);
    }

    /**
     * Check whether the tuple has an attribute.
     * @param cell Attribute name.
     * @return true when the attribute exists.
     */
    public boolean hasCell(Cell cell) {
        return dict.containsKey(cell);
    }

    /**
     * Gets the table names.
     * @return table names.
     */
    public String[] getTableNames() {
        return tableNames;
    }
    /**
     * Gets whether the tuple is from multiple tables.
     * @return True when the tuple is from multiple tables.
     */
    public boolean hasMoreThanOneTable() {
        return tableNames.length > 1;
    }
    //</editor-fold>

}
