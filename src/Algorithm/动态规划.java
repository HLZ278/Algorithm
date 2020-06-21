package Algorithm;

import java.lang.reflect.WildcardType;

//��������
//
public class ��̬�滮 {
	public static void main(String[] args) {
		// ��Ʒ����
		int[] w = { 1, 4, 3 };
		// ��Ʒ��ֵ
		int[] val = { 1500, 3000, 2000 };
		int m = 4;// ��������
		// ��Ʒ����
		int n = val.length;
		// ����һ����ά����,��ű�����Ʒ
		int[][] path = new int[n + 1][m + 1];

		// ������ά����
		// v[i][j]��ʾ��װ�붫��������ֵ
		// �д���ɷ���Ʒ���д����������
		int[][] v = new int[n + 1][m + 1];
		// ��ʼ����һ�е�һ��
		for (int i = 0; i < v.length; i++) {
			v[i][0] = 0;
		}
		for (int i = 0; i < v[0].length; i++) {
			v[0][i] = 0;
		}

		// �㷨��ʼ
		for (int i = 1; i < v.length; i++) {
			for (int j = 1; j < v[0].length; j++) {
				if (w[i - 1] > j) {
					v[i][j] = v[i - 1][j];
				} else {
					// ˵��:
					// ��Ϊ���ǵ�i��1��ʼ�ģ���˹�ʽ��Ҫ������
					// v[i][j]=Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
					// v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
					// Ϊ�˼�¼��Ʒ��ŵ���������������ǲ��ܼ򵥵�ʹ������Ĺ�ʽ����Ҫʹ��if-else
					if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
						v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
						path[i][j] = 1;
					} else {
						v[i][j] = v[i - 1][j];
					}
				}
			}
		}

		// ���v
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
		// ���Խ�
		int i = path.length - 1; // �е�����±�
		int j = path[0].length - 1; // �е�����±�
		while (i > 0 && j > 0) { // ��path�����ʼ��
			if (path[i][j] == 1) {
				System.out.printf("��%d����Ʒ���뵽����\n", i);
				j -= w[i - 1]; // w[i-1]
			}
			i--;
		}

	}
}

class KnapsackProblem {

}