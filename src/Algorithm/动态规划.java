package Algorithm;

import java.lang.reflect.WildcardType;

//背包问题
//
public class 动态规划 {
	public static void main(String[] args) {
		// 物品重量
		int[] w = { 1, 4, 3 };
		// 物品价值
		int[] val = { 1500, 3000, 2000 };
		int m = 4;// 背包容量
		// 物品个数
		int n = val.length;
		// 定义一个二维数组,存放背包物品
		int[][] path = new int[n + 1][m + 1];

		// 创建二维数组
		// v[i][j]表示能装入东西的最大价值
		// 行代表可放物品，列代表最大容量
		int[][] v = new int[n + 1][m + 1];
		// 初始化第一行第一列
		for (int i = 0; i < v.length; i++) {
			v[i][0] = 0;
		}
		for (int i = 0; i < v[0].length; i++) {
			v[0][i] = 0;
		}

		// 算法开始
		for (int i = 1; i < v.length; i++) {
			for (int j = 1; j < v[0].length; j++) {
				if (w[i - 1] > j) {
					v[i][j] = v[i - 1][j];
				} else {
					// 说明:
					// 因为我们的i从1开始的，因此公式需要调整成
					// v[i][j]=Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
					// v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
					// 为了记录商品存放到背包的情况，我们不能简单的使用上面的公式，需要使用if-else
					if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
						v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
						path[i][j] = 1;
					} else {
						v[i][j] = v[i - 1][j];
					}
				}
			}
		}

		// 输出v
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
		// 动脑筋
		int i = path.length - 1; // 行的最大下标
		int j = path[0].length - 1; // 列的最大下标
		while (i > 0 && j > 0) { // 从path的最后开始找
			if (path[i][j] == 1) {
				System.out.printf("第%d个商品放入到背包\n", i);
				j -= w[i - 1]; // w[i-1]
			}
			i--;
		}

	}
}

class KnapsackProblem {

}