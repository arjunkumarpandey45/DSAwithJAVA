public class m_ShipWithinDays {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        System.out.println(shipWithinDays(arr, days));
    }

    public static int shipWithinDays(int arr[], int days) {
        int low = 0;
        int high = 0;
        int perDayLoad=0;
        for (int num : arr) {
            low = Math.max(low, num);
        }
        for (int i : arr) {
            high += i;
        }
        while (low<=high) {
               int mid = low + (high - low) / 2;
               int currentDay=requiredDay(arr, mid);
               if (currentDay>days) {
                low=mid+1;
               } else{
                perDayLoad=mid;
                high=mid-1;
               }           
        }
        return perDayLoad;
    }
    public static int requiredDay(int arr[],int mid){
        int day=1; int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if (sum+arr[i]>mid) {
                day++;
                sum=arr[i];
            }else{
                sum+=arr[i];
            }
        }
        return day;
    }

}
