public class Star {
    private int count;
	
	public Star(int cnt) {
		this.count = cnt;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= count; i++) {
			for(int j = 1; j <= i; j++) {
			    sb.append("[*]");
			}
			if(i < count) sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Star small = new Star(3);
		System.out.println(small.toString());
	}
}
