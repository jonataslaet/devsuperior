import searchs.BinarySearch;
import sorts.BubbleSort;
import sorts.InsertionSort;
import sorts.SelectionSort;

public class Searching {

    public static void main(String[] args) {
        int[] nums = new int[] { -3, 0, 1, 3, 9, 99 };
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.searchIteractively(nums, 99));
        System.out.println(binarySearch.searchRecursively(nums, 0, nums.length - 1, 99));
    }
}
