package com.struct.linked;

/**
 * program leetcode
 * <p>
 * description
 *
 * @author wuqia
 * @date 2022-07-12 21:04
 **/
public class Test {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int num = 0;
        int[] arr = new int[]{0, 2, 2, 2, 3, 4, 5};

        int left = 0;
        int right = arr.length - 1;
        int n = 0;
        while (true) {
            n = (right - left) / 2 + left;
            if (arr[n] == num) {
                while (true) {
                    if (arr[n] != num) {
                        System.out.println(n + 1);
                        return;
                    }
                    n--;
                }
            } else if (arr[n] < num) {
                left = n;
            } else {
                right = n;
            }
        }
    }
}
