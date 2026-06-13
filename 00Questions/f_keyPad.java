import java.util.*;
public class f_keyPad {



        public static void getC(String digits,
                                List<String> ds,
                                int idx,
                                String ans,
                                String[] map) {

            // base case
            if (idx == digits.length()) {
                ds.add(ans);
                return;
            }

            int num = digits.charAt(idx) - '0';

            String value = map[num];

            for (int i = 0; i < value.length(); i++) {

                char ch = value.charAt(i);

                getC(
                        digits,
                        ds,
                        idx + 1,
                        ans + ch,
                        map
                );
            }
        }

        public static List<String> letterCombinations(
                String digits) {

            List<String> ds =
                    new ArrayList<>();

            if (digits.length() == 0) {
                return ds;
            }

            String[] map = {
                    "", "",
                    "abc",
                    "def",
                    "ghi",
                    "jkl",
                    "mno",
                    "pqrs",
                    "tuv",
                    "wxyz"
            };

            getC(
                    digits,
                    ds,
                    0,
                    "",
                    map
            );

            return ds;
        }

        public static void main(String[] args) {

            Scanner sc =
                    new Scanner(System.in);

            System.out.print(
                    "Enter digits: ");

            String digits =
                    sc.nextLine();

            List<String> result =
                    letterCombinations(digits);

            System.out.println(result);

            sc.close();
        }
    }