public class ArrayOps {
    public static void main(String[] args) {
        //int [] str1 = {1,2,2,2,2};
        //int [] str2 = {2,1};
        System.out.println(secondMaxValue(new int [] {2,8,3,7,8})); 
        //System.out.println(containsTheSameElements(str1,str2));
        //System.out.println(findMissingInt(str1));
        // System.out.println(containsTheSameElements(new int [] {3,-4,1,2,5}, new int [] {1,3,-4,5}));
        // System.out.println(isSorted(new int [] {1,3,2}));
    }
    
    public static int findMissingInt (int [] array) {
      for (int i = 0; i <= array.length; i++){
        if (!contains(array, i)){
            return i;
        }
      }
      return 0;
    }

    public static boolean contains (int [] array, int value){
        for (int i = 0; i < array.length; i++){
            if (value == array[i]){
                return true;
            }
        }
        return false;
    }
    

    public static int secondMaxValue(int [] array) {
        int max = array [0];
        for (int i = 1; i < array.length; i++){ //finding the max value 
            if (max < array[i]){
                max = array[i];
            }  
        }
        if (countTimes(array, max)>1){
            return max;
        }
        int secondMax = array [0]; //checking if the first element is the max 
        if ( secondMax != max){
            secondMax = array [0]; 
        }
        else secondMax = array [1];
        for (int j = 1; j < array.length; j++){ // finding the second max 
            if (secondMax<array[j] && array[j]<max){
                secondMax= array[j];
            }
        }
        return secondMax;
    }

    public static int countTimes(int [] array, int value){
        int count = 0; 
        for (int i = 0; i <array.length; i++){
            if (array[i]==value){
                count++;
            }
        }
        return count;
    }
    public static boolean containsTheSameElements(int [] array1 , int [] array2) {
        for (int i = 0; i < array1.length; i++){
            //compers the first array to the second
            if (!contains(array2, array1[i])){
                return false;
        }
    }
        for (int j = 0; j < array2.length; j++){
            //compers the second array to the first
            if (!contains(array1, array2[j])){
                return false;
        }
    }
        return true;
}

    public static boolean isSorted(int [] array) {
        if (array[0]>array[array.length-1]){
            for (int i = 0; i < array.length-1; i++){
                if (array[i]<array[i+1]){
                    return false;
                }
            }

        }
        if (array[0]<array[array.length-1]){
            for (int i = 0; i < array.length-1; i++){
                if (array[i]>array[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
}