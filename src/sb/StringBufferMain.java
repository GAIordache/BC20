package sb;

public class StringBufferMain {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(4096);
		sb.append("Ceva");
		for(int i=0;i < 1000;i++) {
			sb.append(i);
		}
		System.out.println(sb.toString());
	}

}
