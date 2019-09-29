package com.lijie;

public class Main {
	/* 斐波那鍥数(下一个数是前两个数相加的结果, 公式: n = (n - 1) + (n - 2), n 代表序列,并非数值)
	 * 0,1,1,2,3,5,8,13,21,...
	 */	
	
	//TODO: 解法一 递归解法(此解法有严重的性能问题, 如果  n 过大, 会迟迟没有结果)
	public static int fib(int n) {
		if (n <= 1) {  ///当n 为 0 或者 1 的时候  n-1 和 n-2 一直是 0 ,造成死循环, 所以  n 为 0 或者 1 直接返回,只有n-1 和 n-2 都存在的时候再一直递归
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
	
	//TODO: 解法二  (几乎是妙算, 性能优越)
	public static int fibFor(int n) {
		if (n <= 1) { 
			return n;
		}	
		///因为 n = 0 时 对应的值是 0, n = 1 时 对应的值是 1 , 所以可以直接得出 下面的 n - 1 和 n - 2 的值
		int first = 0; //代表的是具体的值
		int second = 1;
		//因为是前一个和后一个相加才能得到n所对应的值, 所以想要相加 n - 1 次
		for (int i = 0; i < n - 1; i++) {
			int sum = first + second; //在改变 first 和 second 之前 对他们进行相加, 则是下一次循环的 second(n-1), 
			first = second;  //当前循环的 second(n - 1)是下一次循环的 first (n - 2)
			second = sum;
		}
		return second;
	}
	
	//入口函数
	public static void main(String[] args) {
		System.out.println(fib(64));
	}
	
}
