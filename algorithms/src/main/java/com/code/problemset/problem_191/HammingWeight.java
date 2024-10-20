package com.code.problemset.problem_191;

public class HammingWeight {

    /**
     * 遍历32次，判断每一位是否为1
     */
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }


    /**
     * n & (n - 1)清零最低位的1
     */
    public int hammingWeightV2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
