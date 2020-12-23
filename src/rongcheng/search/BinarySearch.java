package rongcheng.search;

public class BinarySearch {


    public static void main(String[] args) {

        Integer[] array = {2, 4, 6, 8, 10, 12};

        int index = search(array, 10);
        System.out.println(index);
        int index1 = search(array, 12);
        System.out.println(index1);
        int index2 = search(array, 2);
        System.out.println(index2);
        int index3 = search(array, -2);
        System.out.println(index3);

    }

    /**
     * @param array 搜索对象
     * @param key   目标值
     * @return -1代表搜索失败，其他代码目标值在搜索对象中的角标
     */
    public static int search(Integer[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int middle = (begin + end) >> 1;
            if (key > array[middle]) {
                begin = middle + 1;
            } else if (key < array[middle]) {
                end = middle;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
