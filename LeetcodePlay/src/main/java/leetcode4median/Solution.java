package leetcode4median;

public class Solution {
    /**
     * Inspired by the solution https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn))-solution-with-explanation
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        // keep nums1 as the smaller array
        if (nums1.length > nums2.length) {
            // swap the nums1 and nums2
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        if (nums2.length ==0)
            throw new IllegalArgumentException("two empty arrays.");
        // init the variable
        int i,j, median;
        int m = nums1.length, n = nums2.length;
        int maxLeft = -1, minRight = -1;
        int mini = 0, maxi = m;
        while (mini <= maxi){
            i = (mini + maxi)/2;
            j = (m+n+1)/2-i;
            if (i > 0 && nums1[i-1] > nums2[j]) // If the i is too big
                maxi = i - 1;
            else if (i < m && nums1[i] < nums2[j-1]) // if the i is too small
                mini = i + 1;
            else {
                // if we found the perfect i
                if (i == 0)
                    maxLeft = nums2[j-1];
                else if (j ==0)
                    maxLeft = nums1[i-1];
                else maxLeft = Math.max(nums1[i-1], nums2[j-1]);

                if ((m+n)%2 == 1)
                    return maxLeft;
                if (i == m)
                    minRight = nums2[j];
                else if (j == n)
                    minRight = nums1[i];
                else minRight = Math.min(nums1[i], nums2[j]);

                return (maxLeft+minRight)/2.0;
            }
        }
        return -1;
    }


    public static void main(String args[]){
        int[] nums1 = {1, 2};
        int nums2[]  ={3,4};
        System.out.println(new Solution().findMedianSortedArrays(nums1,nums2));
    }
}
