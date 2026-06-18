
import java.util.ArrayList;
import java.util.Arrays;

public class c_UnionAndIniterSection {
    public static void main(String[] args) {
        int[] arr1 = {  5};
        int[] arr2 = {1,1,1,1,1, 2,3, 4,6, 8,5 };
        ArrayList<Integer> lis = new ArrayList<>();
        // union(arr1, arr2, lis);
        intersection(arr1, arr2, lis);
        for (int i : lis) {
            System.out.println(i);
        }
    }

    public static void union(int[] nums1, int[] nums2, ArrayList<Integer> unionAns) {
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {

            if (i > 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }

            if (j > 0 && nums2[j] == nums2[j - 1]) {
                j++;
                continue;
            }

            if (nums1[i] < nums2[j]) {
                unionAns.add(nums1[i]);
                i++;
            } else if (nums1[i] > nums2[j]) {
                unionAns.add(nums2[j]);
                j++;
            } else {
                unionAns.add(nums1[i]);
                i++;
                j++;
            }
        }

        while (i < nums1.length) {
            if (i == 0 || nums1[i] != nums1[i - 1]) {
                unionAns.add(nums1[i]);
            }
            i++;
        }

        while (j < nums2.length) {
            if (j == 0 || nums2[j] != nums2[j - 1]) {
                unionAns.add(nums2[j]);
            }
            j++;
        }
    }

    public static void intersection(int[] nums1, int[] nums2, ArrayList<Integer> interSectionAns) {
        int i = 0;
        int j = 0;
        Arrays.sort(nums2);
           Arrays.sort(nums1);
        while (i < nums1.length && j < nums2.length) {
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }
            
            if (j > 0 && nums2[j] == nums2[j - 1]) {
                j++;
                continue;
            }
            if (nums1[i] == nums2[j]) {
                interSectionAns.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                 j++;
            }else{
                i++;
            }
           
        }
    }

}
