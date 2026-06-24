

public class j_Occurrence {
    public static void main(String[] args){
        int [] arr={1,2,3,4,4,6};

        System.out.println(  recOccurrence(46,0,arr,0));;

    }
    public static int recOccurrence(int n , int occ, int [] arr, int ind){
        if(ind>arr.length-1){
            return occ;
        }
        if(arr[ind]==n){
            occ++;
        };

        return recOccurrence(n,occ,arr,ind+1);
    }
}
