/* completed
 * On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000
Note:

stations.length will be an integer in range [10, 2000].
stations[i] will be an integer in range [0, 10^8].
K will be an integer in range [1, 10^6].
Answers within 10^-6 of the true value will be accepted as correct.
 */

package leetcodePremium;

public class Minimize_Max_Distance_to_Gas_Station {


public double minmaxGasDist(int[] stations, int K) {
        int n = stations.length;
        double[] gap = new double[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            gap[i] = stations[i + 1] - stations[i];
        }
        double lf = 0;
        double rt = Integer.MAX_VALUE;
        double eps = 1e-7;
        while (Math.abs(rt - lf) > eps) {
            double mid = (lf + rt) /2;
            if (check(gap, mid, K)) {
                rt = mid;
            }
            else {
                lf = mid;
            }
        }
        return lf;
    }
 
    boolean check(double[] gap, double mid, int K) {
        int count = 0;
        for (int i = 0; i < gap.length; ++i) {
            count += (int)(gap[i] / mid);
        }
        return count <= K;
    }
	
}
