package zDailyQuiz;



class DQ4_MinOperationsToReduceXToZero {

    public static  int minOperations(int[] nums, int x) {

        int sumOfArr = 0;
        int maxLen = Integer.MIN_VALUE;
        int len = nums.length;

        
        for (int i : nums) {
            sumOfArr += i;
        }

      
        int neededSum = sumOfArr - x;

        int i = 0;
        int j = 0;
        int currSum = 0;

        while (j < len) {

            currSum += nums[j];

           
            while (currSum > neededSum && i <= j) {
                currSum -= nums[i];
                i++;
            }

            
            if (currSum == neededSum) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++;
        }

        
        if (maxLen == Integer.MIN_VALUE) {
            return -1;
        }

       
        return len - maxLen;
    }

    public static void main(String[] args) {

     

        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;

        System.out.println(minOperations(nums, x));
    }
}