package sorts;

public class BubbleSort {

    public void sort(int[] nums) {
        int t = nums.length;
        for (int i = 0; i < t - 1; i++) {
            for (int j = i+1; j < t; j++) {
                if (nums[i] > nums[j]) {
                    int aux = nums[i];
                    nums[i] = nums[j];
                    nums[j] = aux;
                }
            }
        }
    }
}
