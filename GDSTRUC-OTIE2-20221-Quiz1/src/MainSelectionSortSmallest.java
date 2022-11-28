public class MainSelectionSortSmallest {
    public static void main(String[] args) {
        // initialize array
        int[] numbers = new int[10];
        numbers[0] = 25;
        numbers[1] = 3;
        numbers[2] = 5;
        numbers[3] = 10;
        numbers[4] = 38;
        numbers[5] = 62;
        numbers[6] = 20;
        numbers[7] = 8;
        numbers[8] = 173;
        numbers[9] = 65;

        // array before sorting
        System.out.print("Array Before Sorting: ");
        printArrayElements(numbers);
        System.out.print("\n\n");

        // array after sorting
        System.out.print("Array After Sorting: ");
        selectionSort(numbers);
        printArrayElements(numbers);
        System.out.print("\n");
    }

    // function to print the array elements
    private static void printArrayElements(int[] numbers) {
        for (int value : numbers ) {
            System.out.print(value + " ");
        }
    }

    // function to sort the array using selection sort algorithm
    // 11810964: renamed largestIndex to smallestIndex in original code to reflect algorithm changes
    private static void selectionSort(int[] numbers) {
        for (int lastSortedIndex = numbers.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
            int smallestIndex = 0;
            for (int i = 1; i <= lastSortedIndex; i++) {
                // 11810964: modified > to < in order to sort arrays in descending order, looking for the smallest number
                if (numbers[i] < numbers[smallestIndex]) {
                    smallestIndex = i;
                }
            }

            // 11810964: swap element in -smallestIndex- with element in lastSortedIndex
            int temp = numbers[smallestIndex];
            numbers[smallestIndex] = numbers[lastSortedIndex];
            numbers[lastSortedIndex] = temp;
        }
    }
}