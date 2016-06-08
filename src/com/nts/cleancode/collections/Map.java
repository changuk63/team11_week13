package com.nts.cleancode.collections;

public class Map extends AbstractCollection {
	private static int INITIAL_CAPACITY = 10;
	protected Object[] keys = new Object[INITIAL_CAPACITY];
	protected Object[] values = new Object[INITIAL_CAPACITY];
	private int indexWhereKeyFound;
	public void add(Object key, Object value) {
		if (!readOnly) {
			for (int i = 0; i < size; i++)
				if (keys[i].equals(key)) {
					values[i] = value;
					return;
				}

			int newSize = size + 1;
			if (newSize > keys.length) {
				Object[] newKeys = new Object[keys.length + INITIAL_CAPACITY];
				Object[] newValues = new Object[keys.length + INITIAL_CAPACITY];
				System.arraycopy(keys, 0, newKeys, 0, size);
				System.arraycopy(values, 0, newValues, 0, size);
				keys = newKeys;
				values = newValues;
			}

			keys[size] = key;
			values[size] = value;
			size++;
		}
	}

	public boolean remove(Object key) {
		if (readOnly)
			return false;
		for (int i = 0; i < size; i++)
			if (keys[i].equals(key)) {
				keys[i] = null;
				values[i] = null;
				size--;
				return true;
			}
		return false;
	}

	public boolean containsKey(Object key) {
		for (int i = 0; i < size; i++)
			if (keys[i] != null && keys[i].equals(key)) {
				indexWhereKeyFound = i;
				return true;
			}
		return false;
	}

	public Object get(Object key) {
		if (!containsKey(key))
			return null;
		return values[indexWhereKeyFound];
	}
}
