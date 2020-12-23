package rongcheng.sort.cmp;

import rongcheng.sort.Sort;

public class QuickSort<E extends Comparable<E>> extends Sort<E> {


    @Override
    protected void sort() {
        sort(0, array.length);
    }

    /**
     * 对 [begin,end)范围元素进行快速排序
     *
     * @param begin
     * @param end
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        //获取当前序列的轴点
        int mid = getPivotIndex(begin, end);
        //对左边子序列 快速排序
        sort(begin, mid);
        //对右边子序列 快速排序
        sort(mid + 1, end);
    }


    /**
     * 确定 [begin,end)范围内的轴点元素
     *
     * @return pivot index
     */
    private int pivotIndex(int begin, int end) {

        //随机选择一个元素与begin交互
        swap(begin, begin + (int) Math.random() * (end - begin));

        //备份begin位置的元素
        E pivot = array[begin];
        //由于区间是左闭右开的，想要获取最后一个元素需要 end-1
        end--;

        while (begin < end) {

            while (begin < end) {
                //先从右往左
                if (cmp(pivot, array[end]) < 0) {
                    //右边元素大于 轴点元素
                    end--;
                } else {
                    //右边元素小于等于 轴点元素
                    //将end元素放到begin位置
                    array[begin++] = array[end];
                    //切换方向
                    break;
                }
            }

            while (begin < end) {
                //从左往右
                if (cmp(pivot, array[begin]) > 0) {
                    //左边元素 < 轴点元素
                    begin++;
                } else {
                    //将begin元素放到end位置
                    array[end--] = array[begin];
                    //切换方向
                    break;
                }
            }

        }
        //将轴点元素放入最终的轴点位置
        array[begin] = pivot;
        //返回轴点
        return begin;//end==begin

    }


    private void sort2(int begin, int end) {
        if (begin > end) return;
        //计算轴点元素
        int pivotIndex = getPivotIndex(begin, end);
        sort(0, pivotIndex);
        sort(pivotIndex + 1, array.length);

    }

    private int getPivotIndex(int begin, int end) {
        //轴点元素；将比他小的都放左边 比他大的都放右边

        //备份 轴点数据 以begin 为轴点
        E pivot = array[begin];

        //不然角标越界
        end--;

        while (begin < end) {
            //end->begin 扫描
            while (begin < end) {
                if (cmp(array[end], pivot) < 0) {
                    array[begin++] = array[end];
                    break;
                } else {
                    end--;
                }
            }
            //begin->end 扫描

            while (begin < end) {
                if (cmp(array[begin], pivot) < 0) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        array[begin] = pivot;
        return begin;


    }

}
