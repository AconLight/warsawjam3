package com.mygdx.game.desktop;

import java.util.ArrayList;

public class UltimateDupaRandomizer {
	
	public static void main (String[] arg) {
		
	}
	
	interface RandomizationMethod {
		ArrayList<Integer> method(int size);
	}
	
	<T> ArrayList<T> randomizationModification(RandomizationMethod judeMethod) {
		ArrayList<T> list = new ArrayList<T>();
		
		
		return list;
	}
	
}
