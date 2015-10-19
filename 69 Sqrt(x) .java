// Implement int sqrt(int x).
// Compute and return the square root of x.

// 注意返回值是int，返回的是满足res^2<=x的最大res值

public class Solution {
    public int mySqrt(int x) {
        long start = 0;  // input:0
        long end = x;
        while(start + 1 < end){
            long mid= start + (end - start) / 2;
            if(mid * mid == x){  // mid*mid可能越整数界，换成long型之后mid*mid不会越界
                return (int)mid;
            }else if(mid * mid < x){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(end * end == x){    // start <= 根号x <= end
            return (int)end;
        }else{
            return (int)start;
        }
        
    }
}


// 优于O(n)的方法当然是二分法。
// 1. 注意input取得到0，因此start初始取0
// 2. end初始值不用取x/2，易错，应该取x/2+1。而且这样做也只少了一次循环，所以end初始值为x即可
// 3. conquer部分，取值范围start<=根号x<=end，区分end²==x和end²<x