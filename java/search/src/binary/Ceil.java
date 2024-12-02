package binary;

public class Ceil {

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 9, 10, 13};
        int target = 2;

        System.out.println(find(arr, target));
    }

    private static int find(int[] arr, int target) {
        int left = 0, right = arr.length - 1, ceil = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                ceil = arr[middle];
                right = middle - 1;
            }
        }

        return ceil;
    }

}
