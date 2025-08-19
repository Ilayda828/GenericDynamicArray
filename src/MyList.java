public class MyList<T> {
    private T[] array;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    // Boş constructor - varsayılan boyut 10
    @SuppressWarnings("unchecked")
    public MyList() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    // Kapasiteli constructor
    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    // Dizideki eleman sayısını verir
    public int size() {
        return size;
    }

    // Dizinin kapasite değerini verir
    public int getCapacity() {
        return capacity;
    }

    // Dizi boyutunu 2 katına çıkarır
    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    // Diziye eleman ekler
    public void add(T data) {
        if (size >= capacity) {
            resize();
        }
        array[size] = data;
        size++;
    }

    // Verilen indisteki değeri döndürür
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    // Verilen indisteki veriyi siler ve sonraki elemanları sola kaydırır
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        
        T removedElement = array[index];
        
        // Elemanları sola kaydır
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        
        size--;
        array[size] = null; // Son elemanı null yap
        
        return removedElement;
    }

    // Verilen indisteki veriyi yenisi ile değiştirir
    public T set(int index, T data) {
        if (index < 0 || index >= size) {
            return null;
        }
        
        T oldElement = array[index];
        array[index] = data;
        return oldElement;
    }

    // Dizideki elemanları string olarak döndürür
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Parametrede verilen nesnenin listedeki indeksini verir
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if ((data == null && array[i] == null) || 
                (data != null && data.equals(array[i]))) {
                return i;
            }
        }
        return -1;
    }

    // Belirtilen öğenin listedeki son indeksini söyler
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if ((data == null && array[i] == null) || 
                (data != null && data.equals(array[i]))) {
                return i;
            }
        }
        return -1;
    }

    // Listenin boş olup olmadığını söyler
    public boolean isEmpty() {
        return size == 0;
    }

    // Listedeki öğeleri aynı sırayla bir array haline getirir
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    // Listedeki bütün öğeleri siler
    @SuppressWarnings("unchecked")
    public void clear() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    // Parametrede verilen indeks aralığına ait bir liste döner
    public MyList<T> subList(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) {
            return new MyList<>();
        }
        
        MyList<T> subList = new MyList<>();
        for (int i = start; i <= finish; i++) {
            subList.add(array[i]);
        }
        return subList;
    }

    // Parametrede verilen değerin dizide olup olmadığını söyler
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
    
    // Test method
    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();
        System.out.println("Number of Elements in Array : " + liste.size());
        System.out.println("Array Capacity : " + liste.getCapacity());
        
        liste.add(10);
        liste.add(20);
        liste.add(30);
        System.out.println("Test successful - MyList class is working!");
        System.out.println(liste.toString());
    }
}