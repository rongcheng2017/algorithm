package rongcheng.sort;

public class CountingSort extends Sort<Integer> {


    @Override
    protected void sort() {
        sort2();
    }

    private void sort1() {
        //找出最大值
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        //开辟存储用的数组,用于存储每个数的出现次数
        int[] accouts = new int[max + 1];

        //存储
        for (int i = 0; i < array.length; i++) {
            accouts[array[i]]++;
        }

        //根据整数出现的次数 对整数进行排序
        int index = 0;
        for (int i = 0; i < accouts.length; i++) {
            while (accouts[i]-- > 0) {
                array[index++] = i;
            }
        }
    }

    private void sort2() {
        //找出最大值 最小
        int max = array[0];
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }

        //开辟存储用的数组,用于存储每个整数次数
        int[] accouts = new int[max - min + 1];
        //存储每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            accouts[array[i] - min]++;
        }

        //每个数累计前面的所有次数 从左->右
        for (int i = 1; i < accouts.length; i++) {
            accouts[i] += accouts[i - 1];
        }


        //从后往前遍历array，将它放倒有序数组中的合适位置
        int[] newArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            //将array中数取出，问题是放在有序数组中的位置。
            //求有序数组中的索引
            // 从accounts中找到存储的值 array[i]-min 是该index
//            int value = accouts[array[i] - min];
            //值-- 才是该值最后一个的存储位置(如果有相同值)
//            int index = value--;
            //同时需要将该值回传到accounts中
//            accouts[array[i] - min] = index;
            //使用index作为该值在有序数组newArray中的位置
//            newArray[index] = array[i];;

            //上面几步合成一步
            newArray[--accouts[array[i] - min]] = array[i];
        }


        //将newArray赋值给array
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }


    }
}
