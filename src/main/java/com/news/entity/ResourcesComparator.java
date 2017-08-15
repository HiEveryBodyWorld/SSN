package com.news.entity;

import java.util.Comparator;

public class ResourcesComparator implements Comparator<Resources> {
	@Override
	public int compare(Resources o1, Resources o2) {
		Resources r1 = (Resources)o1;
		Resources r2 = (Resources)o2;
		return r1.getSortNum().compareTo(r2.getSortNum());
	}

}
