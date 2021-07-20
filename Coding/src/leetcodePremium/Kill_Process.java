/*completedd
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.

Example 1:

Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
Note:
The given kill id is guaranteed to be one of the given PIDs.
n >= 1.
 */

package leetcodePremium;

public class Kill_Process {
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> ret = new ArrayList<Integer>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i=0; i<ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List<Integer> group = hm.getOrDefault(ppid.get(i), new ArrayList<Integer>());
                group.add(pid.get(i));
                hm.put(ppid.get(i), group); // note in python "setdefault" does this automatically
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (queue.size() != 0) {
            int node = queue.poll();
            ret.add(node);
            if (hm.containsKey(node)) {
                for (int child : hm.get(node)) {
                    queue.add(child);
                }
            }
        }
        
        return ret;
        
    }

}
