package com.mikey.math;

public class T4_Todo {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0,j=0;
        int tmp = 0;
        for (; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] <= nums2[j]) {
                tmp = nums1[i];
                i++;
            } else {
                tmp = nums1[j];
                j++;
            }
            if ((i+j)*2>= nums1.length + nums2.length) {
                break;
            }
        }
        return 0;
    }

}
