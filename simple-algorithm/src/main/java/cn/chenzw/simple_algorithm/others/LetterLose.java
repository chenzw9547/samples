package cn.chenzw.simple_algorithm.others;

/**
 * 一个数组存储很多英文字母，问：怎么知道26个字母中哪些没有存储？
 * 
 * @author chenzw
 * @date 2017年2月10日
 */
public class LetterLose {

	/**
	 * 此种算法只需要遍历一次英文字母的数组 <br>
	 * 思路: 将每个字母转换成数组的下标，并对出现的次数自增，因为字母是连续的，所以数组项值为0的数组下标值即为未存储的字母
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 待查询的字母数组
		char[] letters = new char[] { 'd', 'e', 'l', 'q', 'z', 'y', 'e', 'c',
				'y', 's', 'w', 'a', 'u' };

		int[] letterCount = new int[26]; // 存储每个字母出现的次数
		for (int i = 0; i < letters.length; i++) {
			// 统计各个字母出现的次数 -> a=97
			letterCount[letters[i] - 97]++;
		}

		for (int i = 0; i < letterCount.length; i++) {
			if (letterCount[i] == 0) {
				System.out.println("未存储的字母:" + (char) (i + 97));
			}
		}

	}
}
