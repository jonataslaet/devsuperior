package sorts;

public class SelectionSort {

    public void sort(int[] nums) {
        int t = nums.length;
        for (int i = 0; i < t - 1; i++) {
            int iMin = i;
            for (int j = i+1; j < t; j++) {
                if (nums[j] < nums[iMin]) {
                    iMin = j;
                }
            }
            if (iMin != i) {
                int aux = nums[i];
                nums[i] = nums[iMin];
                nums[iMin] = aux;
            }
        }
    }
}
