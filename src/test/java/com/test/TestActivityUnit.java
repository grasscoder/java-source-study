package com.test;

import java.util.Arrays;
import java.util.Scanner;

/*
*
* */
public class TestActivityUnit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] status = Arrays.stream(sc.nextLine().replace("\\n","").split(" "))
                .mapToInt(Integer::valueOf).toArray();
        int days = sc.nextInt();
        int length = status.length;
        for(int i = 1; i <= days; i++) {
            int[] newStatus = new int[length];
            for (int k = 0; k < length; k++) {
                if(k == 0 && status[k + 1] == 0) {
                    newStatus[k] = 0;
                    continue;
                } else if (k == 0 && status[k + 1] == 1) {
                    newStatus[k] = 1;
                    continue;
                }
                if(k == length - 1 && status[k - 1] == 0) {
                    newStatus[k] = 0;
                    continue;
                } else if (k == length - 1 && status[k - 1] == 0) {
                    newStatus[k] = 1;
                    continue;
                }
                if((status[k-1] == 0 && status[k+1] == 0) || (status[k-1] == 1 && status[k+1] == 1)){
                    newStatus[k] = 0;
                } else {
                    newStatus[k] = 1;
                }
            }
            status = newStatus;
        }
        System.out.println(Arrays.toString(status));
    }
}
//  0 [1 0 1 0 0 1 0 1] 0
//     0 0 0 1 1 0 0 0
//     0 0 1 1 1 1 0 0
