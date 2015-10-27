//Title  : Pattern recognition: consecutive four equal numbers #2
//Author : Heley Chen
import java.util.Scanner;
public class Pattern{
	public static void main(String[] args){
		int[][] values = scanValues();
		System.out.println(isConsecutiveFour(values));
	}
	private static int[][] scanValues(){
		Scanner in = new Scanner (System.in);
		//输入m,n
		System.out.println("Please input the numbers of rows");
		int m=in.nextInt();
		System.out.println("Please input the numbers of columns");
		int n=in.nextInt();
		//申请二维数组空间
		int[][] values=new int[m][n];
		System.out.println("Please input a(n) " + m + "*" + n + " Matrix");
		//读入数组
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				values[i][j]=in.nextInt();
		return values;
	}
	// 判断方法
	public static boolean isConsecutiveFour(int[][] values){
		int m = values.length;
		int n = values[0].length;
		//常量数组 代表四个行进方向
		int[] X={1,1,1,0};
		int[] Y={1,0,-1,1};
		//遍历矩阵 特定的遍历顺序可以节省检查方向的数目
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				for(int k=0;k<4;k++)
					for(int l=1;l<4;l++){
						//对于矩阵上的某一元素它可以向k方向走l格 此时它的坐标是(px,py)
						int px=i+X[k]*l,py=j+Y[k]*l;
						//如果(px,py)越界了或者其位置的值于中心值不等 则跳到下一个方向检查
						if(isOverRange(px,py,values) || values[i][j]!=values[px][py]) break;
						//如果一直符合条件达到l==3 则说明存在这个方向上连续3个元素与中心元素相等 即四连星存在。
						if(l==3) return true;
					}
		//非true即false
		return false;
	}
	private static boolean isOverRange(int x,int y,int[][] values){
		//当x<0 或 y<0 或 x>=m 或 y>=n 时视为越界。
		return x<0 || y<0 || x>=values.length || y>=values[0].length;
	}
}