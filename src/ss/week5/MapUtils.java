package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapUtils{
	/* @ ensures (\forall V a, b; map.contains(a) && map.contains(b) && a != b) == \result;
	 * @ requires map != null;
	 * @
	 */
	public static <K, V> boolean isOneOnOne(Map<K, V> map){
		if(map.values().size() != map.keySet().size()) return false;
		
		HashSet<V> remainingValues = new HashSet<V>(map.values());
		
		for(K key : map.keySet()){
			V testValue = map.get(key);
			
			if(remainingValues.contains(testValue)) remainingValues.remove(testValue);
			else return false;
		}
		
		return remainingValues.isEmpty();
	}
	
	public static <K, C, V> boolean compatible(Map<K, C> first, Map<C, V> second){
		if(!isOneOnOne(first)) return false;
		
		for(C value : first.values()){
			if(!second.containsKey(value)) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("A", "1");
		map2.put("B", "2");
		map2.put("C", "3");
		
		System.out.println(compatible(map, map2));
	}
}
