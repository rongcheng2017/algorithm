package rongcheng.sort.cmp;

import rongcheng.sort.Sort;

public class InsertionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort3();
    }


    private void sort1() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, --cur);
            }
        }
    }

    private void sort2() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            E element = array[cur];
            while (cur > 0 && cmp(element, array[cur - 1]) < 0) {
                array[cur] = array[--cur];
            }
            array[cur] = element;
        }
    }

    private void sort3() {
        for (int begin = 1; begin < array.length; begin++) {
            //头部是有序的，使用二分查找，复杂度就是O(logn)
            int insertIndex = search(begin);
            insert(begin, insertIndex);
        }
    }

    private void insert(int begin, int insertIndex) {
        //备份
        E element = array[begin];
        //将[insertIndex,begin)位置像后挪
        for (int i = begin; i > insertIndex; i--) {
            array[i] = array[i - 1];
        }
        array[insertIndex] = element;
    }

    /**
     * 找到index元素待插入的位置
     * <p>
     * 已经排好的区域是[0,index)
     *
     * @param index 待插入元素的位置
     * @return 应该插入的位置
     */
    private int search(int index) {
        E v = array[index];
        int begin = 0;
        int end = index;

        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(v, array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;

    }


    private void myInsertSort() {
        for (int start = 1; start < array.length; start++) {
            int cur = start;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, --cur);
            }
        }
    }

    private void myInsertSort1() {
        for (int start = 1; start < array.length; start++) {
            int cur = start;
            E element = array[cur];
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                array[cur] = array[--cur];
            }
            array[cur] = element;
        }
    }

    private void myInsertSort2() {
        for (int start = 1; start < array.length; start++) {
            int index = findIndex(start);
            insertIndex(start, index);
        }
    }

    private void insertIndex(int start, int index) {
        E v = array[start];
        for (int i = start; i > index; i--) {
            array[i] = array[i--];
        }
        array[index] = v;
    }

    private int findIndex(int start) {
        E v = array[start];
        int begin = 0;
        int end = start;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(v, array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
