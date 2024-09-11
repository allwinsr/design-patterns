/**
 * 
 */
package com.allwin.ds;

/**
 * @author allwin.s Date 08-Aug-2020
 * 
 *         https://www.youtube.com/watch?v=vYYNp0Jrdv0
 */
public class WordSearch {

	public static void main(String[] args) {
		WordSearch search = new WordSearch();
		System.out.println("God is great!!!");

		char[][] table = { { 'a', 'b', 'c', 'e' }, { 's', 'f', 'c', 's' }, { 'a', 'd', 'e', 'e' } };
		String word = "see";
		//word = "abfdeee";
		printTable(table);

		System.out.println("Contains word '" + word + "' ?" + search.exists(table, word));
	}

	/**
	 * @param table
	 * @param word
	 * @return
	 */
	private boolean exists(char[][] table, String word) {

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (table[i][j] == word.charAt(0) && dfs(table, word, i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * @param table
	 * @param word
	 * @param i
	 * @param j
	 * @param k
	 * @return
	 */
	private boolean dfs(char[][] table, String word, int i, int j, int k) {
		if (k == word.length()) {
			return true;
		}

		if (i < 0 || j < 0 || i >= table.length || j >= table[0].length || table[i][j] != word.charAt(k)) {
			return false;
		}

		char temp = table[i][j];
		table[i][j] = ' ';

		boolean hasFound = dfs(table, word, i, j + 1, k + 1) || dfs(table, word, i + 1, j, k + 1)
				|| dfs(table, word, i - 1, j, k + 1) || dfs(table, word, i, j - 1, k + 1);
		table[i][j] = temp;
		return hasFound;
	}

	/**
	 * @param table
	 */
	private static void printTable(char[][] table) {

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println("");
		}
	}
}
