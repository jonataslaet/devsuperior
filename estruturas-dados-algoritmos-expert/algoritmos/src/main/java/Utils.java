import java.util.List;

public class Utils {

    public static void showElements(int[] nums) {
        if (nums.length > 0) {
            System.out.print(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                System.out.print(", " + nums[i]);
            }
        }
    }

    public static void showElements(List<Integer> nums) {
        System.out.print(nums.getFirst());
        for (int i = 1; i < nums.size(); i++) {
            System.out.print(", " + nums.get(i));
        }
    }

}
