package binarys;

/**
 * Created by levente on 2017.06.08..
 */
public class BinarySearch {

    private int[] array;
    private int size;

    public BinarySearch(int[] array) {
        this.array = array;
        this.size = array.length-1;
    }

    public int search(int item){
        int l = 0;
        int h = size;

        while (l <= h) {
            int m = l+(h-l)/2;

            if (array[m] == item) return m;
            if (array[m] > item) h = m;
            if (array[m] < item) l = m;
        }
        System.out.println("Item not found :(");
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};

        BinarySearch bs = new BinarySearch(a);

        System.out.println(bs.search(3));
    }
}
