package ninja;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class Get_Mode_Array_Updates {
	
	class Node{
		int key;
		int freq;
		Node(int key,int freq){
			this.key=key;
			this.freq=freq;
		}

		@Override
		public boolean equals(Object obj) {
			Node other = (Node) obj;
			return this.key==other.key && this.freq==other.freq; 
		}
	}
	
	public int[] getMode(int[] A, int[][] B) {
		int n=A.length;
		HashMap<Integer, Integer > count= new HashMap<>();
		PriorityQueue<Node> pq=new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node a, Node b) {
				if(a.freq!=b.freq) {
					return b.freq-a.freq;
					
				}
				return a.key-b.key;
			}
		});
		for(int i:A) 
			count.put(i,count.getOrDefault(i, 0)+1);
		for(int key:count.keySet()) {
			int fre=count.get(key);
			pq.add(new Node(key, fre));		
		}
		/*
		 * for(Node i:pq) { System.out.println(i.key+","+i.freq); }
		 * System.out.println("Get_Mode_Array_Updates.getMode()");
		 */
		int ans[]=new int[B.length];
		int k=0;
		for(int query[]:B) {
			int pos=query[0]-1;
			int newVal=query[1];
			int oldVal=A[pos];
			int oldValFre=count.getOrDefault(oldVal, 0);
			int newValFre=count.getOrDefault(newVal, 0);
			Node toRemove=new Node(oldVal,oldValFre);
			pq.remove(toRemove); 
			oldValFre--;
			if(oldValFre==0) {
				count.remove(oldVal);
			}else {
				count.put(oldVal,oldValFre);
				pq.add(new Node(oldVal, oldValFre));
			}
			if(newValFre!=0) {
				
				pq.remove(new Node(newVal,newValFre));
			}
			pq.add(new Node(newVal, newValFre+1));
			count.put(newVal, newValFre+1);
			A[pos]=newVal;
			ans[k++]=pq.peek().key;
			/*
			 * for(Node i:pq) { System.out.println(i.key+","+i.freq); }
			 * System.out.println("Get_Mode_Array_Updates.getMode()");
			 */
	
		}
		return ans;	
		/*
		 * for(int i:ans) { System.out.println(i); }
		 */
    }
	
	public static void main(String[] args) {
		int arr[]=new Get_Mode_Array_Updates().getMode(new int [] { 2, 2, 2, 3, 3}, new int[][] {{1,3},{5,4},{2,4}});
		for(int i:arr)
			System.out.println(i);
	}
}
