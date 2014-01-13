package ss.week5;

import java.util.LinkedList;
import java.util.List;

public class Sort{
	public static <T extends Comparable<T>> List<T> mergeSort(List<T> list){
		if(list.size() <= 1) return list;
		
		int middle = list.size() / 2;
		List<T> first = mergeSort(list.subList(0, middle));
		List<T> second = mergeSort(list.subList(middle, list.size()));
		
		List<T> result = new LinkedList<T>();
		
		return result;
	}
	
	public static void main(String[] args){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(4);
		
		printElements(mergeSort(list));
	}
	
	private static void printElements(List<Integer> merge){
		for(Integer i : merge){
			System.out.println(i);
		}
	}
}
