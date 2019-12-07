//doe


/*
 * 
 * 
 * Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Insert_Delete_GetRandom_O1 {
	
	Random random;
	Map<Integer, Integer> map;
	List<Integer> list;
	public Insert_Delete_GetRandom_O1()  {
		random = new Random();
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) return false;
		list.add(val);
		return map.put(val, list.size()-1) == null;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) return false;
		Integer position = map.get(val);
		Collections.swap(list, position, list.size() - 1);
		map.put(list.get(position),position);
		list.remove(list.size()-1);
		return map.remove(val) != null;
	}

	public int getRandom() {
		int i = random.nextInt(list.size());
		return list.get(i);
	}

}
