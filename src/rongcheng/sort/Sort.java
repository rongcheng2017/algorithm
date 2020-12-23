package rongcheng.sort;

import rongcheng.Student;
import rongcheng.sort.cmp.SelectionSort;
import rongcheng.sort.cmp.ShellSort;

import java.text.DecimalFormat;

public abstract class Sort<T extends Comparable<T>> implements Comparable<Sort<T>> {
    protected T[] array;
    private int mCmpCount;
    private int mSwapCount;
    private long time;
    private DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort(T[] data) {
        if (data == null || data.length < 2) return;
        this.array = data;
        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    protected abstract void sort();

    protected void swap(int first, int second) {
        mSwapCount++;
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    @Override
    public int compareTo(Sort<T> o) {
        int result = (int) (time - o.time);
        if (result != 0) return result;

        result = mCmpCount - o.mCmpCount;
        if (result != 0) return result;

        return mSwapCount - o.mSwapCount;
    }

    /**
     * 比较
     *
     * @param first  第一个元素位置
     * @param second 第二个元素位置
     * @return 0：相等 ，>0 ：first大 ,<0: second大
     */
    protected int cmp(int first, int second) {
        mCmpCount++;
        return array[first].compareTo(array[second]);
    }

    protected int cmp(T first, T second) {
        mCmpCount++;
        return first.compareTo(second);
    }

    @Override
    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + numberString(mCmpCount);
        String swapCountStr = "交换：" + numberString(mSwapCount);
        String stableStr = "稳定性：" + isStable();
        return "【" + getClass().getSimpleName() + "】\n"
                + stableStr + " \t"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";
    }

    private String numberString(int number) {
        if (number < 10000) return "" + number;

        if (number < 100000000) return fmt.format(number / 10000.0) + "万";
        return fmt.format(number / 100000000.0) + "亿";
    }

    private boolean isStable() {
//        if (this instanceof RadixSort) return true;
        if (this instanceof CountingSort) return false;
        if (this instanceof ShellSort) return false;
        if (this instanceof SelectionSort) return false;
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i * 10, 10);
        }
        sort((T[]) students);
        for (int i = 1; i < students.length; i++) {
            int score = students[i].score;
            int prevScore = students[i - 1].score;
            if (score != prevScore + 10) return false;
        }
        return true;
    }
}
