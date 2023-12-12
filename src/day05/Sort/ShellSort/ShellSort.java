package day05.Sort.ShellSort;

public class ShellSort {
    public void incInsertionSort (int[] list, int first, int gap) {
        int i, j, key;
        for (i = first + gap; i < list.length; i += gap) {
            key = list[i];

            for (j = i - gap; first <= j && key < list[j]; j = j - gap) {
                list[j + gap] = list[j];
            }
            list[j + gap] = key;
        }
    }

    // arr = {8, 3, 2, 1, 5, 4, 10}
    // arr.length = 7

    public int[] shellSort (int[] list) {
        int i, gap;
        for (gap = list.length / 2; gap > 0; gap /= 2) {
            /*
                for (gap = 7 / 2 = 3; gap > 0; gap /= 2)

                    for (i = 0; i < 3; i++)
                        incInsertionSSort(arr, 0, 3)
                            ->
                                for(i = 0 + 3 = 3; i < 7; i++)
                                    key = list[3] = 1

                                    for(j = 3 - 3 = 0; 0 <= j && 1 <list[0]; j = j - gap = 0 - 3


            */

            if (gap % 2 == 0) {
                gap += 1;
            }
            for (i = 0; i < gap; i++) {
                incInsertionSort(list, i, gap);
            }
        }
        return list;
    }
}
