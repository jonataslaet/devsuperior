package sorts;

public class QuickSort {
    public void sort(int[] nums, int left, int right) {
        if (left < right) {
            int partitionIndex = doPartition(nums, left, right);
            sort(nums, left, partitionIndex - 1);
            sort(nums, partitionIndex + 1, right);
        }
    }

    private int doPartition(int[] nums, int left, int right) {
        int pivotIndex = right-1;
        int pivot = nums[pivotIndex];
        int indexLeft = left;
        int i = left;
        while (i < pivotIndex) {
            if (nums[i] <= pivot) {
                swap(nums, i, indexLeft);
                indexLeft++;
            }
            i++;
        }
        swap(nums, pivotIndex, indexLeft);
        return indexLeft;
    }

    private void swap(int nums[], int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}
