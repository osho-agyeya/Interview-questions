package main_solution;

import java.io.*;
import leetcode.*;
import java.util.*;
import java.util.stream.Collectors;

import javax.print.attribute.HashAttributeSet;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputReader ii = new InputReader(System.in);
		;
		OutputWriter pp = new OutputWriter(System.out);

		// Longest_Palindromic_Subsequence o= new Longest_Palindromic_Subsequence();
		// pp.ptn(o.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0).toString());
		// o.longestPalindromeSubseq("cbbd");
		// pp.ptn(garden(new int[] {1, 2, 1, 4, 2, 5}, 6));
		//pp.ptn("1234".substring(1,1));
		
		
		
		
		
		
		
		
		
		

	}
	
	
	static int garden(int arr[], int N) {
		List<Integer> arrl = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
		if (isPleasant(arrl, N))
			return 0;
		int c = 0;
		for (int i = 0; i < N; i++) {
			arrl.remove(i);
			if (isPleasant(arrl, N - 1))
				c++;
			arrl.add(i, arr[i]);
		}
		return (c == 0) ? -1 : c;

	}

	static boolean isPleasant(List<Integer> arr, int N) {
		for (int i = 1; i < N - 1; i++) {
			if ((arr.get(i - 1) <= arr.get(i) && arr.get(i) <= arr.get(i + 1))
					|| (arr.get(i - 1) >= arr.get(i) && arr.get(i) >= arr.get(i + 1)))
				return false;
		}
		return true;
	}

	static class InputReader {

		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;

		public InputReader(InputStream st) {
			this.stream = st;
		}

		public int read() {
			if (snumChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		/*
		 * next integer
		 */
		public int ni() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		/*
		 * next long
		 */
		public long nl() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		/*
		 * next double
		 */
		public double nd() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, ni());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, ni());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}

		/*
		 * next single string
		 */
		public String ns() { // single string
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		/*
		 * next entire sentences or group of lines
		 */
		public String nli() { // one entire sentence
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		/*
		 * next boolean
		 */
		public boolean nb() {
			return Boolean.parseBoolean(ns());
		}

		/*
		 * next integer array
		 */
		public int[] nia(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = ni();
			}
			return a;
		}

		/*
		 * next double array
		 */
		public double[] nda(int n) {
			double a[] = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nd();
			}
			return a;
		}

		/*
		 * next long array
		 */
		public long[] nla(int n) {
			long a[] = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nl();
			}
			return a;

		}

		/*
		 * next boolean array
		 */
		public boolean[] nba(int n) {
			boolean a[] = new boolean[n];
			for (int i = 0; i < n; i++) {
				a[i] = nb();
			}
			return a;
		}

		/*
		 * next single string array
		 */
		public String[] nsa(int n) {
			String a[] = new String[n];
			for (int i = 0; i < n; i++) {
				a[i] = ns();
			}
			return a;
		}

		/*
		 * next array of sentences
		 */
		public String[] nlia(int n) {
			String a[] = new String[n];
			for (int i = 0; i < n; i++) {
				a[i] = nli();
			}
			return a;
		}

		/*
		 * next integer matrix
		 */
		public int[][] nim(int m, int n) {
			int a[][] = new int[n][m];
			for (int i = 0; i < m; i++) {
				a[i] = nia(n);
			}
			return a;
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

	}

	static class OutputWriter {

		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		/*
		 * only print single value
		 */
		public void pt(Object object) {
			writer.print(object);
			writer.flush();
		}

		/*
		 * print single value and new line
		 */
		public void ptn(Object object) {
			pt(object);
			writer.println();
			writer.flush();
		}

		public void pta(char ch, Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(ch);
				}
				writer.print(objects[i]);
			}
			writer.println();
			writer.flush();
		}

		/*
		 * print horizontally integer array
		 */
		public void pth(int[] arr) {
			pta(' ', Arrays.stream(arr).boxed().toArray(Object[]::new));
		}

		/*
		 * print horizontally double array
		 */
		public void pth(double[] arr) {
			pta(' ', Arrays.stream(arr).boxed().toArray(Object[]::new));
		}

		/*
		 * print horizontally long array
		 */
		public void pth(long[] arr) {
			pta(' ', Arrays.stream(arr).boxed().toArray(Object[]::new));
		}

		/*
		 * print vertically integer array
		 */
		public void ptv(int[] arr) {
			pta('\n', Arrays.stream(arr).boxed().toArray(Object[]::new));
		}

		/*
		 * print vertically long array
		 */
		public void ptv(long[] arr) {
			pta('\n', Arrays.stream(arr).boxed().toArray(Object[]::new));
		}

		/*
		 * print vertically double array
		 */
		public void ptv(double[] arr) {
			pta('\n', Arrays.stream(arr).boxed().toArray(Object[]::new));
		}

		/*
		 * print integer matrix
		 */
		public void pim(int arr[][]) {
			for (int[] arr1 : arr) {
				pth(arr1);
			}
		}

		public void close() {
			writer.close();
		}

		public void flush() {
			writer.flush();
		}
	}
}