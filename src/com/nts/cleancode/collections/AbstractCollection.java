package com.nts.cleancode.collections;

public abstract class AbstractCollection{
	protected int size = 0;
	public void addAll(AbstractCollection c) {
		if (c instanceof Set) {
			Set s = (Set)c;
			for (int i=0; i < s.size(); i++) {
				if (!contains(s.getElementAt(i))) {
					add(s.getElementAt(i));
				}
			}
			
		} else if (c instanceof List) {
			List l = (List)c;
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
	public abstract int size();

	public boolean isEmpty() {
		return size == 0;
	}
	
	
}
