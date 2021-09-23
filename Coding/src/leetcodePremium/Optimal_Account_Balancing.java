/* over, v+e, v
 * A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.
Note: 
A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.

Example 1: 
Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.

Example 2: 
Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.
 */

package leetcodePremium;

public class Optimal_Account_Balancing {
	
	/*
	 * 
	 * With all the given transactions, in the end, each person with ID = id will have an overall balance bal[id]. Note that the id value or any person coincidentally with 0 balance is irrelevant to debt settling count, so we can simply use an array debt[] to store all non-zero balances, where

debt[i] > 0 means a person needs to pay $ debt[i] to other person(s);
debt[i] < 0 means a person needs to collect $ debt[i] back from other person(s).
Starting from first debt debt[0], we look for all other debts debt[i] (i>0) which have opposite sign to debt[0]. Then each such debt[i] can make one transaction debt[i] += debt[0] to clear the person with debt debt[0]. From now on, the person with debt debt[0] is dropped out of the problem and we recursively drop persons one by one until everyone's debt is cleared meanwhile updating the minimum number of transactions during DFS.

Note: Thanks to @KircheisHe who found the following great paper about the debt settling problem:

Settling Multiple Debts Efficiently: An Invitation to Computing Science by T. Verhoeff, June 2003.
The question can be transferred to a 3-partition problem, which is NP-Complete.

public:
	 * 
	 */

	 public int minTransfers(int[][] transactions) {
	        Map<Integer, Long> map = new HashMap<>();

	        // Step 1: Preprocessing the transactions, and ingore people with zero debt
	        for (int[] transaction : transactions) {
	            int person1 = transaction[0];
	            int person2 = transaction[1];
	            int curDebt = transaction[2];

	            long debt1 = map.getOrDefault(person1, 0L);
	            long debt2 = map.getOrDefault(person2, 0L);

	            map.put(person1, debt1 - curDebt);
	            map.put(person2, debt2 + curDebt);
	        }

	        List<Long> debts = new ArrayList<>();

	        for (long debt : map.values()) {
	            if (debt != 0) {
	                debts.add(debt);
	            }
	        }

	        // Step 2： Enumerate all possible combinations to settle the debt
	        int[] res = {Integer.MAX_VALUE};
	        getMinimumTransaction(0, 0, debts, res);
	        return res[0];
	    }

	    public void getMinimumTransaction(int index, int count, List<Long> debts, int[] res) {
	        // Skip settled debt
	        while (index < debts.size() && debts.get(index) == 0) ++index;

	        if (index == debts.size()) {
	            res[0] = Math.min(res[0], count);
	            return;
	        }

	        for (int i = index + 1; i < debts.size(); i++) {
	            // Only settle debt when the debts[i] has different sign with debts[index]
	            if (debts.get(i) * debts.get(index) < 0) {
	                debts.set(i, debts.get(i) + debts.get(index));
	                getMinimumTransaction(index + 1, count + 1, debts, res);
	                debts.set(i, debts.get(i) - debts.get(index));
	            }
	        }
	    }
	
}
