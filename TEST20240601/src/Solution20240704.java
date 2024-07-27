//Solution20240704--leedcode--88. Merge Sorted Array

import java.util.Arrays;

public class Solution20240704 {
    public static void main(String[] args) throws Exception {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge_TC(nums1, m, nums2, n);
        System.out.println(java.util.Arrays.toString(nums1)); // 輸出 [1, 2, 2, 3, 5, 6]

        nums1 = new int[]{1};
        nums2 = new int[]{};
        m = 1;
        n = 0;
        merge_TC(nums1, m, nums2, n);
        System.out.println(java.util.Arrays.toString(nums1)); // 輸出 [1]

        nums1 = new int[]{0};
        nums2 = new int[]{1};
        m = 0;
        n = 1;
        merge_TC(nums1, m, nums2, n);
        System.out.println(java.util.Arrays.toString(nums1)); // 輸出 [1]
    }
    //chatgpt
    public static void merge_chatgpt(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1; // 指向 nums1 中最後一個有效元素
        int p2 = n - 1; // 指向 nums2 中最後一個元素
        int p = m + n - 1; // 指向 nums1 中最後一個位置

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // 如果 nums2 還有剩餘元素，將它們放入 nums1 中
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
        
    }
    //TC WORK
    public static void merge_TC(int[] nums1, int m, int[] nums2, int n) {
    //nums2前n個從nums1第m之後接著排序
    for(int i=0 ;i<n ;i++){
        nums1[m+i] = nums2[i];
    }
    //從小排到大
    Arrays.sort(nums1);
    }

}
