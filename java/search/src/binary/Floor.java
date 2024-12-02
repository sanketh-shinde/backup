package binary;

public class Floor {

    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 9, 13, 15};
        int target = 12;

        System.out.println(find(arr, target));
    }

    private static int find(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int floor = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] < target) {
                floor = arr[middle];
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return floor;
    }


}
