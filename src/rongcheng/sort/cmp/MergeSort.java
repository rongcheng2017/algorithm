package rongcheng.sort.cmp;

import rongcheng.sort.Sort;

/**
 * 归并排序
 */
@SuppressWarnings("ALL")
public class MergeSort<E extends Comparable<E>> extends Sort<E> {

    private E[] leftArray;

    @Override
    protected void sort() {
        //分配一个最大的空间，后面复用即可，不需要每次merge时，不停创建
        leftArray = (E[]) new Comparable[array.length >> 1];
        sort(0, array.length);

    }

    /**
     * 对[begin,end)范围的数据进行归并排序
     *
     * @param begin 开始
     * @param end   结束
     */
    private void sort(int begin, int end) {
        //元素数量小于2  不用排序
        if (end - begin < 2) {
            return;
        }
        //切割 divide
        int middle = (begin + end) >> 1;
        sort(begin, middle);
        sort(middle, end);
        //合并 merge
        merge(begin, middle, end);
    }

    /**
     * 合并  将两个有序的数组合并成一个有序的数组
     *
     * @param begin  【begin,middle)
     * @param middle 中间值
     * @param end    [middle,end)
     */
    private void merge(int begin, int middle, int end) {
        //左边数组当期所在的点li, 终点le
        int li = 0, le = middle - begin;
        //右边数组(即array上右边)当前所在的点ri, 终点re
        int ri = middle, re = end;
        //已经排序好的坐标
        int ai = begin;

        //备份坐标数组
        for (int i = li; i < le; i++) {
            //注意array取值是begin+i ，sort(begin,end)是递归调用，所以begin不一定是0
            leftArray[i] = array[begin + i];
        }
        //如果左边提前结束，那么后续都不需要做了。即li增长到le
        while (li < le) {
            //左边用li从leftArray上取，右边用ri从array上取
            // ri小心数组越界
            if (ri < re && cmp(array[ri], leftArray[li]) < 0) {
                //右边比较小
                array[ai++] = array[ri++];
            } else {
                // left: 1  6 9 11     right: 1 2 4 5
                // 如果是上面这两种情况合并，使用>标记，
                // 右边的1就会覆盖左边的1，从而造成不稳定，
                // 所以此处应该用  > = 。
                array[ai++] = leftArray[li++];
            }
        }
    }

}
