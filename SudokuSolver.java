//L3 - Sudoku Solver

import java.util.*;

class SudokuSolver{
	static List<HashMap<Integer,boolean[]>> maplist = new ArrayList<>();
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		char[][] sudoku = new char[9][9];
		for(int i = 0;i < 9;i++){
			String line = sc.nextLine();
			for(int j = 0;j < 9;j++)
				sudoku[i][j] = line.charAt(j);
		}
						
		boolean solved = solveSudoku(sudoku);
		if(solved){
			System.out.println("\n________________________\n");
			for(int i = 0;i < 9;i++){
				for(int j = 0;j < 9;j++)
					System.out.print(sudoku[i][j]);
				System.out.println();
			}
		}else System.out.println("no solution found.");
	}
	static boolean solveSudoku(char[][] board){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(board[i][j] == '.'){
					for(char num = '1'; num <= '9'; num++){
						if(isValid(board, i, j, num)){
							board[i][j] = num;
							if(solveSudoku(board)){
								return true;
							}
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	static boolean isValid(char[][] board, int row, int col, char num){
		for(int i = 0; i < 9; i++){
			if(board[row][i] == num){
				return false;
			}
		}
		for(int j = 0; j < 9; j++){
			if(board[j][col] == num){
				return false;
			}
		}

		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;
		for(int i = startRow; i < startRow + 3; i++){
			for(int j = startCol; j < startCol + 3; j++){
				if(board[i][j] == num){
					return false;
				}
			}
		}
		return true;
	}
}