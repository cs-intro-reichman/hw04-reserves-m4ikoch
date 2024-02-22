
import java.util.*;

public class ArrayOps {
    public static void main(String[] args) {
        /* testing 
        int result = findMissingInt(array);
        System.out.println(result);
        int secondMaxValue = secondMaxValue(array);
        System.out.println(secondMaxValue);
        boolean same = containsTheSameElements(array1, array2);
        System.out.println(same);
        boolean sort = isSorted(array1);
        System.out.println(sort);
         */
    }

    public static int findMissingInt (int [] array) {
        int[] order;
        order = new int [array.length+1];
        Arrays.fill(order, -1);
        for (int i=0; i < array.length;i++)
        {
            int val = array[i];
            order[val] = 0;
        }
        int index = 0;
        while(order[index] == 0) {
            index = index + 1 ;
        } return index;
    }

    public static int secondMaxValue(int [] array) {
        int max1 = array[0];
        int max2 = array[1];
        if (max1 < max2) {
            int temp = max1;
            max1 = max2;
            max2 = temp;
        }
        if(array.length > 2) {
            for (int i=2; i < array.length; i++) {
                if(array[i] > max2 && array[i] < max1) {
                    max2 = array[i];
                }
            }
        } return max2;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean [] arr1 = new boolean[array1.length];
        boolean [] arr2 = new boolean[array2.length];
        boolean same = true;
        int index1 = 0;
        int index2 = 0;
        for (int p=0; p < array2.length; p++) {
            arr2[p] = false;
        }
        for (int i=0; i < array1.length; i++) {
            int countT = 0;
            for (int j=0; j < array2.length; j++) {
                if(array1[i]==array2[j]) {
                    if (countT == 0) {
                        arr1[i] = true;
                        arr2[j] = true;
                        countT = 1;
                    } else {
                        arr2[j] = true;
                    }
                }else {
                    if((countT == 0) && (arr2[j] = true)) {
                        arr1[i] = false;
                    }
                }
            }
        } for (int i=0; i < arr1.length; i++) {
            if(arr1[i]) {
                index1 = index1 + 1;
            }
        } if(index1 == arr1.length) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j]) {
                    index2++;
                }
            }
            same = index2 == arr2.length;
        } else {
            same = false;
        } return same;
    }
    public static boolean isSorted(int [] array) {
        boolean sort = true;
        int x = array[0];
        int count = 0;
        for (int i=1; i < array.length; i++) {
            if (x > array[i]) {
                count = count + 1;
                x = array[i];
            } else {
                if (count == 0) {
                    x = array[i];
                    count = count + 1;
                    for (int j = 2; j < array.length; j++) {
                        if (array[j] > x) {
                            x = array[j];
                            count = count + 1;
                        } else {
                            sort = false;
                            j = array.length;
                        }
                    }
                } else {
                    sort = false;
                } i = array.length;
            }
        } if(count == array.length - 1) {
            sort = true;
        } return sort;
    }
}
