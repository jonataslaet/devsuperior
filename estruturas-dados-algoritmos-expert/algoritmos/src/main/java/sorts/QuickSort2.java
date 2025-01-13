package sorts;

import java.util.ArrayList;
import java.util.List;

public class QuickSort2 {
    public List<Integer> getSorted(List<Integer> nums) {
        if (nums.size() < 2) {
            return nums;
        }
        else if (nums.size() == 2) {
            if (nums.get(0) > nums.get(1)) {
                swapBothIn(nums);
                return nums;
            }
            return nums;
        }

        int pivot = nums.get(nums.size() / 2);

        List<Integer> leftArrayList = new ArrayList<>();
        List<Integer> rightArrayList = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < pivot) leftArrayList.add(nums.get(i));
            else if (nums.get(i) > pivot) rightArrayList.add(nums.get(i));
        }

        List<Integer> newArrayList = new ArrayList<>(getSorted(leftArrayList));
        newArrayList.add(pivot);
        newArrayList.addAll(getSorted(rightArrayList));
        return newArrayList;
    }

    private void swapBothIn(List<Integer> nums) {
        int aux = nums.get(0);
        nums.set(0, nums.get(1));
        nums.set(1, aux);
    }
}
