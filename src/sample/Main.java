package sample;

import static sample.Heap.heapSort;
import static sample.Heap.heapify;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 8, 3, 7, 6, 1, 9, 2, 4, 0};

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d-",arr[i]);
        }
        int arr2[]= arr;

        System.out.println("\nTeraz tablica przekształcona na kopiec");
        heapify(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d-",arr[i]);
        }

        System.out.println("\nTeraz tablica posortowana przez kopcowanie");
        heapSort(arr2);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d-",arr2[i]);
        }



    }
}
