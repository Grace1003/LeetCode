// Implement pow(x, n).

public class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            if(n == Integer.MIN_VALUE){   // 注意最小整数的绝对值大于最大整数
                return (1 / myPow(x, Integer.MAX_VALUE)) / x;
            }
            return 1 / myPow(x, -n);
        }else if(n == 0){   // 不单独列举出来会导致死循环而栈溢出
            return 1;
        }else if(n == 1){   // 不单独列举出来会导致死循环而栈溢出
            return x;
        }
        
        double res1 = myPow(x, n / 2);
        double res2 = myPow(x, n % 2);

        return res1 * res1 * res2;
    }
}

// 二分法，把指数n分解成n=2*a+b 即n=a+a+b
// 注意指数的加减法相当于幂的乘除法，递归的时候返回的是myPow(x,a)*myPow(x,a)*myPow(x,b)