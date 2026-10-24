package zDailyQuiz;


import java.util.*;

public class DQ16_CountDaysTogether {

    public static int countDaysTogether(String arriveAlice, String leaveAlice,
                                        String arriveBob, String leaveBob) {

        int[] mm = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aliceStart = convertToDay(arriveAlice, mm);
        int aliceEnd = convertToDay(leaveAlice, mm);

        int bobStart = convertToDay(arriveBob, mm);
        int bobEnd = convertToDay(leaveBob, mm);

        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);

        return Math.max(0, end - start + 1);
    }

    public static int convertToDay(String date, int[] mm) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int totalDays = day;

        for (int i = 0; i < month - 1; i++) {
            totalDays += mm[i];
        }

        return totalDays;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String arriveAlice = sc.next();
        String leaveAlice = sc.next();
        String arriveBob = sc.next();
        String leaveBob = sc.next();

        int result = countDaysTogether(
            arriveAlice, leaveAlice, arriveBob, leaveBob
        );

        System.out.println(result);

        sc.close();
    }
}

