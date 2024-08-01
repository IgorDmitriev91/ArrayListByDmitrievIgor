public class QuickSort {
    public static void quickSort(Object[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);


            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    private static int partition(Object[] arr, int low, int high) {
        int pivot = (int) arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if ((int)arr[j] < pivot) {
                i++;


                int temp = (int) arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        int temp = (int) arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;


        return i + 1;
    }
}

