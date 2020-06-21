package Algorithm;

/**
 *分治算法 
 * 永远可以看成两三个步骤，把所有盘看成两个盘
 * 一个是最下面的盘，另一个是上面左右盘组成的集合
 * 1，将A上面的盘移动至B
 * 2, 将A下面的盘移动到C
 * 3, 将B所有盘移动到C
 * 
 * @author 96916
 *
 */
public class 汉诺塔 {
	public static void main(String[] args) {
		hanoiTower(4, 'A','B', 'C');
	}
	//使用分治算法
	// a b c分别代表盘号
	public static void hanoiTower(int num, char a, char b, char c) {
		if (num == 1) {
			System.out.println("第1个盘从"+a+"->"+c);
		}else {
			//如果我们有n >= 2情况，我们总是可以看做是两个盘：1.最下边的一个盘2.上 面的所有盘
			//先把上面的盘从A->B,从a -> b,过程使用到c塔
			hanoiTower(num-1, a, c, b);
			//把下面的盘移动到A->C
			System.out.println("第"+num+"个盘从"+a+"->"+c);
			//把B塔的所有盘从B->C,过程使用到a塔
			hanoiTower(num - 1, b, a, c);
		}
	}
	
}
