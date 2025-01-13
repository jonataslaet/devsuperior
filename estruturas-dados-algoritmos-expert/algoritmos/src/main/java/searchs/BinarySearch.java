package searchs;

public class BinarySearch {
    public Integer searchRecursively(int[] nums, int left, int right, int value) {
        int m = (left + right) / 2;
        if (value < nums[m]) {
            return searchRecursively(nums, left, m - 1, value);
        }
        else if (value > nums[m]) {
            return searchRecursively(nums, m + 1, right, value);
        }
        else if (value == nums[m]) {
            return m;
        }
        return null;
    }

    public Integer searchIteractively(int[] nums, int value) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (value < nums[m]) {
                r = m - 1;
            }
            else if (value > nums[m]) {
                l = m + 1;
            }
            else {
                return m;
            }
        }
        return null;
    }
}
