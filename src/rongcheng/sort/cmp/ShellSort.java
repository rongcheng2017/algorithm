package rongcheng.sort.cmp;

import rongcheng.sort.Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShellSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        //获取步队列
        List<Integer> stepQueue = shellStepQueue();
        //对所有列执行插入排序
        for (Integer step : stepQueue) {
            sort(step);
        }
    }

    private void sort(Integer step) {
        // col:第几列   结尾是step
        for (int col = 0; col < step; col++) {
            //将原有数据模拟的分为以step列
            //需注意欢迎每列在原来数组的位置：
            //对每列数据进行插入排序
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur -= step);
                }
            }
        }
    }

    /**
     * shell推荐的Step列
     *
     * @return step列
     */
    private List<Integer> shellStepQueue() {
        ArrayList<Integer> queue = new ArrayList<>();
        int step = array.length;
        while ((step >>= 1) > 0) {
            queue.add(step);
        }
        return queue;

    }

    /**
     * 目前公认最优的Step获取方式
     *
     * @return step
     */
    private List<Integer> sedgewickStepSequence() {
        List<Integer> stepSequence = new LinkedList<>();
        int k = 0, step = 0;
        while (true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }
            if (step >= array.length) break;
            stepSequence.add(0, step);
            k++;
        }
        return stepSequence;
    }

    private void sort1(int step) {

        //分成step列
        for (int col = 0; col < step; col++) {

            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur -= step);
                }
            }
        }


    }


    private List<Integer> getShellSteps() {
        List<Integer> shellSteps = new ArrayList<>();
        int step = array.length;
        while ((step >>= 1) > 0) {
            shellSteps.add(step);
        }
        return shellSteps;


    }

}
