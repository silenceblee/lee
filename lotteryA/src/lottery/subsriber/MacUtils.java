package lottery.subsriber;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * 获取MAC地址
 * <p>
 * 
 * @author DuanQingwei @date 2013-3-5<br>
 * @version 1.0<br>
 */
public class MacUtils {
	public static String getMac() {
		try {

			Process process = Runtime.getRuntime().exec("ipconfig /all");

			InputStreamReader ir = new InputStreamReader(
					process.getInputStream(),"gb2312");

			LineNumberReader input = new LineNumberReader(ir);

			String line;

			while ((line = input.readLine()) != null){

				if (line.indexOf("Physical Address") > 0 || line.indexOf("物理地址") > 0) {
					int num = line.indexOf("-");
					if(num >=2 ){
						String macAddr = line.substring( num - 2);
						if(!macAddr.contains("00-00-00-00-00-00-00-E0") && !macAddr.contains("00-00-00-00-00-00-00-00"))
						return macAddr;
					}
				}
			}

		} catch (java.io.IOException e) {

			System.err.println("IOException " + e.getMessage());

		}
		return null;
	}

	public static String getMacSubseri(){
		String mac = getMac();
		if(mac != null && !"".equals(mac)){
			mac = mac.replaceAll("-", "");
			mac = mac + decode(mac);
			return change(mac);
		}
		return null;
	}
	/**
	 * 
	 * 变化原则是 把数字（10个）或者字母表（大小写个26个）折半对调（两个相互改变） 0与5对调（0变5 ，5变0） A与N，a与n对调
	 * 
	 * @param 原字符串
	 * @return 变化后的字符串
	 */
	private static String change(String s) {
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
	
	private static int decode(String s) {
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
}
