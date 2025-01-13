package sorts;

public class MergeSort {
    public void sort(int[] nums) {
        int t = nums.length;
        if (t < 2) return;
        int m = t / 2;
        int[] left = new int[m];
        int[] right = new int[t-m];

        for (int i = 0; i < m; i++) {
            left[i] = nums[i];
        }

        for (int i = m; i < t; i++) {
            right[i - m] = nums[i];
        }

        sort(left);
        sort(right);
        merge(left, right, nums);
    }

    private void merge(int[] left, int[] right, int[] nums) {
        int tl = 0, sl = left.length;
        int tr = 0, sr = right.length;
        int k = 0;
        while (tl < sl && tr < sr) {
            if (left[tl] <= right[tr]) {
                nums[k] = left[tl];
                tl++;
            }
            else {
                nums[k] = right[tr];
                tr++;
            }
            k++;
        }
        while (tl < sl) {
            nums[k] = left[tl];
            k++; tl++;
        }
        while (tr < sr) {
            nums[k] = right[tr];
            k++; tr++;
        }
    }
}
