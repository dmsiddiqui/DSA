public class MyArrayList<T> {
    private T[] asArray;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        asArray = (T[]) new Object[10];
        size = 0;
    }

    public void add(T value) {
        ensureCapacity();
        asArray[size] = value;
        size++;
    }

    public void insert(int index, T value) {
        if (index >= 0 && index <= size) {
            ensureCapacity();
            for (int i = size; i > index; i--) {
                asArray[i] = asArray[i - 1];
            }
            asArray[index] = value;
            size++;
        } else {
            System.out.println("Invalid index. Insert operation skipped.");
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                asArray[i] = asArray[i + 1];
            }
            asArray[size - 1] = null;
            size--;
        } else {
            System.out.println("Invalid index. Delete operation skipped.");
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if ((asArray[i] == null && value == null) || (asArray[i] != null && asArray[i].equals(value))) {
                return true;
            }
        }
        return false;
    }

    public void set(int index, T value) {
        if (index >= 0 && index < size) {
            asArray[index] = value;
        } else {
            System.out.println("Invalid index. Set operation skipped.");
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return asArray[index];
        } else {
            System.out.println("Invalid index. Returning null.");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == asArray.length) {
            T[] newArray = (T[]) new Object[asArray.length * 2 + 1];
            for (int i = 0; i < asArray.length; i++) {
                newArray[i] = asArray[i];
            }
            asArray = newArray;
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.insert(1, 15);
        System.out.println("List size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Contains 20: " + list.contains(20));
        list.delete(1);
        System.out.println("Element at index 1 after deletion: " + list.get(1));
        System.out.println("Is list empty: " + list.isEmpty());
        list.set(1, 25);
        System.out.println("Element at index 1 after set: " + list.get(1));
    }
}

