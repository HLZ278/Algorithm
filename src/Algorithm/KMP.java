package Algorithm;

import java.util.Arrays;

import javax.xml.soap.Text;

public class KMP {
	public static void main(String[] args) {
		String s1 = "bbc abcdab abcdabcdabcde";
		String s2 = "abcdabcd";
		int violenceMatch = Match.violenceMatch(s1, s2);
		System.out.println(violenceMatch);
		int[] next = Match.kmpNext(s2);
		int index = Match.kmpSearch(s1, s2, next);
		System.out.println(Arrays.toString(next));
		System.out.println(index);
		
	}
}

class Match {

	public static int kmpSearch(String str1, String str2, int[] next) {
		// 遍历
		int j = 0;
		int i = 0;
		while (i < str1.length()) {
			if (j == str2.length()-1 && str1.charAt(i) == str2.charAt(j) ) {
				return i - j;
				//j = next[j];需要找多个匹配的地方
			}
			if (str1.charAt(i) == str2.charAt(j)) {
				i++;
				j++;
			}else {
				j = next[j];
				if (j == -1) {
					i++;
					j++;
				}
			}
		}
		return -1;

	}

	/**
	 * @param dest 要匹配的子字符串
	 * @return
	 */
	public static int[] kmpNext(String dest) {
		// 创建next数组保存部分匹配值
		int[] next = new int[dest.length()];
		next[0] = 0;
		// 记录匹配到公共前后缀长度
		int len = 0;
		int i = 1;
		while (i < dest.length()) {
			if (dest.charAt(i) == dest.charAt(len)) {
				len++;
				next[i] = len;
				i++;
			} else {
				if (len > 0) {
					len = next[len - 1];
				} else {
					next[i] = len;
					i++;
				}
			}
		}
		for (int j = next.length - 1; j > 0; j--) {
			next[j] = next[j - 1];
		}
		next[0] = -1;
		return next;
	}

	public static int violenceMatch(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int s1len = s1.length;
		int s2len = s2.length;
		int i = 0, j = 0;// i索引指向s1 j指向s2
		while (i < s1len && j < s2len) {// 匹配不越界
			if (s1[i] == s2[j]) {
				i++;
				j++;
			} else {
				i = i - (j - 1);// 指向下一个字符，别多想暴力算法就移动一个位置而已
				j = 0;
			}
		}
		if (j == s2len) {
			return i - j;
		} else {
			return -1;
		}
	}
}