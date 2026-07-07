public class a_MaxScoreByCard {
    public static void main(String[] args) {
        int arr[] = { 11, 49, 100, 20, 86, 29, 72 };
        System.out.println(maxScoreByCard(arr, 4));
        ;
    }

    public static int maxScoreByCard(int[] arr, int k) {
        int score = 0;
        int leftScore = 0;
        int rightScore = 0;
       
        for (int i = 0; i < k; i++) {
            leftScore += arr[i];

        }
        score = leftScore;
        int rightIndex = arr.length - 1;
        for (int i = k-1; i >= 0; i--) {
            leftScore -= arr[i];
            rightScore += arr[rightIndex];
            rightIndex--;
            score = Math.max(score, leftScore + rightScore);
        }
        // System.out.println(leftScore);
        return score;
    }
}
