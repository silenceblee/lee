package lottery.subsriber;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import lottery.logic.CheckEnvent;

public class CodeTest extends JFrame {
	private static final long serialVersionUID = 1L;
	/** 输入的序列号 **/
	private JFormattedTextField formatField = null;
	private JButton ba = null;
	private JLabel code = new JLabel("注册码: ");
	private JLabel input = new JLabel("序列号: ");
	/** 得到的注册码 **/
	private JTextField codeField = new JTextField();
	private JLabel rel = new JLabel();

//	public CodeTest() {
//		init();
//	}

	public void init() {
		formatField = new JFormattedTextField();
		this.setTitle("用户注册");
		this.setBounds(200, 200, 340, 240);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formatField.setBounds(30, 30, 280, 25);
		ba = new JButton("确定");
		ba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (formatField.getText().length() >= 1) {
				}
				//序列号
				String serial = formatField.getText();
				//注册码
				String registration = codeField.getText();
				/*用给定的序列号来生成注册码
				*给定的序列号和注册码是缴费后从软件开发作者那里获取的
				*而这里的生成注册码方式和软件作者那里的生成注册码方式是一样的
				*因此只需要保持序列号一样，那么生成的注册码也是一样
				*/
				if(serial == null || "".equals(serial.trim())){
					rel.setText("请输入序列号");
				}else{
					// 后面的参数是一个数字类型的字符串,数字范围为0-999
					String subscription_Code = new SubsriberCode().getSerial(serial, "1"); 
					//如果页面传过来的注册码，和系统生成的注册码相同
					//则返回成功，否则提示错误
					if(registration != null && subscription_Code != null){
						if(registration.trim().equals(subscription_Code.trim())){
							String path = "C:"+File.separator+"code";
							File file = new File(path+File.separator+"code.txt");
							File filePath = new File(path);
							BufferedWriter out = null;
							try {
								filePath.mkdirs();
								file.createNewFile();
								out = new BufferedWriter(new FileWriter(file));
								out.write("xxx8>yyy"+MacUtils.getMacSubseri());
							} catch (IOException ee) {
								ee.printStackTrace();
							}finally{
								try {
									if(out != null){
										out.flush();
										out.close();
									}
								} catch (IOException ee) {
									ee.printStackTrace();
								}
							}
							new CheckEnvent();
						}else{
							rel.setText("注册码错误");
						}
					}
				}
			}
		});
		codeField.setBounds(30, 85, 280, 25);
		code.setBounds(30, 60, 280, 25);
		ba.setBounds(30, 125, 280, 25);
		rel.setBounds(30, 155, 200, 25);
		input.setForeground(Color.RED);
		code.setForeground(Color.RED);
		rel.setForeground(Color.RED);
		input.setBounds(30, 5, 200, 25);
		this.add(rel);
		this.add(codeField);
		this.add(input);
		this.add(code);
		this.add(ba);
		this.add(formatField);
		ba.setDefaultCapable(true);
		this.setVisible(true);
	}

	public static MaskFormatter getFormatter(String pattern) {
		try {
			return new MaskFormatter(pattern);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public long getCode(String text) {
		char[] chs = text.toCharArray();
		long vlong = 0;
		for (char c : chs) {
			if (c != '-') {
				vlong += 199 * (int) c;
			}
		}
		return vlong;
	}
	public static void main(String[] args) {
//		codeTest.init();
//		String path = System.getProperty("user.dir");
//		path = path + File.separator + "src" + File.separator + "lee" + File.separator + "subsriber" + File.separator;
		String path = "C:"+File.separator+"code";
		System.out.println(path);
		File file = new File(path+File.separator+"code.txt");
		boolean isUniq = false;
		if(file.exists()){
			BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(file));
				String str = new String();
				if((str = in.readLine())!= null){
					int op = str.indexOf(">");
					if(op > 0){
						String hong = str.substring(0,op);
						String mac = str.substring(op+1,str.length());
						if("xxx8".equals(hong)){
							if(mac != null && mac.equals("yyy"+MacUtils.getMacSubseri())){
								 isUniq = true;
								 new CheckEnvent();
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(in != null){
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(!isUniq){
			CodeTest codeTest = new CodeTest();
			codeTest.init();
		}
	}
}
