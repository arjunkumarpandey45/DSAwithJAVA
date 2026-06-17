
import java.util.HashMap;

class Frequency01 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 1, 4, 2 };
        freq(arr);
    }

    public static void freq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
         map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            
        }
        for (HashMap.Entry<Integer,Integer> i :map.entrySet()) {
            System.out.println("The Frequency of "+ i.getKey()+" is "+i.getValue());
        }
    }
}
