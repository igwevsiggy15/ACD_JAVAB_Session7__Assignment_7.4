package Assignment7_4;

import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String s = "";
		
		boolean repeat = false;
		while (true) {
			if (!repeat) {
				System.out.print("Enter string: ");
			} else {
				System.out.println("Press enter again to exit.");
			}
			s = sc.nextLine();
			if (s.length() == 0) {
				if (repeat) {
					break;
				} else {
					repeat = true;
				}
			} else {
				repeat = false;
				s.trim();
				String[] arr = s.split(", ");
				for(String a: arr) {
					String[] let = a.toLowerCase().split("");
					sort(let, let.length);
					String key = "";
					for (String l: let) {
						key += l;
					}
					int i = sb.indexOf(key);
					if (i > -1) {
						if (sb.indexOf(a) > -1);
						else
							sb.insert(i+key.length()+3, a + ", ");
					} else {
						sb.append(":" +key+":{ " + a + " }");
					}
				}
				s = sb.toString();
				s = s.trim();
				s = s.replaceAll(":[a-zA-z]+:", "");
				s = s.replaceAll("\\{ [a-zA-z]+ \\}", "");
				System.out.println(s);
				sb.replace(0, sb.length(), "");
			}
		}
		sc.close();
	}
	
	static void sort(String[] arr, int size) {
		if (size == 0 || size == 1 || arr == null) return;
		int c = arr.length - size;
		int position = -1;
		String min = null;
		for (int i = 0; i < size; i++) {
			if (min == null || arr[c+i].compareToIgnoreCase(min) < 0) {
				min = arr[c+i];
				position = c+i;
			}
		}
		if (position < 0) return;
		String tmp = arr[c];
		arr[c] = arr[position];
		arr[position] = tmp;
		sort(arr, size-1);
	}
}