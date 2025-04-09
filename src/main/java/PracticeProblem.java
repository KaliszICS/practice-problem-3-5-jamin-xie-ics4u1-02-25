public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] stringArr) {
		int col = 0;
		int row = stringArr.length - 1;

		int moves = 0;
		int result = searchMazeMovesHelper(stringArr, row, col, moves);

		if (result == Integer.MAX_VALUE) {
			return -1;
		} else {
			return result;
		}
	}

	public static int searchMazeMovesHelper(String[][] stringArr, int row, int col, int moves) {
		int cols = stringArr[0].length;
		int rows = stringArr.length;

		if (row < 0 || row >= rows || col < 0 || col >= cols) {
			return Integer.MAX_VALUE;
		}

		if (stringArr[row][col].equals("F")) {
			return moves;
		}

		int up = searchMazeMovesHelper(stringArr, row - 1, col, moves + 1);
		int right = searchMazeMovesHelper(stringArr, row, col + 1, moves + 1);

		int min = Math.min(right, up);

		return min;
	}

	public static int noOfPaths(String[][] pathArr) {
		int col = 0;
		int row = pathArr.length - 1;

		return noOfPathsHelper(pathArr, row, col);
	}

	public static int noOfPathsHelper(String[][] pathArr, int row, int col) {
		int cols = pathArr[0].length;
		int rows = pathArr.length;

		if (row < 0 || row >= rows || col < 0 || col >= cols) {
			return 0;
		}
		
		if (pathArr[row][col].equals("F")) {
			return 1;
		}

		int right = noOfPathsHelper(pathArr, row, col + 1);
		int up = noOfPathsHelper(pathArr, row - 1, col);
		return up + right;
	}
	

}
