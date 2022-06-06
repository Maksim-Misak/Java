
import java.util.ArrayList;

// 5.	Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
// Требуется восстановить выражение до верного равенства. 
// Предложить хотя бы одно решение или сообщить, что его нет.

public class task5 {
    public static void main(String[] args) {
        ArrayList<Integer> signIndexes = new ArrayList<>();
        String text = "?7 + ?2 = 69";
        char[] textChar = text.replace(" ", "").toCharArray();

        for (int i = 0; i < textChar.length; i++) {
            if (textChar[i] == '+' || textChar[i] == '=') {
                textChar[i] = '-';
            }
            if (textChar[i] == '?') {
                signIndexes.add(i);
            }
        }
        int[] nums = new int[2];
        String[] numbers = String.valueOf(textChar).split("-");
        String a = numbers[0];
        String b = numbers[1];
        String c = numbers[2];

        combWithRep(nums, 0, 9, a, b, c);
    }

    public static void combWithRep(int[] comb, int index, int K, String a, String b, String c) {
        if (index == comb.length) {
            int firstNum = Integer.parseInt(a.replace("?", Integer.toString(comb[0])));
            int secondNum = Integer.parseInt(b.replace("?", Integer.toString(comb[1])));
            int resNum = Integer.parseInt(c);
            String res = "";
            if (firstNum + secondNum == resNum) {
                res = Integer.toString(firstNum).concat(" + ").concat(Integer.toString(secondNum)).concat(" = ").concat(Integer.toString(resNum));
                System.out.println(res);
            }
            return;
        }
        for (int i = 0; i <= K; i++) {
            comb[index] = i;
            combWithRep(comb, index + 1, K, a, b, c);
        }
    }

}
