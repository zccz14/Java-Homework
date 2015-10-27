//Title : Game : connect four
//Author : Heley Chen
import java.util.Scanner;
public class Game{
	private static void printBoard(char[][] board){
		for(int i=0,rows=board.length;i<rows;i++){
			for(int j=0,cols=board[i].length;j<cols;j++)
				System.out.print("|"+board[i][j]);
			System.out.println("|");
		}
		System.out.println("----------------------");
	}
	private static char[][] newGame(int m,int n){
		char[][] board = new char[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				board[i][j]=' ';
		return board;
	}
	
	private static int[] X={1,1,1,0,-1,-1,-1,0};
	private static int[] Y={1,0,-1,1,-1,0,1,-1};
	private static boolean isGameOver(int x,int y,char[][] board){
		int[] cnt = new int[8];
		for(int k=0;k<8;k++)
			for(int l=1;l<4;l++){
				int px = x+X[k]*l,py = y+Y[k]*l;
				if(isOverRange(px,py,board) || board[x][y]!=board[px][py]) break;
				cnt[k]++;
			}
		for(int i=0;i<4;i++)
			if(cnt[i]+cnt[i+4] >= 3) 
				return true;
		return false;
	}
	private static int drop(int playerIndex,int col,char[][] board){
		if(col>=0 && col<board[0].length){
			//从下到上搜索应该摆放的位置
			for(int row=board.length-1;row>=0;row--)
				//如果是空的
				if(board[row][col]==' '){
					board[row][col]=playerSign[playerIndex];
					//落子合法
					return row;
				}
		}
		//不合法的落子
		return -1;
	}
	private static boolean isOverRange(int x,int y,char[][] board){
		return x<0 || y<0 || x>=board.length || y>=board[0].length;
	}
	//映射
	private static String[] player={"red","yellow"};
	private static char[] playerSign={'R','Y'};
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		//初始化
		char[][] board= newGame(6,7);
		printBoard(board);
		//Round round !
		for(int round=0;round<6*7;round++){
			System.out.print("Drop a "+player[round%2]+" disk at column (0-"+(board[0].length-1)+"): ");
			while(true){
				int col=in.nextInt();
				int row=drop(round%2,col,board);
				if(row>=0){
					//legeal drop
					//then I can print the board
					printBoard(board);
					//then check ...
					if(isGameOver(row,col,board)){
						System.out.println("The "+player[round%2]+" player won");
						return;
					}
					break;
				}
				else System.out.println("Illegal Drop! Please redrop.");
			}
		}
		System.out.println("Tie!");
	}
}