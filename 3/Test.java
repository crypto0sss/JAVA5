import heapsort.HeapSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    private final HeapSort heapSort = new HeapSort();

    @Test
    void testEmptyArray() {
        int[] arr = {};
        heapSort.sortArray(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {5};
        heapSort.sortArray(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testTwoElementsSorted() {
        int[] arr = {1, 2};
        heapSort.sortArray(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    void testTwoElementsUnsorted() {
        int[] arr = {2, 1};
        heapSort.sortArray(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    void testMultipleElements() {
        int[] arr = {3, 5, 1, 4, 2};
        heapSort.sortArray(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testDuplicates() {
        int[] arr = {3, 1, 2, 3, 3};
        heapSort.sortArray(arr);
        assertArrayEquals(new int[]{1, 2, 3, 3, 3}, arr);
    }

    @Test
    void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        heapSort.sortArray(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        heapSort.sortArray(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testNegativeNumbers() {
        int[] arr = {-1, -5, -3, -2, -4};
        heapSort.sortArray(arr);
        assertArrayEquals(new int[]{-5, -4, -3, -2, -1}, arr);
    }

    @Test
    void testLargeNumbers() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        heapSort.sortArray(arr);
        assertArrayEquals(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, arr);
    }
}
