public class Heap {
    private int[] data;
    private int heapSize;

    public Heap(int size) {
        data = new int[size];
        heapSize = 0;
    }

    public int getMax() {
        //otrzymywanie najwyzszego elementu kopca
        if (isEmpty())
            throw new HeapException("Heap is empty");
        else
            return data[0];
    }

    public boolean isEmpty() {
        return (heapSize == 0);
    }

    private int getLeftChildIndex(int nodeIndex) {
        //uzyskiwanie ideksu lewego dziecka- wi�kszego
        return 2 * nodeIndex + 1;
    }

    private int getRightChildIndex(int nodeIndex) {
        //usyskiwanie indeku prawego dziecka- mniejszego
        return 2 * nodeIndex + 2;
    }

    private int getParentIndex(int nodeIndex) {
        //uzyskiwanie indeksu rodzica
        return (nodeIndex - 1) / 2;
    }

    public class HeapException extends RuntimeException {
        public HeapException(String message) {
            super(message);
        }
    }

    public void insert(int value) {
        heapSize++;
        data[heapSize - 1] = value;
        heapUp(heapSize - 1);
    }

    public void heapUp(int n) {
        int i = n - 1;
        while (i > 0) {
            int parent = getParentIndex(i);
            if (data[parent] >= data[i])
                return;
            swap(i, parent);
            i = parent;
        }
    }

    public void heapDown(int n) {
        int act = 0;
        int child = getLeftChildIndex(act);


        while (child < n) {
            if (child + 1 < n && data[child + 1] > data[child])
                child++;
            if (data[act] >= data[child])
                return;
            swap(act,child);
            act = child;
            child = getLeftChildIndex(act);
        }
    }


    private void swap(int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d-", data[i]);
        }
    }


}