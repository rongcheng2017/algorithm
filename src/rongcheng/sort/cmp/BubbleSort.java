package rongcheng.sort.cmp;


import rongcheng.sort.Sort;

public class BubbleSort<E extends Comparable<E>> extends Sort<E> {
    protected void sort() {
        sort3();
    }

    private void sort1() {
        //从后面逐步减少遍历个数
        for (int end = array.length; end > 1; end--) {
            //比较，筛选出当前列最大的数放到最后
            for (int start = 1; start < end; start++) {
                if (cmp(start, start - 1) < 0) {
                    swap(start, start - 1);
                }
            }
        }
    }

    private void sort2() {
        //从后面逐步减少遍历个数
        for (int end = array.length; end > 1; end--) {
            boolean sorted = true;
            //比较，筛选出当前列最大的数放到最后
            for (int start = 1; start < end; start++) {
                if (cmp(start, start - 1) < 0) {
                    swap(start, start - 1);
                    //序列无序的
                    sorted = false;
                }
            }
            //当前序列已经是有序的了，没必要再遍历
            if (sorted) {
                break;
            }
        }
    }

    private void sort3() {
        //从后面逐步减少遍历个数
        for (int end = array.length - 1; end > 0; end--) {
            //sortIndex最后会复制给end，
            //sortIndex需要考虑完全有序的时候，end会就是初始值，
            //此时要退出循环，所以可以设置1，0等让下次循环条件不符合。
            int sortIndex = 1;
            //比较，筛选出当前列最大的数放到最后
            for (int start = 1; start <= end; start++) {
                if (cmp(start, start - 1) < 0) {
                    swap(start, start - 1);
                    //记录最后一次交换的位置
                    sortIndex = start;
                }
            }
            //缩小下一轮扫描范围
            end = sortIndex;
        }
    }


    private void mySort() {
        for (int end = array.length; end > 1; end--) {
            for (int start = 1; start < end; start++) {
                if (cmp(start, start - 1) < 0) {
                    swap(start, start - 1);
                }
            }
        }
    }

    private void mySort1() {


        for (int end = array.length; end > 1; end--) {
            boolean sorted = true;
            for (int start = 1; start < end; start++) {
                if (cmp(start, start - 1) < 0) {
                    swap(start, start - 1);
                    sorted = false;
                }
            }
            if (sorted) {
                return;
            }

        }

    }


    private void mySort2() {
        for (int end = array.length; end > 1; end--) {

            int stortedIndex = 1;
            for (int start = 1; start < end; start++) {
                if (cmp(start, start - 1) < 0) {
                    swap(start, start - 1);
                    stortedIndex = start;
                }
            }
            end = stortedIndex;
        }
    }


}
