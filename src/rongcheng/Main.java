package rongcheng;

import rongcheng.sort.*;
import rongcheng.sort.cmp.*;
import rongcheng.tools.Asserts;
import rongcheng.tools.Integers;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] array = Integers.random(20000, 1, 20000);

        testSorts(array,
                new HeapSort(),
                new BubbleSort(),
                new SelectionSort(),
                new InsertionSort(),
                new MergeSort(),
                new QuickSort(),
                new ShellSort(),
                new CountingSort()
        );
    }

    private static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }

        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}
