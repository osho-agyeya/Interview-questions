//done
/*
 * Hotel Bookings Possible
Asked in:  
Goldman Sachs
Microsoft
A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

Input:


First list for arrival time of booking.
Second list for departure time of booking.
Third is K which denotes count of rooms.

Output:

A boolean which tells whether its possible to make a booking. 
Return 0/1 for C programs.
O -> No there are not enough rooms for N booking.
1 -> Yes there are enough rooms for N booking.
Example :

Input : 
        Arrivals :   [1 3 5]
        Departures : [2 6 8]
        K : 1

Return : False / 0 

At day = 5, there are 2 guests in the hotel. But I have only one room. 
 */

package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class Hotel_Bookings_Possible {
	
	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        

        if(arrive == null || depart == null) {
            return false;
        }
        
        Collections.sort(arrive);Collections.sort(depart);
        
        for(int i = 0 ; i < arrive.size() ; i++) {
            if(arrive.get(i) >= depart.get(0)) {
                depart.remove(0);
            }
        }
        
        return depart.size() <= K ? true : false;

        
        
      
    }

}
