package lottery.subsriber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * 获取硬盘编号
 * <p>
 * 
 * @author DuanQingwei @date 2013-3-5<br>
 * @version 1.0<br>
 */
public class DiskUtils {
	private DiskUtils() {
	}

	public static String getSerialNumber(String drive) {
		String result = "";
		try {
			File file = File.createTempFile("damn", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new java.io.FileWriter(file);
			String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
					+ "Set colDrives = objFSO.Drives\n"
					+ "Set objDrive = colDrives.item(\""
					+ drive
					+ "\")\n"
					+ "Wscript.Echo objDrive.SerialNumber"; // see note
			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec(
					"cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.trim();
	}

	public static void main(String[] args) {
		new DiskUtils();
		System.out.println(DiskUtils.getSerialNumber("F"));
	}
}
