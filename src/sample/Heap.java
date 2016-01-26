package sample;

public class Heap {

    private static int getLeftChildIndex(int nodeIndex) {
        //uzyskiwanie ideksu lewego dziecka- wi�kszego
        return 2 * nodeIndex + 1;
    }

    private static int getRightChildIndex(int nodeIndex) {
        //usyskiwanie indeku prawego dziecka- mniejszego
        return 2 * nodeIndex + 2;
    }

    private static int getParentIndex(int nodeIndex) {
        //uzyskiwanie indeksu rodzica
        return (nodeIndex - 1) / 2;
    }

    private static void swap(int [] heap, int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void print(int[] heap) {
        for (int i = 0; i < heap.length; i++) {
            System.out.printf("%d-", heap[i]);
        }
    }

    public static void insert(int[] heap,int n, int value) {
        heap[n - 1] = value;
        heapUp(heap, n);
    }

    public static void heapify(int[] notHeapYet){
        for (int i = 0; i <notHeapYet.length ; i++) {
            heapUp(notHeapYet,i);
        }
    }

    public static void heapUp(int[] heap, int n) {
        int i = n - 1;
        while (i > 0) {
            int parent = getParentIndex(i);
            if (heap[parent] >= heap[i])
                return;
            swap(heap, i, parent);
            i = parent;
        }
    }

    public static void heapDown(int[] heap,int n) {
        int act = 0;
        int child = getLeftChildIndex(act);


        while (child < n) {
            if (child + 1 < n && heap[child + 1] > heap[child])
                child++;
            if (heap[act] >= heap[child])
                return;
            swap(heap,act,child);
            act = child;
            child = getLeftChildIndex(act);
        }
    }

    public static void heapSort(int[] heap) {
        //najpierw tworzymy kopiec
        heapify(heap);
        /* dopiero poniższa petla sortuje */
        for( int i = heap.length-1; i > 0; i--) {
            swap(heap, 0, i);
            heapDown(heap, i); //zebv zachowac wlasnosci kopca
        }
    }



}