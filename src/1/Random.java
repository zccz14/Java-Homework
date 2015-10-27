//Title  : Random number chooser #3
//Author : Heley Chen 
public class Random{
	public static void main(String[] args){
		//Example Call
		System.out.println(getRandom(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53));
	}
	private static int getRandom(int... numbers){
		//标记删除数组
		boolean[] deleted = new boolean[54];
		//记录不重复的删除个数
		int count = 0;
		//不重复地对数组贴标签
		for(int num : numbers)
			if(num > 0 && num < 55 && !deleted[num-1]){
				deleted[num-1] = true;
				count++;
			}
		//随机生成数据
		int x = (int)(Math.random()*(54-count)+1);
		//获得未被删除的索引为x的元素
		for(int i=0;i<54;i++){
			if(deleted[i]) continue;
			if(--x==0) return i+1;
		}
		//I asserted it won't happened.
		//There's unexpected error happened, if the function return 0
		return 0;
	}
}