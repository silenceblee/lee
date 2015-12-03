package lottery.subsriber;
import java.util.Calendar;

public class SubsriberCode {
	private static final String LL = "Decompiling this copyrighted 	software";

	public SubsriberCode() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 具体的Subscription Code生成算法
	 */
	public String getSerial(String subscriber, String licenseNum) {
		// 获得当前日期
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.add(Calendar.YEAR, -9);// -9年
		cal.add(Calendar.DAY_OF_YEAR, 4);// 当前日+4
		java.text.NumberFormat nf = new java.text.DecimalFormat("000");
		// licenseNum格式化成三位数字
		licenseNum = nf.format(Integer.valueOf(licenseNum));
		String verTime = new StringBuilder("-").append(new java.text.SimpleDateFormat("yyMMdd").format(cal.getTime())).append("0").toString();// 日期
		String type = "YE3MP-";
		String need = new StringBuilder(subscriber.substring(0, 1)).append(type).append("300").append(licenseNum).append(verTime).toString();// 初步注册信息
		String dx = new StringBuilder(need).append(LL).append(subscriber).toString();
		int suf = this.decode(dx);// 编码初步注册信息
		String code = new StringBuilder(need).append(String.valueOf(suf)).toString();
		return this.change(code);
	}

	private int decode(String s) {
		int i;
		char[] ac;
		int j;
		int k;
		i = 0;
		ac = s.toCharArray();// 把s转化为单个字符数组
		j = 0;
		k = ac.length;
		while (j < k) {
			i = (31 * i) + ac[j];// 加密算法
			j++;
		}
		return Math.abs(i);// 取绝对值
	}

	/**
	 * 
	 * 变化原则是 把数字（10个）或者字母表（大小写个26个）折半对调（两个相互改变） 0与5对调（0变5 ，5变0） A与N，a与n对调
	 * 
	 * @param 原字符串
	 * @return 变化后的字符串
	 */
	private String change(String s) {
		byte[] abyte0;
		char[] ac = null;
		int i;
		int k;
		int j;
		abyte0 = s.getBytes();
		ac = new char[abyte0.length];
		i = 0;
		k = abyte0.length;
		while (i < k) {
			j = abyte0[i];
			// 0-9,实现01234和56789相应的相互对调，也即0与5对调，1与
			if ((j >= 48) && (j <= 57)) {
				j = (((j - 48) + 5) % 10) + 48;
			} else if ((j >= 65) && (j <= 90)) {// A-Z
				j = (((j - 65) + 13) % 26) + 65;
			} else if ((j >= 97) && (j <= 122)) {// a-z
				j = (((j - 97) + 13) % 26) + 97;
			}
			ac[i] = (char) j;
			i++;
		}
		return String.valueOf(ac);
	}

	/**
	 * 
	 * 主方法，首先调用，产生注册码(Subscription Code)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.print("请输入序列号:");
//		Scanner scanner = new Scanner(System.in);// 输入流
//		String subscriber = scanner.nextLine();// 读下一行字符串
//		SubsriberCode myeclipseKeyGen = new SubsriberCode();// 实例化
//		// 后面的参数是一个数字类型的字符串,数字范围为0-999
//		String subscription_Code = myeclipseKeyGen.getSerial(subscriber, "1");
//		System.out.println("\n" + "福彩3D或快3 注册码生成结果：" + "\n");
//		System.out.println("序列号:" + subscriber);
//		System.out.println("注册码:" + subscription_Code);
	}
}
