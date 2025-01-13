import sorts.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
//        int[] arrayNums = new int[] { -3, 9, 3, 1, 0, 99 };
//        int[] arrayNums = new int[] { 7, 2, 1, 6, 8, 5, 3, 4 };
        int[] arrayNums = new int[] { 20, 9, 86, -2, 16, 13, 34, 4 };
        List<Integer> arrayListNums = Arrays.asList(7, 2, 1, 6, 8, 5, 3, 4);
//        int[] arrayNums = new int[] { 2, 1 };
        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.sort(arrayNums);
        SelectionSort selectionSort = new SelectionSort();
//        selectionSort.sort(arrayNums);
        InsertionSort insertionSort = new InsertionSort();
//        insertionSort.sort(arrayNums);
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arrayNums);
        QuickSort quickSort = new QuickSort();
//        quickSort.sort(arrayNums, 0, arrayNums.length - 1);
        QuickSort2 quickSort2 = new QuickSort2();
        Utils.showElements(quickSort2.getSorted(arrayListNums));
//        Utils.showElements(arrayNums);
    }
}
