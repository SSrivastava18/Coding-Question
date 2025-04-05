import java.util.*;

public class App {

    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }

            }

        }
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static int[] removeDuplicates(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (arr[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                temp[index++] = arr[i];
            }
        }

        return Arrays.copyOf(temp, index);
    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;

            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            arr[prev + 1] = curr;
        }
    }

    public static void moveZeros(int[] arr) {
        int pos = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[pos++] = arr[i];
            }
        }

        while (pos < arr.length) {
            arr[pos++] = 0;
        }
    }

    public static int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {

                right = mid;
            }
        }
        return arr[left];
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sortedOrNot(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("Array is not sorted");
                return;
            }
        }
        System.out.println("Array is sorted");
    }

    public static int maxElement(int arr[]) {
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int secondLargest(int arr[]) {
        if (arr.length < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                second = largest;
                largest = arr[i];
            } else if (arr[i] > second && arr[i] != largest) {
                second = arr[i];
            }
        }

        if (second == Integer.MIN_VALUE) {
            return -1;
        }

        return second;
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static int squareRootBinarySearch(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Square root of negative numbers is not supported.");
        }
        int left = 0, right = value, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == value) {
                return mid;
            } else if (mid * mid < value) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left];
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static List<Integer> findAllPairs(int[] arr) {
        Arrays.sort(arr);
        List<Integer> pairsList = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                pairsList.add(arr[i]);
                pairsList.add(arr[i]);
                i++;
            }
        }

        return pairsList;
    }

    public static int findMajorityElement(int[] arr) {
        int candidate = -1, count = 0;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        return count > arr.length / 2 ? candidate : -1;
    }

    public static void firstlastocc(int arr[]) {
        int first = -1, last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[0]) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        System.out.println(first);
        System.out.println(last);
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
  

    public static void main(String[] args) throws Exception {
        // int[] arr = {10,16,8,12,6,3,9,5};
        // quickSort(arr, 0, arr.length - 1);
        // print(arr);
        
        // int[][] matrix = {
        //     {1, 2, 3},
        //     {4, 5, 6},
        //     {7, 8, 9}
        // };
        

        // List<Integer> spiral = spiralOrder(matrix);
        // System.out.println("Spiral Order: " + spiral);

        // rotateArray(arr, 3);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i]+" ");
        // }

        // List<Integer> pairs = findAllPairs(arr);
        // System.out.println("Pairs:");
        // for (int i = 0; i < pairs.size(); i += 2) {
        // System.out.println("(" + pairs.get(i) + ", " + pairs.get(i + 1) + ")");
        // }

        // int[][] matrices = { { 1, 2, 3 },
        // { 4, 5, 6 },
        // { 7, 8, 9 } };

        // for (int i = 0; i < matrices.length; i++) {
        // for (int j = 0; j < matrices[0].length; j++) {
        // matrices[i][j] = matrices[j][i];
        // }
        // }
        // for (int i = 0; i < matrices.length; i++) {
        // for (int j = 0; j < matrices[0].length; j++) {
        // System.out.print(matrices[i][j] + " ");
        // }
        // System.out.println();

        // }
        // int[][] transpose = new int[matrices.length][matrices[0].length];

        // transpose.....
        // for (int i = 0; i < matrices.length; i++) {
        // for (int j = 0; j < matrices[0].length; j++) {
        // transpose[i][j] = matrices[j][i];
        // }

        // }
        // // for (int i = 0; i < transpose.length; i++) {
        // for (int j = 0; j < transpose[0].length; j++) {
        // System.out.print(transpose[i][j] + " ");
        // }
        // System.out.println();
        // }

        // rotate by 90 degree
        // for (int i = 0; i < transpose.length; i++) {
        // int start = 0, end = transpose[0].length - 1;
        // while (start < end) {
        // int temp = transpose[i][start];
        // transpose[i][start] = transpose[i][end];
        // transpose[i][end] = temp;
        // start++;
        // end--;
        // }
        // }

        // for (int i = 0; i < transpose.length; i++) {
        // for (int j = 0; j < transpose[0].length; j++) {
        // System.out.print(transpose[i][j] + " ");
        // }
        // System.out.println();
        // }

        // int m = findMajorityElement(arr);
        // System.out.println(m);

    }

}
