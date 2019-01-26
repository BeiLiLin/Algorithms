package basic34.class_03;
/*
“之”字形打印矩阵
【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这
个矩阵，例如： 1 2 3 4 5 6 7 8 9 10 11 12
“之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，
8，12
【要求】 额外空间复杂度为O(1)。
 */
public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = 0;
		int dC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean fromUp = false;
		while (tR != endR + 1) {
			printLevel(matrix, tR, tC, dR, dC, fromUp);
			tR = tC == endC ? tR + 1 : tR;//A点往右走的点是否到达右边界，到达则往下走。t的ROW行数加一
            tC = tC == endC ? tC : tC + 1;//A点往右走的点是否到达右边界，不到达则往右走。t的column列数加一
            dC = dR == endR ? dC + 1 : dC;//B点往下走达到下边界，B点往右走，column加一
            dR = dR == endR ? dR : dR + 1;////B点往下走没达到下边界，B点往下走，ROW加一
            fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
			boolean f) {
		if (f) {//向下打印
			while (tR != dR + 1) {//没有到达下边界进入循环
				System.out.print(m[tR++][tC--] + " ");
			}
		} else {//向上打印
			while (dR != tR - 1) {//没有到达上边界进入循环
				System.out.print(m[dR--][dC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
