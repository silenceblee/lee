package lottery.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lottery.frame.Tools;
import lottery.logic.CheckEnvent;

/**
 * 福彩3D界面<p>
 * @author DuanQingwei  @date 2012-9-19 <br>
 * @version 1.0 <br>
 */
public class Lottery3D_V1_bank extends WindowAdapter{

	/** 主框架 **/
	public  JFrame frame ;
	/** 条件框架 **/
	public  JFrame cdFrame;
	/** 大底panel **/
	public  Panel panel;
	/** 字体样式 **/
	String fontStyle = "Dialog";
	/** 字体粗细 **/
	int fontTck = 0;
	/** 字体大小 **/
	int fontSize = 14;
	/** 背景颜色 **/
	Color color = Color.pink;
	/** 字体样式 **/
	Font font = new Font(fontStyle, fontTck, fontSize);
	/** 和值选择框 **/
	public JCheckBox sumChb = new JCheckBox("和值");
	/** 直选选择框 **/
	public JCheckBox rChb = new JCheckBox("直选");
	/** 组选3选择框 **/
	public JCheckBox rChb3 = new JCheckBox("组3  ");
	/** 组选6选择框 **/
	public JCheckBox rChb6 = new JCheckBox("组6  ");
	/** 和值数组 **/
	public JCheckBox[] sumChbNum = new JCheckBox[28];
	/** 直选数组 **/
	public JLabel[] lb000 = new JLabel[10];
	/** 组3数组 **/
	public JLabel[] lb001 = new JLabel[90];
	/** 组6数组 **/
	public JLabel[] lb012 = new JLabel[120];
	
	//**************************条件区域控件***************************************
	/** 底端panel背景颜色 **/
	Color downColor = new Color(218,165,10);
	Font downFont = new Font(fontStyle, fontTck, 12);
	/** 条件panel **/
	Panel panelDown = new Panel();
	/** 大小选择框 **/
	public JCheckBox[] sizeChb = new JCheckBox[4];
	/** 跨度选择框 **/
	public JCheckBox[] spanChb = new  JCheckBox[10];
	/** 胆码选择框(第一位过滤) **/
	public JCheckBox[] bilesChbOne = new JCheckBox[10];
	/** 胆码选择框(第二位过滤) **/
	public JCheckBox[] bilesChbTwo = new JCheckBox[10];
	/** 胆码选择框(第三位过滤) **/
	public JCheckBox[] bilesChbThree = new JCheckBox[10];
//	/** 胆码选择框(第四位过滤) **/
//	public JCheckBox[] bilesChbFour = new JCheckBox[10];
//	/** 胆码选择框(第五位过滤) **/
//	public JCheckBox[] bilesChbFive = new JCheckBox[10];
//	/** 胆码选择框(第六位过滤) **/
//	public JCheckBox[] bilesChbSix = new JCheckBox[10];
	/** 胆码选择框(一次过滤) **/
	public JCheckBox[] bilesChb1 = new JCheckBox[10];
	/** 胆码选择框(二次过滤) **/
	public JCheckBox[] bilesChb2 = new JCheckBox[10];
//	/** 胆码选择框(三次过滤) **/
//	public JCheckBox[] bilesChb3 = new JCheckBox[10];
//	/** 胆码选择框(四次过滤) **/
//	public JCheckBox[] bilesChb4 = new JCheckBox[10];
//	/** 胆码选择框(五次过滤) **/
//	public JCheckBox[] bilesChb5 = new JCheckBox[10];
//	/** 胆码选择框(六次过滤) **/
//	public JCheckBox[] bilesChb6 = new JCheckBox[10];
//	/** 胆码选择框(五次过滤) **/
//	public JCheckBox[] bilesChb7 = new JCheckBox[10];
//	/** 胆码选择框(六次过滤) **/
//	public JCheckBox[] bilesChb8 = new JCheckBox[10];
	/** 杀码选择框  **/
	public JCheckBox[] killChb = new JCheckBox[10];
	/** 顺子选择框 **/
	public JCheckBox[] junkoChb = new JCheckBox[3];
	/** 几码组合 **/
	public JCheckBox[] xCom = new JCheckBox[10];
	/** 和值012选择框**/
	public JCheckBox[] sum012Chb = new JCheckBox[3];
	/** 号码012选择框**/
	public JCheckBox[] num012Chb = new JCheckBox[4];
	/** 跨度012 **/
	public JCheckBox[] spanChb012 = new JCheckBox[3];
	/** 和尾012 **/
	public JCheckBox[] sumWei012 = new JCheckBox[3];
	/** 和尾0-9 **/
	public JCheckBox[] sumWei0_9 = new JCheckBox[10];
	/** 单双 **/
	public JCheckBox[] oddeven = new JCheckBox[2];
	/** 号码单双过滤 **/
	public JCheckBox[] numberOddEven = new JCheckBox[4];
	/** 和尾大小单双过滤 **/
	public JCheckBox[] heweiOddEven = new JCheckBox[4];
	/** 百 **/
	public JCheckBox[] bai = new JCheckBox[4];
	/** 十 **/
	public JCheckBox[] shi = new JCheckBox[4];
	/** 个 **/
	public JCheckBox[] ge = new JCheckBox[4];
	/** 胆码选择框(一次过滤不显示) **/
	public JCheckBox[] reBilesChb1 = new JCheckBox[10];
	/** 胆码选择框(二次过滤不显示) **/
	public JCheckBox[] reBilesChb2 = new JCheckBox[10];
	//************************button控件***************************************
	/** button 按钮 存放控件 **/
	public Panel btnPanel = new Panel();
	/** 开始选择按钮 **/
	public JButton choseBtn= new JButton("开始过滤");
	/** 取消选择 **/
	public JButton cancelBtn = new JButton("重新过滤");
	/** 条件设置按钮 **/
	public JButton conditionBtn= new JButton("条件过滤");
	
	public Lottery3D_V1_bank() {
		//设置窗体
		frame = new JFrame("福彩3D");
		frame.setBounds(0, 10, 1000, 470);
		frame.setBackground(Color.blue);
		frame.setLayout(null);
		frame.setResizable(false); //可否拖动
		cdFrame = new JFrame("条件设置");
		cdFrame.setBounds(100,120,800,700);
		cdFrame.setLayout(null);
		cdFrame.setResizable(false);
		
//		cdFrame.setVisible(true);
		//设置中间主要Panel
		setCenterPanel();
		setBtnPanel();
		setConditionPanel();
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		CheckEnvent checkEnvent = new CheckEnvent();
		
	}
	
	/**
	 * 按钮Panel<p>
	 * 
	 * void
	 */
	private void setBtnPanel(){
		btnPanel = new Panel();
		btnPanel.setVisible(true);
		btnPanel.setBounds(0,380,1000,30);
		conditionBtn.setFont(downFont);
//		cancelBtn.setFont(downFont);
		btnPanel.add(conditionBtn);
//		btnPanel.add(cancelBtn);
		frame.add(btnPanel);
	}
	/**
	 * 设置底端条件区域panel<p>
	 * <br> 
	 * return void<br>
	 */
	private void setConditionPanel(){
		panelDown = new Panel();
		panelDown.setVisible(true);
		panelDown.setBackground(downColor);
//		panelDown.setPreferredSize(new Dimension(700,400));
		GridBagLayout bagLayout = new GridBagLayout();
		panelDown.setLayout(bagLayout);
		GridBagConstraints bags = new GridBagConstraints();
		//容器水平填充方向 
		bags.fill = GridBagConstraints.NONE;
		
		//组3Label
		JLabel spanLab3 = new JLabel("跨度过滤:");
		spanLab3.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 0;
		bagLayout.setConstraints(spanLab3, bags);
		panelDown.add(spanLab3);
		
		//跨度选择框设置 
		for(int i = 0; i < 10; i++){
			spanChb[i] = new JCheckBox(i +"跨    ");
			spanChb[i].setBackground(downColor);
			spanChb[i].setFont(downFont);
			bags.gridx = i + 1;
			bags.gridy = 0;
			bagLayout.setConstraints(spanChb[i], bags);
			panelDown.add(spanChb[i]);
		}
		
		//大小Label
		JLabel sizeLab = new JLabel("大小过滤:");
		sizeLab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 1;
		bagLayout.setConstraints(sizeLab, bags);
		panelDown.add(sizeLab);
		
		//大小组件设置
		for(int i = 0; i < sizeChb.length; i++){
			sizeChb[i] = new JCheckBox();
			sizeChb[i].setBackground(downColor);
			sizeChb[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 1;
			bagLayout.setConstraints(sizeChb[i], bags);
			panelDown.add(sizeChb[i]);
		}
		//大小组件标题设置
		sizeChb[0].setText("小小小");
		sizeChb[1].setText("小小大");
		sizeChb[2].setText("小大大");
		sizeChb[3].setText("大大大");
		
		//顺子Label
		JLabel junkoLab = new JLabel("顺子过滤:");
		junkoLab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 2;
		bagLayout.setConstraints(junkoLab, bags);
		panelDown.add(junkoLab);
		
		//顺子组件设置
		junkoChb[0] = new JCheckBox("顺子   ");
		junkoChb[0].setBackground(downColor);
		junkoChb[0].setFont(downFont);
		bags.gridx = 1;
		bags.gridy = 2;
		bagLayout.setConstraints(junkoChb[0], bags);
		panelDown.add(junkoChb[0]);
		frame.add(panelDown);
		
		//半顺子组件设置
		junkoChb[1] = new JCheckBox("半顺子");
		junkoChb[1].setBackground(downColor);
		junkoChb[1].setFont(downFont);
		bags.gridx = 2;
		bags.gridy = 2;
		bagLayout.setConstraints(junkoChb[1], bags);
		panelDown.add(junkoChb[1]);
		
		//非顺子组件设置
		junkoChb[2] = new JCheckBox("非顺子");
		junkoChb[2].setBackground(downColor);
		junkoChb[2].setFont(downFont);
		bags.gridx = 3;
		bags.gridy = 2;
		bagLayout.setConstraints(junkoChb[2], bags);
		panelDown.add(junkoChb[2]);

		//杀码Label
		JLabel killLab = new JLabel("杀码过滤:");
		killLab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 3;
		bagLayout.setConstraints(killLab, bags);
		panelDown.add(killLab);
		
		//杀码过滤组件设置
		for(int i = 0; i < killChb.length; i++){
			killChb[i] = new JCheckBox(i+"        ");
			killChb[i].setBackground(downColor);
			killChb[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 3;
			bagLayout.setConstraints(killChb[i], bags);
			panelDown.add(killChb[i]);
		}
		//几码组合Label
		JLabel xComLab = new JLabel("几码组合:");
		xComLab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 6;
		bagLayout.setConstraints(xComLab, bags);
		panelDown.add(xComLab);
		
		//几码组合组件设置
		for(int i = 0; i < xCom.length; i++){
			xCom[i] = new JCheckBox(i+"        ");
			xCom[i].setBackground(downColor);
			xCom[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 6;
			bagLayout.setConstraints(xCom[i], bags);
			panelDown.add(xCom[i]);
		}
		
		//跨度012
		JLabel span012Lab = new JLabel("跨度012");
		xComLab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 7;
		bagLayout.setConstraints(span012Lab, bags);
		panelDown.add(span012Lab);
		//跨度012合组件设置
		for(int i = 0; i < spanChb012.length; i++){
			spanChb012[i] = new JCheckBox(i+"        ");
			spanChb012[i].setBackground(downColor);
			spanChb012[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 7;
			bagLayout.setConstraints(spanChb012[i], bags);
			panelDown.add(spanChb012[i]);
		}
		//和尾012
		JLabel sumWei012Lab = new JLabel("和尾012");
		xComLab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 8;
		bagLayout.setConstraints(sumWei012Lab, bags);
		panelDown.add(sumWei012Lab);
		//和尾012合组件设置
		for(int i = 0; i < sumWei012.length; i++){
			sumWei012[i] = new JCheckBox(i+"        ");
			sumWei012[i].setBackground(downColor);
			sumWei012[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 8;
			bagLayout.setConstraints(sumWei012[i], bags);
			panelDown.add(sumWei012[i]);
		}
							
		//和值012Label
		JLabel sum012Leb = new JLabel("和值012:");
		sum012Leb.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 9;
		bagLayout.setConstraints(sum012Leb, bags);
		panelDown.add(sum012Leb);
		//和值012
		for(int i = 0; i < sum012Chb.length; i++){
			sum012Chb[i] = new JCheckBox(i+"        ");
			sum012Chb[i].setBackground(downColor);
			sum012Chb[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 9;
			bagLayout.setConstraints(sum012Chb[i], bags);
			panelDown.add(sum012Chb[i]);
		}
		//号码012Label
		JLabel num012Leb = new JLabel("号码012:");
		num012Leb.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 10;
		bagLayout.setConstraints(num012Leb, bags);
		panelDown.add(num012Leb);
		//号码012
		for(int i = 0; i < num012Chb.length; i++){
			if(i != num012Chb.length - 1)
				num012Chb[i] = new JCheckBox(i+""+i+"      ");
			else
				num012Chb[i] = new JCheckBox("012      ");
			num012Chb[i].setBackground(downColor);
			num012Chb[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 10;
			bagLayout.setConstraints(num012Chb[i], bags);
			panelDown.add(num012Chb[i]);
		}
		//号码012Label
		JLabel oddevenLab = new JLabel("单双:");
		oddevenLab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 12;
		bagLayout.setConstraints(oddevenLab, bags);
		panelDown.add(oddevenLab);
		//单双
		for(int i = 0; i < oddeven.length; i++){
			oddeven[i] = new JCheckBox(i+1+"      ");
			oddeven[i].setBackground(downColor);
			oddeven[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 12;
			bagLayout.setConstraints(oddeven[i], bags);
			panelDown.add(oddeven[i]);
		}
		//尾0-9
		JLabel sumWei0_9Lab = new JLabel("尾0-9:");
		sumWei0_9Lab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 11;
		bagLayout.setConstraints(sumWei0_9Lab, bags);
		panelDown.add(sumWei0_9Lab);
		//尾0-9
		for(int i = 0; i < sumWei0_9.length; i++){
			sumWei0_9[i] = new JCheckBox(i+"      ");
			sumWei0_9[i].setBackground(downColor);
			sumWei0_9[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 11;
			bagLayout.setConstraints(sumWei0_9[i], bags);
			panelDown.add(sumWei0_9[i]);
		}
		
		//号码单双过滤
		JLabel number_oddEven = new JLabel("号码单双:");
		number_oddEven.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 13;
		bagLayout.setConstraints(number_oddEven, bags);
		panelDown.add(number_oddEven);
		String text = "";
		for(int i = 0; i < numberOddEven.length; i++){
			if(i==0) text = "111";
			else if(i==1) text = "11";
			else if(i==2) text = "22";
			else if(i==3) text = "222";
			numberOddEven[i] = new JCheckBox(text);
			numberOddEven[i].setBackground(downColor);
			numberOddEven[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 13;
			bagLayout.setConstraints(numberOddEven[i], bags);
			panelDown.add(numberOddEven[i]);
		}
		
		
		//和尾大小单双过滤
		JLabel hewei_oddEven = new JLabel("和尾大小单双:");
		hewei_oddEven.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 14;
		bagLayout.setConstraints(hewei_oddEven, bags);
		panelDown.add(hewei_oddEven);
		//和尾大小单双过滤
		for(int i = 0; i < heweiOddEven.length; i++){
			if(i==0) text = "13";
			else if(i==1) text = "579";
			else if(i==2) text = "024";
			else if(i==3) text = "68";
			heweiOddEven[i] = new JCheckBox(text);
			heweiOddEven[i].setBackground(downColor);
			heweiOddEven[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 14;
			bagLayout.setConstraints(heweiOddEven[i], bags);
			panelDown.add(heweiOddEven[i]);
		}				
		
		//百
		JLabel baiLab = new JLabel("百:");
		baiLab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 15;
		bagLayout.setConstraints(baiLab, bags);
		panelDown.add(baiLab);
		for(int i = 0; i < bai.length; i++){
			if(i==0) text = "13";
			else if(i==1) text = "579";
			else if(i==2) text = "024";
			else if(i==3) text = "68";
			bai[i] = new JCheckBox(text);
			bai[i].setBackground(downColor);
			bai[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 15;
			bagLayout.setConstraints(bai[i], bags);
			panelDown.add(bai[i]);
		}				
				
		//十
		JLabel shiLab = new JLabel("十:");
		shiLab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 16;
		bagLayout.setConstraints(shiLab, bags);
		panelDown.add(shiLab);
		for(int i = 0; i < shi.length; i++){
			if(i==0) text = "13";
			else if(i==1) text = "579";
			else if(i==2) text = "024";
			else if(i==3) text = "68";
			shi[i] = new JCheckBox(text);
			shi[i].setBackground(downColor);
			shi[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 16;
			bagLayout.setConstraints(shi[i], bags);
			panelDown.add(shi[i]);
		}	
		
		//个
		JLabel geLab = new JLabel("个:");
		geLab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 17;
		bagLayout.setConstraints(geLab, bags);
		panelDown.add(geLab);
		for(int i = 0; i < ge.length; i++){
			if(i==0) text = "13";
			else if(i==1) text = "579";
			else if(i==2) text = "024";
			else if(i==3) text = "68";
			ge[i] = new JCheckBox(text);
			ge[i].setBackground(downColor);
			ge[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 17;
			bagLayout.setConstraints(ge[i], bags);
			panelDown.add(ge[i]);
		}	
		
		
		
		
		
		//胆码Label
		JLabel bileLab = new JLabel("不定位胆码(第一位过滤):");
		bileLab.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 20;
		bagLayout.setConstraints(bileLab, bags);
		panelDown.add(bileLab);
		
		//不定位胆码第一位组件设置
		for(int i = 0; i < bilesChbOne.length; i++){
			bilesChbOne[i] = new JCheckBox(i+"        ");
			bilesChbOne[i].setBackground(downColor);
			bilesChbOne[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 20;
			bagLayout.setConstraints(bilesChbOne[i], bags);
			panelDown.add(bilesChbOne[i]);
		}
		//胆码Label
		JLabel bileLab2 = new JLabel("不定位胆码(第二位过滤):");
		bileLab2.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 21;
		bagLayout.setConstraints(bileLab2, bags);
		panelDown.add(bileLab2);
		
		//不定位胆码二次过滤组件设置
		for(int i = 0; i < bilesChbTwo.length; i++){
			bilesChbTwo[i] = new JCheckBox(i+"        ");
			bilesChbTwo[i].setBackground(downColor);
			bilesChbTwo[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 21;
			bagLayout.setConstraints(bilesChbTwo[i], bags);
			panelDown.add(bilesChbTwo[i]);
		}
		
		//胆码Label
		JLabel bileLab3 = new JLabel("不定位胆码(第三位过滤):");
		bileLab3.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 22;
		bagLayout.setConstraints(bileLab3, bags);
		panelDown.add(bileLab3);
		
		//不定位胆码三次过滤组件设置
		for(int i = 0; i < bilesChbThree.length; i++){
			bilesChbThree[i] = new JCheckBox(i+"        ");
			bilesChbThree[i].setBackground(downColor);
			bilesChbThree[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 22;
			bagLayout.setConstraints(bilesChbThree[i], bags);
			panelDown.add(bilesChbThree[i]);
		}
//		
//		//胆码Label
//		JLabel bileLab4 = new JLabel("不定位胆码(第四位过滤):");
//		bileLab4.setFont(downFont);
//		bags.gridx = 0;
//		bags.gridy = 23;
//		bagLayout.setConstraints(bileLab4, bags);
//		panelDown.add(bileLab4);
//		
//		//不定位胆码四次过滤组件设置
//		for(int i = 0; i < bilesChbFour.length; i++){
//			bilesChbFour[i] = new JCheckBox(i+"        ");
//			bilesChbFour[i].setBackground(downColor);
//			bilesChbFour[i].setFont(downFont);
//			bags.gridx = 1 + i;
//			bags.gridy = 23;
//			bagLayout.setConstraints(bilesChbFour[i], bags);
//			panelDown.add(bilesChbFour[i]);
//		}		
//		//胆码Label
//		JLabel bileLab5 = new JLabel("不定位胆码(第五位过滤):");
//		bileLab5.setFont(downFont);
//		bags.gridx = 0;
//		bags.gridy = 24;
//		bagLayout.setConstraints(bileLab5, bags);
//		panelDown.add(bileLab5);
//		
//		//不定位胆码五次过滤组件设置
//		for(int i = 0; i < bilesChbFive.length; i++){
//			bilesChbFive[i] = new JCheckBox(i+"        ");
//			bilesChbFive[i].setBackground(downColor);
//			bilesChbFive[i].setFont(downFont);
//			bags.gridx = 1 + i;
//			bags.gridy = 24;
//			bagLayout.setConstraints(bilesChbFive[i], bags);
//			panelDown.add(bilesChbFive[i]);
//		}		
//		//胆码Label
//		JLabel bileLab6 = new JLabel("不定位胆码(第六位过滤):");
//		bileLab6.setFont(downFont);
//		bags.gridx = 0;
//		bags.gridy = 25;
//		bagLayout.setConstraints(bileLab6, bags);
//		panelDown.add(bileLab6);
//		
//		//不定位胆码六次过滤组件设置
//		for(int i = 0; i < bilesChbSix.length; i++){
//			 bilesChbSix[i] = new JCheckBox(i+"        ");
//			 bilesChbSix[i].setBackground(downColor);
//			 bilesChbSix[i].setFont(downFont);
//			bags.gridx = 1 + i;
//			bags.gridy = 25;
//			bagLayout.setConstraints( bilesChbSix[i], bags);
//			panelDown.add( bilesChbSix[i]);
//		}
		//胆码Label
		JLabel bileLab7 = new JLabel("不定位胆码(一次过滤):");
		bileLab7.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 26;
		bagLayout.setConstraints(bileLab7, bags);
		panelDown.add(bileLab7);
		
		//不定位胆码二次过滤组件设置
		for(int i = 0; i < bilesChb1.length; i++){
			bilesChb1[i] = new JCheckBox(i+"        ");
			bilesChb1[i].setBackground(downColor);
			bilesChb1[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 26;
			bagLayout.setConstraints(bilesChb1[i], bags);
			panelDown.add(bilesChb1[i]);
		}
		
		//胆码Label
		JLabel bileLab8 = new JLabel("不定位胆码(二次过滤):");
		bileLab8.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 27;
		bagLayout.setConstraints(bileLab8, bags);
		panelDown.add(bileLab8);
		
		//不定位胆码二次过滤组件设置
		for(int i = 0; i < bilesChb2.length; i++){
			bilesChb2[i] = new JCheckBox(i+"        ");
			bilesChb2[i].setBackground(downColor);
			bilesChb2[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 27;
			bagLayout.setConstraints(bilesChb2[i], bags);
			panelDown.add(bilesChb2[i]);
		}

//		
//		//胆码Label
//		JLabel bileLab9 = new JLabel("不定位胆码(三次过滤):");
//		bileLab9.setFont(downFont);
//		bags.gridx = 0;
//		bags.gridy = 28;
//		bagLayout.setConstraints(bileLab9, bags);
//		panelDown.add(bileLab9);
//		
//		//不定位胆码三次过滤组件设置
//		for(int i = 0; i < bilesChb3.length; i++){
//			bilesChb3[i] = new JCheckBox(i+"        ");
//			bilesChb3[i].setBackground(downColor);
//			bilesChb3[i].setFont(downFont);
//			bags.gridx = 1 + i;
//			bags.gridy = 28;
//			bagLayout.setConstraints(bilesChb3[i], bags);
//			panelDown.add(bilesChb3[i]);
//		}
//		
//		//胆码Label
//		JLabel bileLab10 = new JLabel("不定位胆码(四次过滤):");
//		bileLab10.setFont(downFont);
//		bags.gridx = 0;
//		bags.gridy = 29;
//		bagLayout.setConstraints(bileLab10, bags);
//		panelDown.add(bileLab10);
//		
//		//不定位胆码四次过滤组件设置
//		for(int i = 0; i < bilesChb4.length; i++){
//			bilesChb4[i] = new JCheckBox(i+"        ");
//			bilesChb4[i].setBackground(downColor);
//			bilesChb4[i].setFont(downFont);
//			bags.gridx = 1 + i;
//			bags.gridy = 29;
//			bagLayout.setConstraints(bilesChb4[i], bags);
//			panelDown.add(bilesChb4[i]);
//		}
//		
//		//胆码Label
//		JLabel bileLab11 = new JLabel("不定位胆码(五次过滤):");
//		bileLab11.setFont(downFont);
//		bags.gridx = 0;
//		bags.gridy = 30;
//		bagLayout.setConstraints(bileLab11, bags);
//		panelDown.add(bileLab11);
//		
//		//不定位胆码五次过滤组件设置
//		for(int i = 0; i < bilesChb5.length; i++){
//			bilesChb5[i] = new JCheckBox(i+"        ");
//			bilesChb5[i].setBackground(downColor);
//			bilesChb5[i].setFont(downFont);
//			bags.gridx = 1 + i;
//			bags.gridy = 30;
//			bagLayout.setConstraints(bilesChb5[i], bags);
//			panelDown.add(bilesChb5[i]);
//		}
//		
//		//胆码Label
//		JLabel bileLab12 = new JLabel("不定位胆码(六次过滤):");
//		bileLab12.setFont(downFont);
//		bags.gridx = 0;
//		bags.gridy = 31;
//		bagLayout.setConstraints(bileLab12, bags);
//		panelDown.add(bileLab12);
//		
//		//不定位胆码六次过滤组件设置
//		for(int i = 0; i < bilesChb6.length; i++){
//			bilesChb6[i] = new JCheckBox(i+"        ");
//			bilesChb6[i].setBackground(downColor);
//			bilesChb6[i].setFont(downFont);
//			bags.gridx = 1 + i;
//			bags.gridy = 31;
//			bagLayout.setConstraints(bilesChb6[i], bags);
//			panelDown.add(bilesChb6[i]);
//		}
//		//胆码Label
//		JLabel bileLab13 = new JLabel("不定位胆码(七次过滤):");
//		bileLab13.setFont(downFont);
//		bags.gridx = 0;
//		bags.gridy = 32;
//		bagLayout.setConstraints(bileLab13, bags);
//		panelDown.add(bileLab13);
//		
//		//不定位胆码六次过滤组件设置
//		for(int i = 0; i < bilesChb7.length; i++){
//			bilesChb7[i] = new JCheckBox(i+"        ");
//			bilesChb7[i].setBackground(downColor);
//			bilesChb7[i].setFont(downFont);
//			bags.gridx = 1 + i;
//			bags.gridy = 32;
//			bagLayout.setConstraints(bilesChb7[i], bags);
//			panelDown.add(bilesChb7[i]);
//		}
//		//胆码Label
//		JLabel bileLab14 = new JLabel("不定位胆码(八次过滤):");
//		bileLab14.setFont(downFont);
//		bags.gridx = 0;
//		bags.gridy = 33;
//		bagLayout.setConstraints(bileLab14, bags);
//		panelDown.add(bileLab14);
//		
//		//不定位胆码六次过滤组件设置
//		for(int i = 0; i < bilesChb8.length; i++){
//			bilesChb8[i] = new JCheckBox(i+"        ");
//			bilesChb8[i].setBackground(downColor);
//			bilesChb8[i].setFont(downFont);
//			bags.gridx = 1 + i;
//			bags.gridy = 33;
//			bagLayout.setConstraints(bilesChb8[i], bags);
//			panelDown.add(bilesChb8[i]);
//		}
		//不定位胆码(一次过滤反显)
		JLabel rebileLab1= new JLabel("不定位胆码(一次过滤反显):");
		rebileLab1.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 34;
		bagLayout.setConstraints(rebileLab1, bags);
		panelDown.add(rebileLab1);
		
		//不定位胆码五次过滤组件设置
		for(int i = 0; i < reBilesChb1.length; i++){
			reBilesChb1[i] = new JCheckBox(i+"        ");
			reBilesChb1[i].setBackground(downColor);
			reBilesChb1[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 34;
			bagLayout.setConstraints(reBilesChb1[i], bags);
			panelDown.add(reBilesChb1[i]);
		}		
		//不定位胆码(一次过滤反显)
		JLabel rebileLab2 = new JLabel("不定位胆码(二次过滤反显):");
		rebileLab2.setFont(downFont);
		bags.gridx = 0;
		bags.gridy = 35;
		bagLayout.setConstraints(rebileLab2, bags);
		panelDown.add(rebileLab2);
		
		//不定位胆码六次过滤组件设置
		for(int i = 0; i < reBilesChb2.length; i++){
			reBilesChb2[i] = new JCheckBox(i+"        ");
			reBilesChb2[i].setBackground(downColor);
			reBilesChb2[i].setFont(downFont);
			bags.gridx = 1 + i;
			bags.gridy = 35;
			bagLayout.setConstraints( reBilesChb2[i], bags);
			panelDown.add( reBilesChb2[i]);
		}
//		JScrollPane scrollPane = new JScrollPane(panelDown);
//		scrollPane.setVisible(true);
//		scrollPane.setBounds(0,0,700,150);
//		cdFrame.add(scrollPane);
		panelDown.setVisible(true);
		panelDown.setBounds(0,0,800,600);
		cdFrame.add(panelDown);
		Panel cdPanel = new Panel();
		cdPanel.setVisible(true);
		cdPanel.setBounds(0, 600, 800, 100);
		choseBtn.setFont(downFont);
		cdPanel.add(choseBtn);
		cancelBtn.setFont(downFont);
		cdPanel.add(cancelBtn);
		cdFrame.add(cdPanel);
	}
	/**
	 * 设置中间主要Panel<p>
	 * <br> 
	 * return void<br>
	 */
	private void setCenterPanel(){
		//设置局部panel
		panel = new Panel();
		panel.setPreferredSize(new Dimension(900,370));
		panel.setVisible(true);
		panel.setBackground(color);
		panel.setBounds(0, 0, 980, 380);

		GridBagLayout bagLayout = new GridBagLayout();
		panel.setLayout(bagLayout);
		GridBagConstraints bags = new GridBagConstraints();
		
		//组件间的间距
//		bags.insets = new Insets(0, 0, 0,0);
		//容器水平填充方向 
		bags.fill = GridBagConstraints.NORTH;
		bags.anchor = GridBagConstraints.NORTH;
		sumChb.setFont(new Font(fontStyle, fontTck, 11));
		sumChb.setBackground(color);
		sumChb.setSelected(true);
		bags.gridx = 0;
		bags.gridy = 0;
		bagLayout.setConstraints(sumChb, bags);
		panel.add(sumChb);

		//和值循环
		for (int i = 0; i < sumChbNum.length; i++) {
			sumChbNum[i] = new JCheckBox(""+i);
			sumChbNum[i].setFont(new Font(fontStyle, fontTck, 9));
			sumChbNum[i].setBackground(color);
			sumChbNum[i].setSelected(true);
			sumChbNum[i].setSize(0, 0);
			bags.gridx = i + 1;
			bags.gridy = 0;
			bagLayout.setConstraints(sumChbNum[i], bags);
			panel.add(sumChbNum[i]);
		}
		
		int n = -2;
		//直选循环
		for(int i = 0; i < lb000.length; i++){
			lb000[i] = new JLabel(i+""+i+""+i);
			lb000[i].setFont(font);
			lb000[i].setForeground(Color.blue);
			n += 3;
			bags.gridx = n ;
			bags.gridy = 1;
			bagLayout.setConstraints(lb000[i], bags);
			panel.add(lb000[i]);
		}
		
		//数组转为list便于移除
		List<JLabel>  list3 = new ArrayList<JLabel>();
		int size3 = 0;
		//组选3循环
		for(int i = 0; i <= 9; i++ ){
			for(int j = 0; j <= 9; j++){
				if(i != j){
					lb001[size3] = new JLabel(i+""+""+i+""+j);
					list3.add(lb001[size3]);
					size3++;
				}
			}
		}
		
		//组选3位置 摆放
		for(int y = 2; y <=6; y++ ){
			for(int x = 2; x <= 27; x++){
				for(int i = 0; i < list3.size();i++){
					JLabel label = list3.get(i);
					int postion = Tools.getLabSum(label);
					if( x-1 == postion){
						label.setFont(font);
						label.setForeground(Color.black);
						bags.gridx = x ;
						bags.gridy = y;
						bagLayout.setConstraints(label, bags);
						panel.add(label);
						list3.remove(i);
						break;
					}
				}
			}
		}
		//数组转为list便于移除
		List<JLabel>  list6 = new ArrayList<JLabel>();
		int size6 = 0;
		//组选6循环
		for(int i = 0; i <= 7; i++ ){ //百位0-7
			for(int j = 1+i; j <= 8; j++){ //十位  1-8 
				for(int k = 1+j; k <= 9; k++){ //个位 2-9
					if(i != j && j != k && i != k){
						lb012[size6] = new JLabel(i+""+j+""+k);
						list6.add(lb012[size6]);
						size6++;
					}
				}
			}
		}
		
		//组选6位置 摆放
		for(int y = 7; y <=16; y++ ){
			for(int x = 4; x <= 25; x++){
				for(int i = 0; i < list6.size();i++){
					JLabel label = list6.get(i);
					int postion = Tools.getLabSum(label);
					if( x-1 == postion){
						label.setFont(font);
						label.setForeground(Color.blue);
						bags.gridx = x ;
						bags.gridy = y;
						bagLayout.setConstraints(label, bags);
						panel.add(label);
						list6.remove(i);
						break;
					}
				}
			}
		}
		
		//直选选择框
		rChb.setFont(new Font(fontStyle, fontTck, 11));
		rChb.setForeground(Color.blue);
		rChb.setBackground(color);
		rChb.setSelected(true);
		bags.gridx = 0;
		bags.gridy = 1;
		bagLayout.setConstraints(rChb, bags);
		panel.add(rChb);
		
		//组3选择框
		rChb3.setFont(new Font(fontStyle, fontTck, 11));
		rChb3.setForeground(Color.black);
		rChb3.setBackground(color);
		rChb3.setSelected(true);
		bags.gridx = 0;
		bags.gridy = 2;
//		bags.gridheight = 5;
		bagLayout.setConstraints(rChb3, bags);
		panel.add(rChb3);
		//***************控制布局的笨办法**********************//
		for(int i = 0; i < 4; i++){
			JLabel jLabel = new JLabel("组3");
			jLabel.setFont(new Font(fontStyle, fontTck, 16));
			jLabel.setForeground(Color.pink);
			bags.gridx = 0;
			bags.gridy = i+3;
			bagLayout.setConstraints(jLabel, bags);
			panel.add(jLabel);
		}
		//组6选择框
		rChb6.setFont(new Font(fontStyle, fontTck, 11));
		rChb6.setForeground(Color.blue);
		rChb6.setBackground(color);
		rChb6.setSelected(true);
		bags.gridx = 0;
		bags.gridy = 7;
//		bags.gridheight = 10;
		bagLayout.setConstraints(rChb6, bags);
		panel.add(rChb6);
		
		//***************控制布局的笨办法***********************//
		for(int i = 0; i < 10; i++){
			JLabel jLabel = new JLabel("组6");
			jLabel.setFont(new Font(fontStyle, fontTck, 16));
			jLabel.setForeground(Color.pink);
			bags.gridx = 0;
			bags.gridy = i+7;
			bagLayout.setConstraints(jLabel, bags);
			panel.add(jLabel);
		}
		frame.add(panel);
	}
}





