/**
 * Created by Administrator on 2016/11/5.
 */

import com.company.ArrayManager;

public class Main {


    public static void main(String[] args) {
        ArrayManager arrayManager = ArrayManager.getInstance();
        Integer[] array = arrayManager.getArray(1000000);
        //arrayManager.arrayPrint(array);
        //shell(array);
        com.company.Main.quickSort(array, 0, array.length, 0);
    }

    public static void shell(Integer[] array) {
        int[] a = ArrayManager.getInstance().getShellIncrementArrayByName("Sedgewick", array.length);
        //ArrayManager.getInstance().arrayPrint(a);
        int j_tmp, current_in_array;
        long count = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println("current increment : " + a[i]);
            for (int j = 1; j <= ((array.length - 1) / a[i]); j++) {
                j_tmp = j;
                //System.out.println(j * a[i]);
                current_in_array = array[j * a[i]];
                while ((j_tmp - 1) >= 0 && array[(j_tmp - 1) * a[i]] > current_in_array) {
                    array[j_tmp * a[i]] = array[(j_tmp - 1) * a[i]];
                    --j_tmp;
                    count++;
                }
                array[j_tmp * a[i]] = current_in_array;
                count++;
            }
        }

        //ArrayManager.getInstance().arrayPrint(array);
        System.out.println("  Shell Count is: " + count);
    }
}
