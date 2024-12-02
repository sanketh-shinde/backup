package quick;

public class QuickSort {

    /* Method to perform quicksort */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            /*
             Find pivot element such that elements smaller than pivot are on the left,
             and elements greater than pivot are on the right
            */
            int pivotIndex = partition(arr, low, high);

            /* Recursively sort the elements before and after the pivot */
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /* Helper method to partition the array */
    private static int partition(int[] arr, int low, int high) {
        /* Taking the last element as the pivot */
        int pivot = arr[high];
        /* index of smaller element */
        int i = low - 1;

        /*
         Rearranging the array such that elements less than pivot are on the left
         and elements greater than pivot are on the right
        */
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                /* Swap arr[i] and arr[j] */
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        /* Swap arr[i+1] and arr[high] to place pivot in the correct position */
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        /* Return the pivot index */
        return i + 1;
    }

    /* Method to print the array */
    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}

