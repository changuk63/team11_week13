package com.nts.cleancode.collections;

public abstract class AbstractCollection{
	protected int size = 0;
	protected Object[] elements = new Object[10];
	protected boolean readOnly;
	public void addAll(AbstractCollection c) {
		for (int i=0; i < c.size(); i++) {
			if (!contains(c.get(i))) {
				add(c.get(i));
			}
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
