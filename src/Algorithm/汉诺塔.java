package Algorithm;

/**
 *�����㷨 
 * ��Զ���Կ������������裬�������̿���������
 * һ������������̣���һ����������������ɵļ���
 * 1����A��������ƶ���B
 * 2, ��A��������ƶ���C
 * 3, ��B�������ƶ���C
 * 
 * @author 96916
 *
 */
public class ��ŵ�� {
	public static void main(String[] args) {
		hanoiTower(4, 'A','B', 'C');
	}
	//ʹ�÷����㷨
	// a b c�ֱ�����̺�
	public static void hanoiTower(int num, char a, char b, char c) {
		if (num == 1) {
			System.out.println("��1���̴�"+a+"->"+c);
		}else {
			//���������n >= 2������������ǿ��Կ����������̣�1.���±ߵ�һ����2.�� ���������
			//�Ȱ�������̴�A->B,��a -> b,����ʹ�õ�c��
			hanoiTower(num-1, a, c, b);
			//����������ƶ���A->C
			System.out.println("��"+num+"���̴�"+a+"->"+c);
			//��B���������̴�B->C,����ʹ�õ�a��
			hanoiTower(num - 1, b, a, c);
		}
	}
	
}
