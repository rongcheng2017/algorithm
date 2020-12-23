package rongcheng.sort.cmp;


import rongcheng.sort.Sort;

public class SelectionSort<E extends Comparable<E>> extends Sort<E> {


    @Override
    protected void sort() {
        //从后面逐步减少遍历个数
        for (int end = array.length - 1; end > 0; end--) {
            //假设0是最大
            int maxIndex = 0;
            for (int start = 1; start <= end; start++) {
                if (cmp(maxIndex, start) <= 0) {
                    maxIndex = start;
                }
            }
            //将找到的最大值与最后个元素交换
            swap(maxIndex, end);
        }
    }


    private void sort1() {


        for (int end = array.length; end > 0; end--) {

            int maxIndex = 0;
            for (int start = 1; start < end; start++) {
                if (cmp(maxIndex, start) < 0) {
                    maxIndex = start;
                }
            }
            swap(maxIndex, end - 1);
        }
    }

}
