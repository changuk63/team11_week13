package com.nts.cleancode.collections;

public abstract class AbstractCollection{
	protected int size = 0;
	protected Object[] elements = new Object[10];
	protected boolean readOnly;
	public void addAll(AbstractCollection c) {
		if (c instanceof Set) {
			Set s = (Set)c;
			for (int i=0; i < s.size(); i++) {
				if (!contains(s.getElementAt(i))) {
					add(s.getElementAt(i));
				}
			}
			
		} else if (c instanceof List) {
			AbstractCollection l = (AbstractCollection)c;
			for (int i=0; i < l.size(); i++) {
				if (!contains(l.get(i))) {
					add(l.get(i));
				}
			}
		} else if (c instanceof Map) {
			Map m = (Map)c;
			for (int i=0; i<m.size(); i++) 
				add(m.keys[i], m.values[i]);			
		}
	}
	
	public abstract boolean remove(Object element);
	public abstract boolean contains(Object element);
	
	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return elements.length;
	}

	public Object get(int i) {
		return elements[i];
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}

	public void add(Object element) {
		if (readOnly)
			return;
		
		if (shouldGrow())
			grow();
		
		addElement(element);
	}

	private boolean shouldGrow() {
		return (size + 1) > elements.length;
	}

	private void addElement(Object element) {
		elements[size++] = element;
	}

	private void grow() {
		Object[] newElements =
				new Object[elements.length + 10];
		for (int i = 0 ; i < size ; i++)
			newElements[i] = elements[i];
		elements = newElements;
	}
	
	
}
