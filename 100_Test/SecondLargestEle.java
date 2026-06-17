public class SecondLargestEle {
    public static void main(String[] args) {
        int[] arr = {11,10,10};
        SecondLargestElement(arr);
    }

    public static void SecondLargestElement(int[] arr) {
        int second =Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;
       

        for (int i = 0; i < arr.length ; i++) {
            
               int current = arr[i];
            
            if (current > largest) {

                second = largest;
                largest = current;
            }
           if (current < largest&& current>second) {
                second = current;
            }
            
            
        }
        if(second==Integer.MIN_VALUE){
            System.out.println("No SECOND largest element exists");
        }else{
 System.out.println(second);
        }
       
    }
}
