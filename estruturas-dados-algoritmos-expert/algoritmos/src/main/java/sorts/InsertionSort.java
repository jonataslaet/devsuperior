package sorts;

public class InsertionSort {
    public void sort(int[] nums) {
        int t = nums.length;
        for (int k = 1; k < t; k++) {
            int num = nums[k];
            int p = k - 1;
            while (p >= 0 && nums[p] > num) {
                nums[p + 1] = nums[p];
                p--;
            }
            nums[p + 1] = num;
        }
    }
}
