public class CollectionExamples {
	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.Integer> integers = new java.util.ArrayList<java.lang.Integer>();
		integers.add(5);
		int i;
		int[] a = new int[]{ 1, 2, 3, 4, 5 };
		java.util.List<java.lang.String> batsmen = new java.util.ArrayList<java.lang.String>();
		batsmen.add("Sachin");
		batsmen.add("Dravid");
		batsmen.add(0, "Ganguly");
		batsmen.add("Sachin");
		java.lang.System.out.println(batsmen.size());
		java.lang.System.out.println(batsmen.contains("Dravid"));
		java.util.Iterator<java.lang.String> arraylistIterator = batsmen.iterator();
		while (arraylistIterator.hasNext()) {
			java.lang.String str = arraylistIterator.next();
			java.lang.System.out.println(str);
		} 
		java.lang.System.out.println(batsmen.indexOf("Dravid"));
		java.lang.System.out.println(batsmen.indexOf("Bradman"));
		java.lang.System.out.println(batsmen.get(1));
		batsmen.remove("Dravid");
		batsmen.remove(1);
		java.util.List<java.lang.String> numbers = new java.util.ArrayList<java.lang.String>();
		numbers.add("one");
		numbers.add("two");
		numbers.add("three");
		numbers.add("four");
		java.lang.System.out.println(numbers);
		java.util.Collections.sort(numbers);
		java.lang.System.out.println(numbers);
		java.util.List<com.in28minutes.java.collections.examples.Cricketer> cricketers = new java.util.ArrayList<com.in28minutes.java.collections.examples.Cricketer>();
		cricketers.add(new com.in28minutes.java.collections.examples.Cricketer("Bradman", 9996));
		cricketers.add(new com.in28minutes.java.collections.examples.Cricketer("Sachin", 14000));
		cricketers.add(new com.in28minutes.java.collections.examples.Cricketer("Dravid", 12000));
		cricketers.add(new com.in28minutes.java.collections.examples.Cricketer("Ponting", 11000));
		java.lang.System.out.println(cricketers);
		java.util.Collections.sort(cricketers);
		java.lang.System.out.println(cricketers);
		java.util.Collections.sort(cricketers, new com.in28minutes.java.collections.examples.DescendingSorter());
		java.lang.System.out.println(cricketers);
		java.util.List<java.lang.String> numbers1 = new java.util.ArrayList<java.lang.String>();
		numbers1.add("one");
		numbers1.add("two");
		numbers1.add("three");
		numbers1.add("four");
		java.lang.String[] numbers1Array = new java.lang.String[numbers1.size()];
		numbers1Array = numbers1.toArray(numbers1Array);
		java.lang.System.out.println(java.util.Arrays.toString(numbers1Array));
		java.lang.Object[] numbers1ObjArray = numbers1.toArray();
		java.lang.System.out.println(java.util.Arrays.toString(numbers1ObjArray));
		java.lang.String[] values = new java.lang.String[]{ "value1", "value2", "value3" };
		java.util.List<java.lang.String> valuesList = java.util.Arrays.asList(values);
		java.lang.System.out.println(valuesList);
		java.util.Set<java.lang.String> hashset = new java.util.HashSet<java.lang.String>();
		hashset.add("Sachin");
		java.lang.System.out.println(hashset);
		hashset.add("Dravid");
		java.lang.System.out.println(hashset);
		hashset.add("Sachin");
		java.lang.System.out.println(hashset);
		java.util.Set<java.lang.String> treeSet = new java.util.TreeSet<java.lang.String>();
		treeSet.add("Sachin");
		java.lang.System.out.println(treeSet);
		treeSet.add("Dravid");
		java.lang.System.out.println(treeSet);
		treeSet.add("Ganguly");
		java.lang.System.out.println(treeSet);
		treeSet.add("Sachin");
		java.lang.System.out.println(treeSet);
		java.util.Map<java.lang.String, com.in28minutes.java.collections.examples.Cricketer> hashmap = new java.util.Hashtable<java.lang.String, com.in28minutes.java.collections.examples.Cricketer>();
		hashmap.put("sachin", new com.in28minutes.java.collections.examples.Cricketer("Sachin", 14000));
		hashmap.put("dravid", new com.in28minutes.java.collections.examples.Cricketer("Dravid", 12000));
		hashmap.put("ponting", new com.in28minutes.java.collections.examples.Cricketer("Ponting", 11500));
		hashmap.put("bradman", new com.in28minutes.java.collections.examples.Cricketer("Bradman", 9996));
		java.lang.System.out.println(hashmap.get("ponting"));
		java.lang.System.out.println(hashmap.get("lara"));
		hashmap.put("ponting", new com.in28minutes.java.collections.examples.Cricketer("Ponting", 11800));
		java.lang.System.out.println(hashmap.get("ponting"));
		java.util.Map<java.lang.String, com.in28minutes.java.collections.examples.Cricketer> treemap = new java.util.TreeMap<java.lang.String, com.in28minutes.java.collections.examples.Cricketer>();
		treemap.put("sachin", new com.in28minutes.java.collections.examples.Cricketer("Sachin", 14000));
		java.lang.System.out.println(treemap);
		treemap.put("dravid", new com.in28minutes.java.collections.examples.Cricketer("Dravid", 12000));
		java.lang.System.out.println(treemap);
		treemap.put("ponting", new com.in28minutes.java.collections.examples.Cricketer("Ponting", 11500));
		java.lang.System.out.println(treemap);
		treemap.put("bradman", new com.in28minutes.java.collections.examples.Cricketer("Bradman", 9996));
		java.lang.System.out.println(treemap);
		java.util.TreeSet<java.lang.Integer> numbersTreeSet = new java.util.TreeSet<java.lang.Integer>();
		numbersTreeSet.add(55);
		numbersTreeSet.add(25);
		numbersTreeSet.add(35);
		numbersTreeSet.add(5);
		numbersTreeSet.add(45);
		java.lang.System.out.println(numbersTreeSet.lower(25));
		java.lang.System.out.println(numbersTreeSet.floor(25));
		java.lang.System.out.println(numbersTreeSet.higher(25));
		java.lang.System.out.println(numbersTreeSet.ceiling(25));
		java.util.TreeMap<java.lang.Integer, com.in28minutes.java.collections.examples.Cricketer> numbersTreeMap = new java.util.TreeMap<java.lang.Integer, com.in28minutes.java.collections.examples.Cricketer>();
		numbersTreeMap.put(55, new com.in28minutes.java.collections.examples.Cricketer("Sachin", 14000));
		numbersTreeMap.put(25, new com.in28minutes.java.collections.examples.Cricketer("Dravid", 12000));
		numbersTreeMap.put(35, new com.in28minutes.java.collections.examples.Cricketer("Ponting", 12000));
		numbersTreeMap.put(5, new com.in28minutes.java.collections.examples.Cricketer("Bradman", 9996));
		numbersTreeMap.put(45, new com.in28minutes.java.collections.examples.Cricketer("Lara", 10000));
		java.lang.System.out.println(numbersTreeMap.lowerKey(25));
		java.lang.System.out.println(numbersTreeMap.floorKey(25));
		java.lang.System.out.println(numbersTreeMap.higherKey(25));
		java.lang.System.out.println(numbersTreeMap.ceilingKey(25));
		java.util.TreeSet<java.lang.Integer> treeSetOrig = new java.util.TreeSet<java.lang.Integer>();
		treeSetOrig.add(55);
		treeSetOrig.add(25);
		treeSetOrig.add(35);
		treeSetOrig.add(5);
		java.lang.System.out.println(treeSetOrig);
		java.util.TreeSet<java.lang.Integer> treeSetDesc = ((java.util.TreeSet<java.lang.Integer>) (treeSetOrig.descendingSet()));
		java.lang.System.out.println(treeSetDesc);
		java.lang.System.out.println(treeSetOrig);
		java.lang.System.out.println(treeSetOrig.pollFirst());
		java.lang.System.out.println(treeSetOrig);
		java.lang.System.out.println(treeSetOrig);
		java.lang.System.out.println(treeSetOrig.pollLast());
		java.lang.System.out.println(treeSetOrig);
		java.util.TreeMap<java.lang.Integer, com.in28minutes.java.collections.examples.Cricketer> treeMapOrig = new java.util.TreeMap<java.lang.Integer, com.in28minutes.java.collections.examples.Cricketer>();
		treeMapOrig.put(55, new com.in28minutes.java.collections.examples.Cricketer("Sachin", 14000));
		treeMapOrig.put(25, new com.in28minutes.java.collections.examples.Cricketer("Dravid", 12000));
		treeMapOrig.put(5, new com.in28minutes.java.collections.examples.Cricketer("Bradman", 9996));
		treeMapOrig.put(45, new com.in28minutes.java.collections.examples.Cricketer("Lara", 10000));
		java.lang.System.out.println(treeMapOrig);
		java.util.NavigableMap<java.lang.Integer, com.in28minutes.java.collections.examples.Cricketer> treeMapDesc = treeMapOrig.descendingMap();
		java.lang.System.out.println(treeMapDesc);
		java.lang.System.out.println(treeMapOrig);
		java.lang.System.out.println(treeMapOrig.pollFirstEntry());
		java.lang.System.out.println(treeMapOrig);
		java.lang.System.out.println(treeMapOrig);
		java.lang.System.out.println(treeMapOrig.pollLastEntry());
		java.lang.System.out.println(treeMapOrig);
		java.util.TreeSet<java.lang.Integer> exampleTreeSet = new java.util.TreeSet<java.lang.Integer>();
		exampleTreeSet.add(55);
		exampleTreeSet.add(25);
		exampleTreeSet.add(105);
		exampleTreeSet.add(35);
		exampleTreeSet.add(5);
		java.lang.System.out.println(exampleTreeSet);
		java.util.SortedSet<java.lang.Integer> subTreeSet = exampleTreeSet.subSet(25, 55);
		java.lang.System.out.println(subTreeSet);
		java.util.SortedSet<java.lang.Integer> headTreeSet = exampleTreeSet.headSet(55);
		java.lang.System.out.println(headTreeSet);
		java.util.SortedSet<java.lang.Integer> tailTreeSet = exampleTreeSet.tailSet(35);
		java.lang.System.out.println(tailTreeSet);
		java.util.SortedSet<java.lang.Integer> subTreeSetIncl = exampleTreeSet.subSet(25, true, 55, true);
		java.lang.System.out.println(subTreeSetIncl);
		java.util.SortedSet<java.lang.Integer> subTreeSetNotIncl = exampleTreeSet.subSet(25, false, 55, false);
		java.lang.System.out.println(subTreeSetNotIncl);
		java.util.SortedSet<java.lang.Integer> headTreeSetIncl = exampleTreeSet.headSet(55, true);
		java.lang.System.out.println(headTreeSetIncl);
		java.util.SortedSet<java.lang.Integer> tailTreeSetNotIncl = exampleTreeSet.tailSet(35, false);
		java.lang.System.out.println(tailTreeSetNotIncl);
		java.lang.System.out.println(exampleTreeSet);
		java.lang.System.out.println(subTreeSet);
		java.lang.System.out.println(headTreeSet);
		java.lang.System.out.println(tailTreeSet);
		exampleTreeSet.add(30);
		java.lang.System.out.println(exampleTreeSet);
		java.lang.System.out.println(subTreeSet);
		java.lang.System.out.println(headTreeSet);
		java.lang.System.out.println(tailTreeSet);
		exampleTreeSet.add(65);
		java.lang.System.out.println(exampleTreeSet);
		java.lang.System.out.println(subTreeSet);
		java.lang.System.out.println(headTreeSet);
		java.lang.System.out.println(tailTreeSet);
		java.util.TreeMap<java.lang.Integer, com.in28minutes.java.collections.examples.Cricketer> exampleTreeMap = new java.util.TreeMap<java.lang.Integer, com.in28minutes.java.collections.examples.Cricketer>();
		exampleTreeMap.put(55, new com.in28minutes.java.collections.examples.Cricketer("Sachin", 14000));
		exampleTreeMap.put(25, new com.in28minutes.java.collections.examples.Cricketer("Dravid", 12000));
		exampleTreeMap.put(5, new com.in28minutes.java.collections.examples.Cricketer("Bradman", 9996));
		exampleTreeMap.put(45, new com.in28minutes.java.collections.examples.Cricketer("Lara", 10000));
		java.lang.System.out.println(exampleTreeMap.subMap(5, 25));
		java.lang.System.out.println(exampleTreeMap.headMap(30));
		java.lang.System.out.println(exampleTreeMap.tailMap(25));
		java.util.PriorityQueue<java.lang.Integer> priorityQueue = new java.util.PriorityQueue<java.lang.Integer>();
		priorityQueue.offer(24);
		priorityQueue.offer(15);
		priorityQueue.offer(9);
		priorityQueue.offer(45);
		java.lang.System.out.println(priorityQueue);
		java.lang.System.out.println(priorityQueue.peek());
		java.lang.System.out.println(priorityQueue);
		java.lang.System.out.println(priorityQueue.poll());
		java.lang.System.out.println(priorityQueue);
		java.util.Comparator reverseComparator = new java.util.Comparator<java.lang.Integer>() {
			public int compare(java.lang.Integer paramT1, java.lang.Integer paramT2) {
				return paramT2 - paramT1;
			}
		};
		java.util.PriorityQueue<java.lang.Integer> priorityQueueDesc = new java.util.PriorityQueue<java.lang.Integer>(20, reverseComparator);
		priorityQueueDesc.offer(24);
		priorityQueueDesc.offer(15);
		priorityQueueDesc.offer(9);
		priorityQueueDesc.offer(45);
		java.lang.System.out.println(priorityQueueDesc.peek());
	}
}