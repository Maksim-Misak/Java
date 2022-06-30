import java.util.Arrays;

public class task6 {
    public static int[] sortArray(int[] array) {
        if (array == null) {
            return null;
        }
        int length_arr = array.length / 2;

        if (array.length < 2) {
            return array;
        }
        if (array.length % 2 != 0) {
            length_arr += 1;
        }
        int[] arrayR = new int[length_arr];
        int[] arrayL = new int[array.length / 2];

        for (int i = 0; i < array.length / 2; i++) {
            arrayL[i] = array[i];
        }

        for (int i = array.length / 2; i < array.length; i++) {
            arrayR[i - array.length / 2] = array[i];
        }
        arrayL = sortArray(arrayL);
        arrayR = sortArray(arrayR);

        return mergeArray(arrayL, arrayR);
    }

    public static int[] mergeArray(int[] arrayL, int[] arrayR) {

        int[] arrayC = new int[arrayL.length + arrayR.length];
        int posL = 0, posR = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (posL < arrayL.length && posR < arrayR.length) {
                if (arrayL[posL] < arrayR[posR]) {
                    arrayC[i] = arrayL[posL];
                    posL++;
                } else {
                    arrayC[i] = arrayR[posR];
                    posR++;
                }
            } else if (posL == arrayL.length && posR < arrayR.length) {
                arrayC[i] = arrayR[posR];
                posR++;
            } else if (posL < arrayL.length && posR == arrayR.length) {
                arrayC[i] = arrayL[posL];
                posL++;
            } else {
                arrayC[i] = 0;
            }
        }
        return arrayC;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[] { 1, 89, 6, 4, 8, 4, 9, 27, 45 })));
    }
}
