//ddone
/*
 *Equal Average Partition
Asked in:  
Amazon
Given an array with non negative numbers, divide the array into two parts such that the average of both the parts is equal.
Return both parts (If exist).
If there is no solution. return an empty list.

Example:


Input:
[1 7 15 29 11 9]

Output:
[9 15] [1 7 11 29]

The average of part is (15+9)/2 = 12,
average of second part elements is (1 + 7 + 11 + 29) / 4 = 12

 NOTE 1: If a solution exists, you should return a list of exactly 2 lists of integers A and B which follow the following condition :
numElements in A <= numElements in B
If numElements in A = numElements in B, then A is lexicographically smaller than B ( https://en.wikipedia.org/wiki/Lexicographical_order )
NOTE 2: If multiple solutions exist, return the solution where length(A) is minimum. If there is still a tie, return the one where A is lexicographically smallest. NOTE 3: Array will contain only non negative numbers 
 */

package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Equal_Average_Partition {

	public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> array) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		Set<Integer> aIndex = new HashSet<>();

		int N = array.size();

		int totalSum = 0;
		for (int i = 0; i < N; i++)
			totalSum += array.get(i);

		Collections.sort(array);

		for (int aSize = 1; aSize < N; aSize++) {
			float aSum = (float) totalSum * aSize / N;
			if (aSum != (int) aSum)
				continue;

			for (int i = 0; i < N; i++) {
				if (find(i, aSize, aSum, array, aIndex)) {
					buildResult(result, array, aIndex, aIndex.size(), N - aIndex.size());
					return result;
				}
			}
		}
		return result;
	}

	private boolean find(int index, int aSize, float aSum, ArrayList<Integer> array, Set<Integer> a) {
		if (index >= array.size() || aSize == 0)
			return false;

		int value = array.get(index);
		if (aSize == 1 && value == aSum) {
			a.add(index);
			return true;
		}

		if (find(index + 1, aSize - 1, aSum - value, array, a)) {
			a.add(index);
			return true;
		} else if (find(index + 1, aSize, aSum, array, a))
			return true;

		return false;
	}

	private void buildResult(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> array, Set<Integer> aIndex,
			int aSize, int bSize) {
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			if (aIndex.contains(i)) {
				if (aSize <= bSize)
					a.add(array.get(i));
				else
					b.add(array.get(i));
			} else {
				if (aSize <= bSize)
					b.add(array.get(i));
				else
					a.add(array.get(i));
			}
		}
		result.add(a);
		result.add(b);
	}
}
