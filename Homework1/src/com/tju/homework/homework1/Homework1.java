package com.tju.homework.homework1;

import java.util.*;

public class Homework1 {
	private static int[] c = {1,1,1,5,5,10,20,50};
	private Set<Integer> set = new HashSet<>();
	Homework1() {
		for (int i=0; i<(1<<c.length); i++) {
			int sum=0;
			for (int j=0; j<c.length; j++) {
				if ((i>>j&1)==1) {
					sum+=c[j];
				}
			}
			set.add(sum);
		}
	}
	public boolean solve(int x) {
		return set.contains(x);
	}
}
