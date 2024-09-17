package Selenium.SeleniumPractice;
public class Main{
	public static void main(String[]args) {
		String a = "Ram is a good boy";
		String b[] = a.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<b.length;i++) {
	String c =	 b[i];
	for(int j =c.length()-1;j>=0;j--) {
		sb.append(c.charAt(j));
	}
	sb.append(" ");
		}
	System.out.println( sb.toString().trim());
	}
}