/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res = (res << 1) | (n & 1);
            n = n >> 1;
        }
        return res;
    }
}

此题有点类似把一个数字翻转，从最低位到最到位依次取一位加入新数中。
注意：数字翻转中原数字为0即可退出循环，但此题要把所有位数字都要翻转，循环次数固定。


位运算
位与( & )：第一个操作数的的第n位于第二个操作数的第n位如果都是1，那么结果的第n为也为1，否则为0
位或( | )：第一个操作数的的第n位于第二个操作数的第n位 只要有一个是1，那么结果的第n为也为1，否则为0