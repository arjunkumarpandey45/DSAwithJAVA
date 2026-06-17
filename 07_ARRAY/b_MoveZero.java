public class b_MoveZero{
    public static void main(String[] args) {
        int [] nums={1,0,1,0,0,0,0,0,0,0,1};
        moveZero(nums);
        for (int i : nums) {
            System.out.println(i);
        }

    }
    public static void moveZero(int []nums){
int i=1;
int j=0;
while(i<=nums.length-1){
    if(nums[j]==0 &&nums[i]!=0){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        i++;
        j++;
    }else if(nums[j]!=0 &&nums[i]==0){
        j++;
    }else{
        i++;
    }
}
    }
}