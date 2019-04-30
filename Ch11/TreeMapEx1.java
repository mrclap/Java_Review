import java.util.*;

import org.w3c.dom.Entity;

class TreeMapEx1{
	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		
		tm = stringIntegerTreeMapOrgernizer(data, tm);
		System.out.println("= 기본정렬 =");
		treeMapPrinter(tm);
		
		TreeMap<String, Integer> tm2 = new TreeMap<String, Integer>(new ValueDescComparator());
		
		Set<Map.Entry<String, Integer>> es = tm.entrySet();
//		System.out.println(es.getClass());
		List<Map.Entry> ls = new ArrayList<Map.Entry>(es);
		
		Collections.sort(ls, new ValueDescComparator());
		
		System.out.println("= 값기준정렬 =");
		collectionEntryPrinter(ls);
	}
	
	public static TreeMap<String, Integer> stringIntegerTreeMapOrgernizer(String[] data, TreeMap<String, Integer> tm){
		for (String each:data) {
			if (tm.containsKey(each)) {
				tm.put(each, tm.get(each) + 1);
			}else {
				tm.put(each, 1);
			}
		}
		return tm;
	}
	
	public static void treeMapPrinter(TreeMap<String, Integer> tm) {
		Iterator itr = tm.keySet().iterator();
		
		while(itr.hasNext()) {
			String keyVal = (String)itr.next();
			int counter = tm.get(keyVal);
			System.out.printf("%s : ", keyVal);
			for (int i=0;i<counter;i++) {
				System.out.printf("#");
			}
			System.out.println();
		}
	}
	
	public static void collectionEntryPrinter(Collection c) {
		Iterator itr = c.iterator();	
		
		while(itr.hasNext()) {
			Map.Entry<String, Integer> et = (Map.Entry<String, Integer>)itr.next();
			int counter = et.getValue().intValue();
			System.out.printf("%s : ", et.getKey());
			for (int i=0;i<counter;i++) {
				System.out.printf("#");
			}
			System.out.println();
		}
	}
	
	static class ValueDescComparator implements Comparator<Object>{
		public int compare(Object o1, Object o2) {
			if(o1 instanceof Map.Entry & o2 instanceof Map.Entry) {
				Map.Entry me1 = (Map.Entry)o1;
				Map.Entry me2 = (Map.Entry)o2;
				
				return ((int)me1.getValue() - (int)me2.getValue()) * -1;
			}
			return 1;
		}
	}
}
