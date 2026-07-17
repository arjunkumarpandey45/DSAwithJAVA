public class q_MedianOfSortedArray {
    public static void main(String[] args) {
    int a1[] = { 1 ,3};
        int a2[] = {8 };
        System.out.println(findMedianSortedArraysV2(a1, a2));
    }

    public static double findMedianSortedArraysV1(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int ind1 = n / 2;
        int ind2 = ind1 - 1;
        int count = 0;
        double ind1Ele = -1;
        double ind2Ele = -1;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (count == ind1)
                    ind1Ele = nums1[i];
                if (count == ind2)
                    ind2Ele = nums1[i];
                count++;
                i++;
            } else {
                if (count == ind1)
                    ind1Ele = nums2[j];
                if (count == ind2)
                    ind2Ele = nums2[j];
                count++;
                j++;
                ;
            }
        }

        while (i < n1) {
            if (count == ind1)
                ind1Ele = nums1[i];
            if (count == ind2)
                ind2Ele = nums1[i];
            count++;
            i++;

        }
        while (j < n2) {
            if (count == ind1)
                ind1Ele = nums2[j];
            if (count == ind2)
                ind2Ele = nums2[j];
            count++;
            j++;

        }
        System.out.println(ind1Ele + " " + ind2Ele);
        if (n % 2 == 1) {
            return ind1Ele;
        }
        return (ind1Ele + ind2Ele) / 2;
    }

    public static double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
         if (nums1.length > nums2.length)
    return findMedianSortedArraysV2(nums2, nums1);
         int n=nums1.length+nums2.length;
         int low=0;
          int high = nums1.length;
         while (low <= high) {
          int partitionX = low + (high - low) / 2;
            int partitionY = (n + 1) / 2 - partitionX;
            int l1 = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int r1 = partitionX == nums1.length ? Integer.MAX_VALUE : nums1[partitionX];
            int l2 = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int r2 = partitionY == nums2.length ? Integer.MAX_VALUE : nums2[partitionY];
            if (l1<=r2&&l2<=r1) {
                if (n%2==0) {
                    return (Math.max(l1, l2)+Math.min(r1, r2))/2.0;
                }else{
                    return Math.max(l1, l2);
                }
            }
            if (l1>r2) {
                high=partitionX-1;
            }else{
                low=partitionX+1;
            }
        }
        return 0;
    }

}
