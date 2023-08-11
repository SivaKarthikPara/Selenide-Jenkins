import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class PracO {

    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"Siva", "120000", "2"},
                {"Siva", "100000", "3"},
                {"Abhi", "200000", "5"},
                {"Abhi", "190000", "2"},
                {"Pavan", "300000", "3"},
        };
        String[] array1d = new String[]{
                "Siva",
                "Karthik",
                "Para"
        };
//        Arrays.dee(array);
        int columnToSort = 1;
        int secondColumnToSort = 2;

        sortUsinglamba(array, columnToSort, secondColumnToSort);
//        Arrays.sort(array1d);
//        System.out.println(Arrays.asList(array1d));
        display2dArray(array);
    }

    //Using Comparator
    private static void sort2dString(String[][] array, int... columnNumbers) {
        if (columnNumbers.length > 0) {
            for (final int column : columnNumbers) {
                Arrays.sort(array, new Comparator<String[]>() {
                    public int compare(String[] value1, String[] value2) {
                        if (value1[column - 1].compareTo(value2[column - 1]) > 0) {
                            return 1;
                        } else if ((value1[column - 1].compareTo(value2[column - 1]) < 0)) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
                display2dArray(array);
                System.out.println("----------------");
            }
        }
    }

    //Using lambda
    private static void sortUsinglamba(String[][] array, int... columnNumbers) {
        if (columnNumbers.length > 0) {
            int prevCol = columnNumbers[0];
            for (int column : columnNumbers) {
                if (prevCol == column)
                    Arrays.sort(array, (arr1, arr2) -> arr1[column - 1].compareTo(arr2[column - 1]));
                else {
                    int finalPrevCol = prevCol;
                    Arrays.sort(array, (arr1, arr2) -> arr1[finalPrevCol - 1].compareTo(arr2[finalPrevCol - 1]) != 0 ?
                            arr1[finalPrevCol - 1].compareTo(arr2[finalPrevCol - 1]) :
                            arr1[column - 1].compareTo(arr2[column - 1]));
                }
                prevCol = column;
//                Arrays.sort(array, Comparator.comparing(arr -> arr[column - 1]));

            }
        }
    }

    private static void display2dArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
