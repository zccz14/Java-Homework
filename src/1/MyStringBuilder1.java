public class MyStringBuilder1{
	private char[] str;
	public MyStringBuilder1(){
		str = new char[0];
	}
	public MyStringBuilder1(String s){
		str = s.toCharArray();
	}
	public int length(){
		return str.length;
	}
	public char charAt(int index){
		return str[index];
	}
	public String toString(){
		return String.valueOf(str);
	}
	public MyStringBuilder1 append(MyStringBuilder1 s){
		int len = length(),lens=s.length();
		char[] res = new char[len+lens];
		for(int i=0;i<len;i++)
			res[i]=str[i];
		for(int i=0;i<lens;i++)
			res[i+len]=s.charAt(i);
		str = res;
		return this;
	}
	public MyStringBuilder1 append(int i){
		return append(new MyStringBuilder1(String.valueOf(i)));
	}
	public MyStringBuilder1 toLowerCase(){
		for(int i=0;i<str.length;i++)
			if(str[i]>='A' && str[i]<='Z')
				str[i]+=32;
		return this;
	}
	public MyStringBuilder1 substring(int begin, int end){
		int lenr = end - begin + 1;
		char[] res = new char[lenr];
		for(int i=begin;i<=end;i++)
			res[i-begin]=str[i];
		return new MyStringBuilder1(String.valueOf(res));
	}
	public static void main(String[] args){
		MyStringBuilder1 S = new MyStringBuilder1("CZ");
		System.out.println(S.toString() + " " + S.length()+ " "+ S.charAt(1));
		S.append(new MyStringBuilder1("one"));
		System.out.println(S.toString() + " " + S.length());
		S.append(123);
		System.out.println(S.toString() + " " + S.length());
		S.toLowerCase();
		System.out.println(S.toString() + " " + S.length());
		MyStringBuilder1 S1= S.substring(3,5);
		System.out.println(S1.toString() + " " + S1.length());
	}
}