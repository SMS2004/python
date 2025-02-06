public class javamergesort {

    // Main function that sorts the array using merge sort
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Base case: array of length 1 or less is already sorted
        }

        int mid = array.length / 2;  // Find the middle point of the array
        int[] left = new int[mid];    // Create left subarray
        int[] right = new int[array.length - mid];  // Create right subarray

        // Copy the elements into the left and right subarrays
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // Recursively sort the left and right subarrays
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted subarrays
        merge(array, left, right);
    }

    // Merge function to combine the two sorted subarrays
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the two arrays while there are elements in both
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy the remaining elements of left, if any
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy the remaining elements of right, if any
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Utility function to print the array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test the merge sort implementation
    public static void main(String[] args) {
        int[] array = { 38, 27, 43, 3, 9, 82, 10 };

        System.out.println("Original array:");
        printArray(array);

        mergeSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }
}
