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
 * @version 2.0 <br>
 */
public class Lottery3D extends WindowAdapter{

	/** 主框架 **/
	public  JFrame frame ;
	/** 条件框架 **/
	public  JFrame cdFrame;
	/** 大底panel **/
	public  Panel panel;
	/** 字体样式 **/
	private String fontStyle = "Dialog";
	/** 字体粗细 **/
	private final int fontTck = 0;
	/** 字体大小 **/
	private final int fontSize = 14;
	/** 背景颜色 **/
	private final Color color = Color.pink;
	/** 字体样式 **/
	private final Font font = new Font(fontStyle, fontTck, fontSize);
	/** 第二列起始位置*/
	private final int  sencodPosition = 6;
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
	/** 显示数字数量*/
	public JLabel  lbNum = new JLabel();
	public String lbNumText = "共：220 注 ";
	//**************************条件区域控件***************************************
	/** 底端panel背景颜色 **/
	private final Color downColor = new Color(218,165,10);
	/**条件字体*/
	private final Font downFont = new Font(fontStyle, fontTck, 12);
	/**条件标题字体*/
	private final Font titleFont = new Font(fontStyle, 1, 13);
//	/**特殊符号字体*/
//	private final Font symbolFont = new Font(fontStyle, 1, 18);
	/** 条件panel **/
	private final Panel panelDown = new Panel();
//	/** 大小选择框 **/
//	public JCheckBox[] sizeChb = new JCheckBox[4];
	/** 跨度选择框 **/
	public JCheckBox[] spanChb = new  JCheckBox[10];
//	/** 第一组不定位胆码选择框(第一位过滤) **/
//	public JCheckBox[] bilesChbOne = new JCheckBox[10];
//	/** 第一组不定位胆码选择框(第二位过滤) **/
//	public JCheckBox[] bilesChbTwo = new JCheckBox[10];
//	/** 第一组不定位胆码选择框(第三位过滤) **/
//	public JCheckBox[] bilesChbThree = new JCheckBox[10];
//	
//	/** 第二组不定位胆码选择框(第一位过滤) **/
//	public JCheckBox[] secondBilesChbOne = new JCheckBox[10];
//	/** 第二组不定位胆码选择框(第二位过滤) **/
//	public JCheckBox[] secondBilesChbTwo = new JCheckBox[10];
//	/** 第二组不定位胆码选择框(第三位过滤) **/
//	public JCheckBox[] secondBilesChbThree = new JCheckBox[10];
	
//	/** 第三组不定位胆码选择框(第一位过滤) **/
//	public JCheckBox[] thirdBilesChbOne = new JCheckBox[10];
//	/** 第三组不定位胆码选择框(第二位过滤) **/
//	public JCheckBox[] thirdBilesChbTwo = new JCheckBox[10];
//	/** 第三组不定位胆码选择框(第三位过滤) **/
//	public JCheckBox[] thirdBilesChbThree = new JCheckBox[10];
	
//	/**WE选项框**/
//	public JCheckBox[] weCB = new JCheckBox[3];
//	/**ds-xd选项框**/
//	public JCheckBox[] ds_xdCB = new JCheckBox[3];
//	/**HE选项框**/
//	public JCheckBox[] heCB = new JCheckBox[3];
//	/**ZB选项框**/
//	public JCheckBox[] zbCB = new JCheckBox[3];
//	/**DS-XD选项框**/
//	public JCheckBox[] DS_XDCB = new JCheckBox[3];
//	/**tboz选项**/
//	public JCheckBox[] tboz = new JCheckBox[4];
	/** 不定位胆码选择框(一次过滤) **/
	public JCheckBox[] bilesChb1 = new JCheckBox[10];
	/** 不定位胆码选择框(二次过滤) **/
	public JCheckBox[] bilesChb2 = new JCheckBox[10];
//	/** 不定位胆码选择框(三次过滤) **/
//	public JCheckBox[] bilesChb3 = new JCheckBox[10];
//	/** 不定位胆码选择框(四次过滤) **/
//	public JCheckBox[] bilesChb4 = new JCheckBox[10];
	
	/** 杀码选择框  **/
	public JCheckBox[] killChb = new JCheckBox[10];
//	/** 77.11.22.99选择框 **/
//	public JCheckBox[] junkoChb = new JCheckBox[4];
//	/** 几码组合 **/
//	public JCheckBox[] xCom = new JCheckBox[10];
	/** 和值012选择框**/
	public JCheckBox[] sum012Chb = new JCheckBox[3];
	/** 号码012选择框**/
	public JCheckBox[] num012Chb = new JCheckBox[3];
	/** 跨度012 **/
	public JCheckBox[] spanChb012 = new JCheckBox[3];
	/** 和尾012 **/
	public JCheckBox[] sumWei012 = new JCheckBox[3];
	/** 和尾0-9 **/
	public JCheckBox[] sumWei0_9 = new JCheckBox[10];
//	/** 单双 **/
//	public JCheckBox[] oddeven = new JCheckBox[2];
	/** 号码单双过滤 **/
	public JCheckBox[] numberOddEven = new JCheckBox[4];
	
//	/** 零二七九 **/
//	public JCheckBox[] n0279 = new JCheckBox[4];
//	/** 二七正反显 **/
//	public JCheckBox[] n27 = new JCheckBox[2];
//	/** TB**/
//	public JCheckBox[] tb = new JCheckBox[2];
//	/**和TBtb **/
//	public JCheckBox[] sumTBtb = new JCheckBox[4];
	/**和值快捷键 */
	public JCheckBox[] sumChbShortcut = new JCheckBox[3];
	/**跨度快捷键*/
	public JCheckBox[] spanChbShortcut = new JCheckBox[2];
	//add 2015-5-09
	/** 和尾 */
	public JCheckBox[] hw = new JCheckBox[4];
	/** 跨度*/
	public JCheckBox[] kd = new JCheckBox[4];
//	/** 27 */
//	public JCheckBox[] c27 = new JCheckBox[3];
//	/** 不定位胆码反显（第一位）*/
//	public JCheckBox[] bilesRe1 = new JCheckBox[10];
//	/** 不定位胆码反显（第二位）*/
//	public JCheckBox[] bilesRe2 = new JCheckBox[10];
	/** oz*/
	public JCheckBox[] oz = new JCheckBox[2];
//	/** 0 15 */
//	public JCheckBox[] c015 = new JCheckBox[2];
	//add 2015-5-21
//	/**TTBT*/
//	public JCheckBox[] ttbt = new JCheckBox[2];
//	/**TT2TT1BT*/
//	public JCheckBox[] tt1bt1 = new JCheckBox[3];
	//add 2015-8-21
//	/**TT0BT0*/
//	public JCheckBox[] tt0bt0 = new JCheckBox[2];
	/**跨号*/
	public JCheckBox[] kh = new JCheckBox[9];
//	/**最后备注条件*/
//	public JCheckBox[] uk1 = new JCheckBox[9];
	//add 2015-11-28
//	/**和跨尾*/
//	public JCheckBox[] hkw = new JCheckBox[27];
//	/**和尾号*/
//	public JCheckBox[] hwh = new JCheckBox[27];
//	/**(*T*B)*/
//	public JCheckBox[] startTB = new JCheckBox[2];
	//add 2016-01-17
//	/**TB（新）<br>
//	 * T=(‹T+›交集‹T-›）并集（‹B+›交集‹B-›）<br>
//	 * B=(‹T+›交集‹B-›）并集（‹B+›交集‹T-›）
//	 * */
	//public JCheckBox[] tbNew = new JCheckBox[2];
//	/**T+ B+*/
	//public JCheckBox[] tbAdd = new JCheckBox[2]; 
//	/**T- B-*/
	//public JCheckBox[] tbSub = new JCheckBox[2]; 
	//add 2016-02-21
	///**TT-BB*/
	//public JCheckBox[] ttbb = new JCheckBox[2];
	/** 1 2 3*/
	public JCheckBox[] c123 = new JCheckBox[3];
	///** == != */
	//public JCheckBox[] equalOrNo = new JCheckBox[2];
	//add 2016-02-27
	///** T B*/
	//public JCheckBox[] tbThree = new JCheckBox[2];
	//add 2016-03-06
	/**TTBB_Second*/
	public JCheckBox[] ttbbSecond = new JCheckBox[2];
	//add 2016.04.08
//	/**同/不同*/
//	public JCheckBox[] differ = new JCheckBox[2];
	//add 2016.4.30
	/**跨尾**/
	public JCheckBox[] kw = new JCheckBox[9];
	//add 2016.5.6
	/**+◆-*/
	public JCheckBox[] jjf = new JCheckBox[3];
	//add 2016.8.10
	/**■ Η X*/
	public JCheckBox[] fhx = new JCheckBox[3];
//	/**跨尾过滤(同跨尾 不同跨尾)*/
//	public JCheckBox[] kwDiff = new JCheckBox[2];
	/**顺过滤*/
	public JCheckBox[] sgl = new JCheckBox[2];
	/**XXDD过滤*/
	public JCheckBox[] xxdd = new JCheckBox[2];
	/**77 11 22 99过滤*/
	public JCheckBox[] setn = new JCheckBox[4];
	/**0 3 6 9 2 4 5 7 8 过滤*/
	public JCheckBox[] zsen = new JCheckBox[9];
//	/**★●过滤*/
//	public JCheckBox[] starCircle = new JCheckBox[2];
	//add 2016.08.25
//	/**TB_FOUR*/
//	public JCheckBox[] tbFour = new JCheckBox[2];
	//add 2016.09.14
	/**T■  ■  B■*/
	public JCheckBox[] tbZF = new JCheckBox[3];
	///**T◆  B◆*/
	//public JCheckBox[] tbXF = new JCheckBox[2];
	///**2■ ☀	 ■2*/
	//public JCheckBox[] f2Star1 = new JCheckBox[3];
	///**T★  B★*/
	//public JCheckBox[] tbStart = new JCheckBox[2];
	///**十◆ 一○*/
	//public JCheckBox[] addXFSubO = new JCheckBox[2];
	//add 2016.11.12
	/**加减*/
	public JCheckBox[] addSub = new JCheckBox[3];
	/**■■十十一一*/
	public JCheckBox[] fjjjj = new JCheckBox[3];
	/**●★过滤*/
	public JCheckBox[] circleStar = new JCheckBox[2];
	/**口	十◢	口	◣★	口	◣一*/
	public JCheckBox[] jxj = new JCheckBox[3];
	/**口	叁	口	贰	口	壹*/
	public JCheckBox[] d123 = new JCheckBox[3];
	/**●●★★*/
	public JCheckBox[] yyxx = new JCheckBox[2];
	//************************button控件***************************************
	/** button 按钮 存放控件 **/
	public Panel btnPanel = new Panel();
	/** 开始选择按钮 **/
	public JButton choseBtn= new JButton("开始过滤");
	/** 取消选择 **/
	public JButton cancelBtn = new JButton("重新过滤");
	/** 条件设置按钮 **/
	public JButton conditionBtn= new JButton("条件过滤");
	
	/** y柱坐标*/
	private  int y = 0;
	private GridBagConstraints bags;
	private GridBagLayout bagLayout;
	/**条件窗口高度*/
	private final int conditionHight = 470;
	/**条件窗口宽度*/ 
	private final int conditionWeight = 700;
	public Lottery3D() {
		//设置窗体
		frame = new JFrame("福彩3D 如有需要请联系QQ:421729814");
		frame.setBounds(0, 10, 1000, 470);
		frame.setBackground(Color.blue);
		frame.setLayout(null);
		frame.setResizable(false); //可否拖动
		cdFrame = new JFrame("条件设置");
		cdFrame.setBounds(100,20,conditionWeight,conditionHight);
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
		lbNum = new JLabel(lbNumText);
		lbNum.setFont(new Font(fontStyle, 0, 16));
		btnPanel = new Panel();
		btnPanel.setVisible(true);
		btnPanel.setBounds(0,380,1000,30);
		btnPanel.add(lbNum);
		conditionBtn.setFont(downFont);
		btnPanel.add(conditionBtn);
		frame.add(btnPanel);
	}
	
	/**
	 * 设置条件标题
	 * @param name 标题名称
	 * @param x X坐标
	 */
	private void setConditionTitle(String name, int x){
		JLabel titleLab = new JLabel(name);
		titleLab.setFont(titleFont);
		bags.gridx = x;
		bags.gridy = y;
		bagLayout.setConstraints(titleLab, bags);
		panelDown.add(titleLab);
	}
	
//	/**
//	 * 设置特殊符号
//	 * @param name 符号
//	 * @param x X坐标
//	 */
//	private void setSymbol(String name,int x){
//		JLabel symbol = new JLabel(name);
//		symbol.setFont(symbolFont);
//		symbol.setForeground(Color.blue);
//		bags.gridx = x;
//		bags.gridy = y;
//		bagLayout.setConstraints(symbol, bags);
//		panelDown.add(symbol);
//	}
	/**
	 * 设置条件选项
	 * @param box 复选框
	 * @param x X坐标
	 */
	private void setConditionValue(JCheckBox box, int x){
		box.setBackground(downColor);
		box.setFont(downFont);
		bags.gridx = x;
		bags.gridy = y;
		bagLayout.setConstraints(box, bags);
		panelDown.add(box);
	}
	
	
	/**
	 * 设置底端条件区域panel<p>
	 * <br> 
	 * return void<br>
	 */
	private void setConditionPanel(){
		panelDown.setVisible(true);
		panelDown.setBackground(downColor);
		bagLayout = new GridBagLayout();
		panelDown.setLayout(bagLayout);
		bags = new GridBagConstraints();
		//容器水平填充方向 
		bags.fill = GridBagConstraints.NONE;
		//组件坐靠齐
		bags.anchor = GridBagConstraints.WEST;
		//TODO 尾0-9 过滤
		setConditionTitle("和尾过滤:", 0);
		for(int i = 0; i < sumWei0_9.length; i++){
			sumWei0_9[i] = new JCheckBox(i+"");
			setConditionValue(sumWei0_9[i],i+1);
		}
		y++;
		//TODO 跨度过滤
		setConditionTitle("跨度过滤:", 0);
		for(int i = 0; i < spanChb.length; i++){
			spanChb[i] = new JCheckBox(i +"跨    ");
			setConditionValue(spanChb[i],i+1);
	    }
		y++;
		//TODO 跨度012
		setConditionTitle("跨度012:", 0);
		for(int i = 0; i < spanChb012.length; i++){
			spanChb012[i] = new JCheckBox(i+"");
			setConditionValue(spanChb012[i],i+1);
		}
//		//TODO T-B-（新）
//		for(int i = 0; i < tbSub.length; i++){
//			tbSub[i] = new JCheckBox();
//		}
//		tbSub[0].setText("T-");
//		setConditionValue(tbSub[0],sencodPosition+1);
//		tbSub[1].setText("B-");
//		setConditionValue(tbSub[1],sencodPosition+2);	
		//TODO 
		tbZF[0] = new JCheckBox("T■");
		setConditionValue(tbZF[0],sencodPosition-1);
		tbZF[1] = new JCheckBox("■");
		setConditionValue(tbZF[1],sencodPosition);
		tbZF[2] = new JCheckBox("B■");
		setConditionValue(tbZF[2],sencodPosition+1);

		addSub[0] = new JCheckBox("加");
		setConditionValue(addSub[0],sencodPosition + 3);
		addSub[1] = new JCheckBox("减");
		setConditionValue(addSub[1],sencodPosition + 4);
		addSub[2] = new JCheckBox("同");
		setConditionValue(addSub[2],sencodPosition + 2);
		y++;
		//TODO 和尾012
		setConditionTitle("和尾012:", 0);
		for(int i = 0; i < sumWei012.length; i++){
			sumWei012[i] = new JCheckBox(i+"");
			setConditionValue(sumWei012[i],i+1);
		}
		
		zsen[0] = new JCheckBox("0");
		zsen[0].setForeground(Color.BLUE);
		setConditionValue(zsen[0], 4);
		zsen[1] = new JCheckBox("2");
		zsen[1].setForeground(Color.BLUE);
		setConditionValue(zsen[1], 5);
		//TODO 跨度快捷键
		//setConditionTitle("跨:", sencodPosition+2);
		spanChbShortcut[0] = new JCheckBox("中");
		setConditionValue(spanChbShortcut[0],sencodPosition+2);
		spanChbShortcut[1] = new JCheckBox("边 ");
		setConditionValue(spanChbShortcut[1],sencodPosition+3);	
		y++;

		//TODO 号码012过滤
		setConditionTitle("号码012:", 0);
		for(int i = 0; i < num012Chb.length; i++){
			num012Chb[i] = new JCheckBox(i+""+i+"");
			setConditionValue(num012Chb[i],i+1);
		}
		zsen[2] = new JCheckBox("3");
		zsen[2].setForeground(Color.BLUE);
		setConditionValue(zsen[2], 4);
		zsen[3] = new JCheckBox("4");
		zsen[3].setForeground(Color.BLUE);
		setConditionValue(zsen[3], 5);
		//TODO 跨度快捷键
		setConditionTitle("跨度:", sencodPosition);
		kd[0] = new JCheckBox("13");
		kd[1] = new JCheckBox("68");
		kd[2] = new JCheckBox("024");
		kd[3] = new JCheckBox("579");
		for(int i = 0; i < kd.length; i++){
			setConditionValue(kd[i],sencodPosition+i+1);
		}
		y++;

	
		//TODO 和值快捷键
		setConditionTitle("和:", 0);
		sumChbShortcut[0] = new JCheckBox("边");
		setConditionValue(sumChbShortcut[0],1);
		sumChbShortcut[1] = new JCheckBox("中");
		setConditionValue(sumChbShortcut[1],2);
		sumChbShortcut[2] = new JCheckBox("边");
		setConditionValue(sumChbShortcut[2],3);
		zsen[4] = new JCheckBox("6");
		zsen[4].setForeground(Color.BLUE);
		setConditionValue(zsen[4], 4);
		zsen[5] = new JCheckBox("5");
		zsen[5].setForeground(Color.BLUE);
		setConditionValue(zsen[5], 5);
		//TODO 号码单双过滤
		setConditionTitle("号码单双:", sencodPosition);
		String text = "";
		for(int i = 0; i < numberOddEven.length; i++){
			if(i==0)      text = "111";
			else if(i==1) text = "11";
			else if(i==2) text = "22";
			else if(i==3) text = "222";
			numberOddEven[i] = new JCheckBox(text);
			setConditionValue(numberOddEven[i],i+1+sencodPosition);
		}

		y++;
		//TODO 和值012过滤
		setConditionTitle("和值012:", 0);
		for(int i = 0; i < sum012Chb.length; i++){
			sum012Chb[i] = new JCheckBox(i+"");
			setConditionValue(sum012Chb[i],i+1);
		}
		
		zsen[6] = new JCheckBox("9");
		zsen[6].setForeground(Color.BLUE);
		setConditionValue(zsen[6], 4);
		zsen[7] = new JCheckBox("7");
		zsen[7].setForeground(Color.BLUE);
		setConditionValue(zsen[7], 5);
		//TODO 和尾快捷键
		setConditionTitle("和尾:", sencodPosition);
		hw[0] = new JCheckBox("13");
		hw[1] = new JCheckBox("68");
		hw[2] = new JCheckBox("024");
		hw[3] = new JCheckBox("579");
		for(int i = 0; i < hw.length; i++){
			setConditionValue(hw[i],i+1+sencodPosition);
		}	
		//y++;
		////TODO
		//tbXF[0] = new JCheckBox("T◆");
		//setConditionValue(tbXF[0], sencodPosition + 1);
		//tbXF[1] = new JCheckBox("B◆");
		//setConditionValue(tbXF[1], sencodPosition + 2);
		y++;
		
		jxj[0] = new JCheckBox("十◢");
		jxj[1] = new JCheckBox("◣★	");
		jxj[2] = new JCheckBox("◣一");
		for(int i = 0; i < jxj.length; i++){
			setConditionValue(jxj[i],i+1);
		}
		
		zsen[8] = new JCheckBox("8");
		zsen[8].setForeground(Color.BLUE);
		setConditionValue(zsen[8], 5);
		//TODO OZ过滤
		oz[0] = new JCheckBox("O");
		oz[1] = new JCheckBox("Z");
		setConditionValue(oz[0], sencodPosition + 1);
		setConditionValue(oz[1], sencodPosition + 2);
		//TODO TTBB_Second
		ttbbSecond[0] = new JCheckBox("TT");
		setConditionValue(ttbbSecond[0], sencodPosition + 3);
		ttbbSecond[1] = new JCheckBox("BB");
		setConditionValue(ttbbSecond[1], sencodPosition + 4);
//		//TODO 同不同
//		differ[0] = new JCheckBox("同");
//		setConditionValue(differ[0], 7);
//		differ[1] = new JCheckBox("不");
//		setConditionValue(differ[1], 8);

	/*	//TODO TT BB
		ttbb[0] = new JCheckBox("TT");
		setConditionValue(ttbb[0], 1);
		ttbb[1] = new JCheckBox("BB");
		setConditionValue(ttbb[1], 2);*/
		
	//	y++;
		/*//TODO TB（新）
		for(int i = 0; i < tbNew.length; i++){
			tbNew[i] = new JCheckBox();
		}
		tbNew[0].setText("T");
		setConditionValue(tbNew[0],1);
		tbNew[1].setText("B");
		setConditionValue(tbNew[1],2);*/
		

//		//TODO
//		f2Star1[0] = new JCheckBox("2■"); 
//		setConditionValue(f2Star1[0], 4);
//		f2Star1[1] = new JCheckBox("☀"); 
//		setConditionValue(f2Star1[1], 5);
//		f2Star1[2] = new JCheckBox("■2"); 
//		setConditionValue(f2Star1[2], 6);
//		//TODO *T*B
//		startTB[0] = new JCheckBox("*T");
//		setConditionValue(startTB[0], 7);
//		startTB[1] = new JCheckBox("*B");
//		setConditionValue(startTB[1], 8);
		

	//	y++;
		/*//TODO T+B+（新）
		for(int i = 0; i < tbAdd.length; i++){
			tbAdd[i] = new JCheckBox();
		}
		tbAdd[0].setText("T+");
		setConditionValue(tbAdd[0],1);
		tbAdd[1].setText("B+");
		setConditionValue(tbAdd[1],2);*/
		y++;
		//TODO 跨尾
		setConditionTitle("边  一■十", 0);
		kw[0] = new JCheckBox("01");
		kw[1] = new JCheckBox("12");
		kw[2] = new JCheckBox("20");
		kw[3] = new JCheckBox("00");
		kw[4] = new JCheckBox("11");
		kw[5] = new JCheckBox("22");
		kw[6] = new JCheckBox("02");
		kw[7] = new JCheckBox("10");
		kw[8] = new JCheckBox("21");
		for(int i = 0; i < kw.length; i++){
			setConditionValue(kw[i],i + 1);
		}
//		//TODO
//		tbStart[0] = new JCheckBox("T★");
//		setConditionValue(tbStart[0],10);
		y++;
		//TODO 跨号
		setConditionTitle("中  十一■", 0);
		kh[0] = new JCheckBox("01");
		kh[1] = new JCheckBox("12");
		kh[2] = new JCheckBox("20");
		kh[3] = new JCheckBox("00");
		kh[4] = new JCheckBox("11");
		kh[5] = new JCheckBox("22");
		kh[6] = new JCheckBox("02");
		kh[7] = new JCheckBox("10");
		kh[8] = new JCheckBox("21");
		for(int i = 0; i < kh.length; i++){
			setConditionValue(kh[i],i + 1);
		}	
//		//TODO
//		tbStart[1] = new JCheckBox("B★");
//		setConditionValue(tbStart[1],10);
		y++;	
		setConditionTitle("边  ■十一", 0);
		fjjjj[0] = new JCheckBox("■ ■");
		setConditionValue(fjjjj[0],1);
		fjjjj[1] = new JCheckBox("+ +");
		setConditionValue(fjjjj[1],2);
		fjjjj[2] = new JCheckBox("- -");
		setConditionValue(fjjjj[2],3);
	
		//TODO ■ Η X
		fhx[0] = new JCheckBox("■");
		fhx[1] = new JCheckBox("H");
		fhx[2] = new JCheckBox("X");
		for(int i = 0; i < fhx.length; i++){
			setConditionValue(fhx[i],i+4);
		}
		yyxx[0] = new JCheckBox("●●");
		setConditionValue(yyxx[0], 7);
//		//TODO ★●
//		starCircle[0] = new JCheckBox("★");
//		setConditionValue(starCircle[0], 9);
//		starCircle[1] = new JCheckBox("●");
//		setConditionValue(starCircle[1], 8);
		//TODO ●★
		circleStar[0] = new JCheckBox("●");
		setConditionValue(circleStar[0], 8);
		circleStar[1] = new JCheckBox("★");
		setConditionValue(circleStar[1], 9);	
		y++;
//		setConditionTitle("跨尾过滤：", 0);
//		kwDiff[0] = new JCheckBox("同跨尾");
//		kwDiff[1] = new JCheckBox("不同");
//		for(int i = 0; i < kwDiff.length; i++){
//			setConditionValue(kwDiff[i],i + 1);
//		}
		d123[0] = new JCheckBox("叁");
		d123[1] = new JCheckBox("贰");
		d123[2] = new JCheckBox("壹");
		for(int i = 0; i < d123.length; i++){
			setConditionValue(d123[i],i + 1);
		}
		//TODO+◆-
		jjf[0] = new JCheckBox("+");
		jjf[1] = new JCheckBox("◆");
		jjf[2] = new JCheckBox("-");
		setConditionValue(jjf[0], 4);
		setConditionValue(jjf[1], 5);
		setConditionValue(jjf[2], 6);
		yyxx[1] = new JCheckBox("★★");
		setConditionValue(yyxx[1], 7);
//		//TODO c015
//		c015[0] = new JCheckBox("0");
//		c015[1] = new JCheckBox("15");
//		setConditionValue(c015[0], 4);
//		setConditionValue(c015[1], 5);
//		//TODO
//		addXFSubO[0] = new JCheckBox("十◆");
//		setConditionValue(addXFSubO[0], 6);
		//TODO XXDD
		xxdd[0] = new JCheckBox("XX");
		xxdd[1] = new JCheckBox("DD");
		setConditionValue(xxdd[0], 8);
		setConditionValue(xxdd[1], 9);
		y++;
		//TODO 顺过滤
		setConditionTitle("顺过滤：", 0);
		sgl[0] = new JCheckBox("顺");
		sgl[1] = new JCheckBox("非顺");
		setConditionValue(sgl[0], 1);
		setConditionValue(sgl[1], 2);
		
				//TODO 1 2 3
		for(int i = 0; i < c123.length; i++){
			c123[i] = new JCheckBox(i+1+"");
			setConditionValue(c123[i], i+4);
		}
//		//TODO TB_FOUR
//		tbFour[0] = new JCheckBox("T");
//		setConditionValue(tbFour[0], 4);
//		tbFour[1] = new JCheckBox("B");
//		setConditionValue(tbFour[1], 5);
//		//TODO
//		addXFSubO[1] = new JCheckBox("一○");
//		setConditionValue(addXFSubO[1], 6);
		//TODO 77 11 22 99
		setn[0] = new JCheckBox("77");
		setn[1] = new JCheckBox("11");
		setn[2] = new JCheckBox("22");
		setn[3] = new JCheckBox("99");
		for(int i = 0; i < setn.length; i++){
			setConditionValue(setn[i],i + 1 + sencodPosition);
		}
		y++;
//		//TODO = ≠ 
//		equalOrNo[0] = new JCheckBox("=");
//		setConditionValue(equalOrNo[0], 1);
//		equalOrNo[1] = new JCheckBox("≠");
//		setConditionValue(equalOrNo[1], 2);
//		
//		y++;		
//		//TODO tbThree
//		tbThree[0] = new JCheckBox("T");
//		setConditionValue(tbThree[0], 1);
//		tbThree[1] = new JCheckBox("B");
//		setConditionValue(tbThree[1], 2);

		
//		//TODO1 ds-xd
//		setConditionTitle("ds-xd:", 0);
//		for(int i = 0; i < ds_xdCB.length; i++){
//			ds_xdCB[i] = new JCheckBox();
//			if(i==0) ds_xdCB[i].setText("XX     ");
//			else if(i==1) ds_xdCB[i].setText("DD     ");
//			else if(i==2) ds_xdCB[i].setText("12      ");
//			setConditionValue(ds_xdCB[i],i+1 );
//		};
//		//TODO1 单双过滤
//		setConditionTitle("单双(1单2双):", sencodPosition);
//		oddeven[0] = new JCheckBox(1+"        ");
//		setConditionValue(oddeven[0],sencodPosition+1);
//		oddeven[1] = new JCheckBox(2+"        ");
//		setConditionValue(oddeven[1],sencodPosition+2);
//		y++;	
//		//TODO1 大小过滤
//		setConditionTitle("大小过滤:", 0);
//		sizeChb[0] = new JCheckBox("小小小");
//		sizeChb[1] = new JCheckBox("小小大");
//		sizeChb[2] = new JCheckBox("小大大");
//		sizeChb[3] = new JCheckBox("大大大");
//		for(int i = 0; i < sizeChb.length; i++){
//			setConditionValue(sizeChb[i],i+1);
//		}
//		//TODO1 TT1TT2BT1
//		tt1bt1[0] = new JCheckBox("TT2");
//		tt1bt1[1] = new JCheckBox("TT1");
//		tt1bt1[2] = new JCheckBox("BT1");
//		for(int i = 0; i < tt1bt1.length; i++){
//			setConditionValue(tt1bt1[i], sencodPosition + i+1);
//		}
//		y++;
//		
//		//TODO1 TTBB
//		ttbt[0] = new JCheckBox("TT");
//		ttbt[1] = new JCheckBox("BT");
//		for(int i=0 ; i < ttbt.length; i++){
//			setConditionValue(ttbt[i], sencodPosition + i+1);
//		}
//		y++;
		//TTOBTO
//		tt0bt0[0] = new JCheckBox("TT0");
//		setConditionValue(tt0bt0[0],sencodPosition+1);
//		tt0bt0[1] = new JCheckBox("BT0");
//		setConditionValue(tt0bt0[1],sencodPosition+2);
//		y++;

//		//TODO1 TB
//		//setConditionTitle("12=11+22                   ", 0);
//		for(int i = 0; i < tb.length; i++){
//			tb[i] = new JCheckBox();
//			if(i==0) tb[i].setText("T     ");
//			else if(i==1) tb[i].setText("B       ");
//			setConditionValue(tb[i],i + 1+sencodPosition);
//		}
	//	y++;
		/*//TODO1 HE
		setConditionTitle(" HE:", sencodPosition+1);
		for(int i = 0; i < heCB.length; i++){
			heCB[i] = new JCheckBox();
			if(i==0) heCB[i].setText("0.1.2  ");
			else if(i==1) heCB[i].setText("012    ");
			else if(i==2) heCB[i].setText("12      ");
			setConditionValue(heCB[i],i+2 + sencodPosition);
		}
		y++;

		//TODO1 条件27过滤
		setConditionTitle("27", sencodPosition+1);
		c27[0] = new JCheckBox(2+"    ");
		c27[1] = new JCheckBox(27+"   ");
		c27[2] = new JCheckBox(7+"    ");
		for (int i = 0; i < c27.length; i++) {
			setConditionValue(c27[i],i+2 + sencodPosition);
		}
		y++;

		//TODO1 77.11.22.99过滤
		setConditionTitle("77.11.22.99:", sencodPosition);
		junkoChb[0] = new JCheckBox("77      ");
		junkoChb[1] = new JCheckBox("11      ");
		junkoChb[2] = new JCheckBox("22      ");
		junkoChb[3] = new JCheckBox("99      ");
		for(int i=0; i < junkoChb.length; i++){
			setConditionValue(junkoChb[i],i+1+sencodPosition);
		}
		y++;


		//TODO1 零二七九
		setConditionTitle("   零二七九:", sencodPosition);
		n0279[0] = new JCheckBox("0        "); 
		n0279[1] = new JCheckBox("2        "); 
		n0279[2] = new JCheckBox("7        "); 
		n0279[3] = new JCheckBox("9        "); 
		for(int i = 0; i < n0279.length; i++){
			setConditionValue(n0279[i],i+1+sencodPosition);
		}
		y++;

		//TODO1 二七反显
		setConditionTitle("二七反正显:", sencodPosition);
		n27[0] = new JCheckBox("正显   "); 
		n27[1] = new JCheckBox("反显   "); 
		for(int i = 0; i < n27.length; i++){
			setConditionValue(n27[i],i+1+sencodPosition);
		}
		y++;*/

//		//TODO1 几码组合过滤
//		setConditionTitle("                  几码组合:", 0);
//		for(int i = 0; i < xCom.length; i++){
//			xCom[i] = new JCheckBox(i+"        ");
//			setConditionValue(xCom[i],i+1);
//		}
//		y++;
//		//TODO1 不定位胆码（反显） 第一位过滤
//		setConditionTitle("不定位胆码(反显)(第一位过滤):", 0);
//		for(int i = 0; i < bilesRe1.length; i++){
//			bilesRe1[i] = new JCheckBox(i+"        ");
//			setConditionValue(bilesRe1[i],i+1);
//		}
//		y++;
//		//TODO1 不定位胆码（反显） 第二位过滤
//		setConditionTitle("                          (第二位过滤):", 0);
//		for(int i = 0; i < bilesRe2.length; i++){
//			bilesRe2[i] = new JCheckBox(i+"        ");
//			setConditionValue(bilesRe2[i],i+1);
//		}
//		y++;
//		//TODO1 不定位胆码一组(第一位过滤)
//		setConditionTitle("不定位胆码        (第一位过滤):", 0);
//		for(int i = 0; i < bilesChbOne.length; i++){
//			bilesChbOne[i] = new JCheckBox(i+"        ");
//			setConditionValue(bilesChbOne[i],i+1);
//		}
//		y++;
//		//TODO1 不定位胆码一组(第二位过滤)
//		setConditionTitle("                 (第二位过滤):", 0);
//		for(int i = 0; i < bilesChbTwo.length; i++){
//			bilesChbTwo[i] = new JCheckBox(i+"        ");
//			setConditionValue(bilesChbTwo[i],i+1);
//		}
//		y++;
//		//TODO1 不定位胆码一组(第三位过滤)
//		setConditionTitle("                 (第三位过滤):", 0);
//		for(int i = 0; i < bilesChbThree.length; i++){
//			bilesChbThree[i] = new JCheckBox(i+"        ");
//			setConditionValue(bilesChbThree[i],i+1);
//		}
//		y++;
//		
//		//TODO1 不定位胆码第二组(第一位过滤)
//		setConditionTitle("不定位胆码(第一位过滤):", 0);
//		for(int i = 0; i < secondBilesChbOne.length; i++){
//			secondBilesChbOne[i] = new JCheckBox(i+"        ");
//			setConditionValue(secondBilesChbOne[i],i+1);
//		}	
//		y++;
//		//TODO1 不定位胆码第二组(第二位过滤)
//		setConditionTitle("                 (第二位过滤):", 0);
//		for(int i = 0; i < secondBilesChbTwo.length; i++){
//			secondBilesChbTwo[i] = new JCheckBox(i+"        ");
//			setConditionValue(secondBilesChbTwo[i],i+1);
//		}		
//		y++;
//		//TODO1 不定位胆码第二组(第三位过滤)
//		setConditionTitle("                 (第三位过滤):", 0);
//		for(int i = 0; i < secondBilesChbThree.length; i++){
//			secondBilesChbThree[i] = new JCheckBox(i+"        ");
//			setConditionValue(secondBilesChbThree[i],i+1);
//		}
//		y++;
//		//TODO1 WE
//		setConditionTitle("                               WE:", 0);
//		for(int i = 0; i < weCB.length; i++){
//			weCB[i] = new JCheckBox();
//			if(i==0) weCB[i].setText("0.1.2 ");
//			else if(i==1) weCB[i].setText("012    ");
//			else if(i==2) weCB[i].setText("12      ");
//			setConditionValue(weCB[i],i+1);
//		}
//		//TODO1 ZB
//		setConditionTitle("ZB:", sencodPosition);
//		for(int i = 0; i < zbCB.length; i++){
//			zbCB[i] = new JCheckBox();
//			if(i==0) zbCB[i].setText("ZZ     ");
//			else if(i==1) zbCB[i].setText("BB     ");
//			else if(i==2) zbCB[i].setText("12      ");
//			setConditionValue(zbCB[i],i+1+sencodPosition);
//		}
//		
//		y++;
//		
//		
//		//TODO1 和TBtb
//		setConditionTitle("和TBtb:", sencodPosition);
//		for(int i = 0; i < sumTBtb.length; i++){
//			sumTBtb[i] = new JCheckBox();
//			if(i==0) sumTBtb[i].setText("T       ");
//			else if(i==1) sumTBtb[i].setText("B       ");
//			else if(i==2) sumTBtb[i].setText("t       ");
//			else if(i==3) sumTBtb[i].setText("b       ");
//			setConditionValue(sumTBtb[i],i+1+sencodPosition);
//		}
//		y++;
//		//TODO1 DS-XD过滤
//		setConditionTitle("                          DS-XD:", 0);
//		for(int i = 0; i < DS_XDCB.length; i++){
//			DS_XDCB[i] = new JCheckBox();
//			if(i==0) DS_XDCB[i].setText("DX      ");
//			else if(i==1) DS_XDCB[i].setText("SD      ");
//			else if(i==2) DS_XDCB[i].setText("12      ");
//			setConditionValue(DS_XDCB[i],i+1);
//		}

//		
//		y++;
//		
//		//TODO1 TBOZ
//		setConditionTitle("TBOZ:", sencodPosition);
//		for(int i = 0; i < tboz.length; i++){
//			tboz[i] = new JCheckBox();
//			if(i==0) tboz[i].setText("T       ");
//			else if(i==1) tboz[i].setText("B       ");
//			else if(i==2) tboz[i].setText("O        ");
//			else if(i==3) tboz[i].setText("Z        ");
//			setConditionValue(tboz[i],i+1+sencodPosition);
//		}
//		y++;
		
//		setSymbol("T", 1);
//		setSymbol("+", 2);
//		setSymbol("-", 3);
//		
//		setSymbol("-", 5);
//		setSymbol("T", 6);
//		setSymbol("+", 7);
//		
//		setSymbol("+", 9);
//		setSymbol("T", 10);
//		setSymbol("-", 11);
//		y++;
//		hkw[0] = new JCheckBox("000");
//		setConditionValue(hkw[0], 1);
//		hkw[3] = new JCheckBox("010");
//		setConditionValue(hkw[3], 2);
//		hkw[6] = new JCheckBox("020");
//		setConditionValue(hkw[6], 3);
//		
//		
//		hkw[7] = new JCheckBox("021");
//		setConditionValue(hkw[7], 5);
//		hkw[1] = new JCheckBox("001");
//		setConditionValue(hkw[1], 6);
//		hkw[4] = new JCheckBox("011");
//		setConditionValue(hkw[4], 7);
//		
//		hkw[5] = new JCheckBox("012");
//		setConditionValue(hkw[5], 9);
//		hkw[2] = new JCheckBox("002");
//		setConditionValue(hkw[2], 10);
//		hkw[8] = new JCheckBox("022");
//		setConditionValue(hkw[8], 11);
//		y++;
//		
//		setConditionTitle("和跨尾:", 0);
//		hkw[9] = new JCheckBox("111");
//		setConditionValue(hkw[9], 1);
//		hkw[12] = new JCheckBox("121");
//		setConditionValue(hkw[12], 2);
//		hkw[15] = new JCheckBox("101");
//		setConditionValue(hkw[15], 3);
//		
//		hkw[16] = new JCheckBox("102");
//		setConditionValue(hkw[16], 5);
//		hkw[10] = new JCheckBox("112");
//		setConditionValue(hkw[10], 6);
//		hkw[13] = new JCheckBox("122");
//		setConditionValue(hkw[13], 7);
//		
//		hkw[14] = new JCheckBox("120");
//		setConditionValue(hkw[14], 9);
//		hkw[11] = new JCheckBox("110");
//		setConditionValue(hkw[11], 10);
//		hkw[17] = new JCheckBox("100");
//		setConditionValue(hkw[17], 11);
//		y++;
//		
//		hkw[18] = new JCheckBox("222");
//		setConditionValue(hkw[18], 1);
//		hkw[21] = new JCheckBox("202");
//		setConditionValue(hkw[21], 2);
//		hkw[24] = new JCheckBox("212");
//		setConditionValue(hkw[24], 3);
//		
//		hkw[25] = new JCheckBox("210");
//		setConditionValue(hkw[25], 5);
//		hkw[19] = new JCheckBox("220");
//		setConditionValue(hkw[19], 6);
//		hkw[22] = new JCheckBox("200");
//		setConditionValue(hkw[22], 7);
//		
//		hkw[23] = new JCheckBox("201");
//		setConditionValue(hkw[23], 9);
//		hkw[20] = new JCheckBox("221");
//		setConditionValue(hkw[20], 10);
//		hkw[26] = new JCheckBox("211");
//		setConditionValue(hkw[26], 11);
		
		y++;
		//TODO 不定位胆码(1次过滤)
		setConditionTitle("(第一次过滤):", 0);
		for(int i = 0; i < bilesChb1.length; i++){
			bilesChb1[i] = new JCheckBox(i+"");
			setConditionValue(bilesChb1[i],i+1);
		}
		y++;
		//TODO 不定位胆码(2次过滤)
		setConditionTitle("(第二次过滤):", 0);
		for(int i = 0; i < bilesChb2.length; i++){
			bilesChb2[i] = new JCheckBox(i+"");
			setConditionValue(bilesChb2[i],i+1);
		}
		y++;
//		//TODO 不定位胆码(3次过滤)
//		setConditionTitle("                           (第三次过滤):", 0);
//		for(int i = 0; i < bilesChb3.length; i++){
//			bilesChb3[i] = new JCheckBox(i+"        ");
//			setConditionValue(bilesChb3[i],i+1);
//		}
//		y++;
//		//TODO 不定位胆码(4次过滤)
//		setConditionTitle("                          (第四次过滤):", 0);
//		for(int i = 0; i < bilesChb4.length; i++){
//			bilesChb4[i] = new JCheckBox(i+"        ");
//			setConditionValue(bilesChb4[i],i+1);
//		}
//		y++;
//		uk1[0] = new JCheckBox("01");
//		uk1[1] = new JCheckBox("12");
//		uk1[2] = new JCheckBox("20");
//		uk1[3] = new JCheckBox("00");
//		uk1[4] = new JCheckBox("11");
//		uk1[5] = new JCheckBox("22");
//		uk1[6] = new JCheckBox("02");
//		uk1[7] = new JCheckBox("10");
//		uk1[8] = new JCheckBox("21");
//		for(int i = 0; i < uk1.length; i++){
//			setConditionValue(uk1[i],i + 1);
//		}
//		hwh[0] = new JCheckBox("000");
//		setConditionValue(hwh[0], 1);
//		hwh[1] = new JCheckBox("001");
//		setConditionValue(hwh[1], 2);
//		hwh[2] = new JCheckBox("002");
//		setConditionValue(hwh[2], 3);
//
//		hwh[5] = new JCheckBox("012");
//		setConditionValue(hwh[5], 5);
//		hwh[3] = new JCheckBox("010");
//		setConditionValue(hwh[3], 6);
//		hwh[4] = new JCheckBox("011");
//		setConditionValue(hwh[4], 7);
//		
//		hwh[7] = new JCheckBox("021");
//		setConditionValue(hwh[7], 9);
//		hwh[6] = new JCheckBox("020");
//		setConditionValue(hwh[6], 10);
//		hwh[8] = new JCheckBox("022");
//		setConditionValue(hwh[8], 11);
//		y++;
//		
//		setConditionTitle("和尾号:", 0);
//		hwh[9] = new JCheckBox("111");
//		setConditionValue(hwh[9], 1);
//		hwh[10] = new JCheckBox("112");
//		setConditionValue(hwh[10], 2);
//		hwh[11] = new JCheckBox("110");
//		setConditionValue(hwh[11], 3);
//		
//		hwh[14] = new JCheckBox("120");
//		setConditionValue(hwh[14], 5);
//		hwh[12] = new JCheckBox("121");
//		setConditionValue(hwh[12], 6);
//		hwh[13] = new JCheckBox("122");
//		setConditionValue(hwh[13], 7);
//		
//		hwh[16] = new JCheckBox("102");
//		setConditionValue(hwh[16], 9);
//		hwh[15] = new JCheckBox("101");
//		setConditionValue(hwh[15], 10);
//		hwh[17] = new JCheckBox("100");
//		setConditionValue(hwh[17], 11);
//		y++;
//		
//		hwh[18] = new JCheckBox("222");
//		setConditionValue(hwh[18], 1);
//		hwh[19] = new JCheckBox("220");
//		setConditionValue(hwh[19], 2);
//		hwh[20] = new JCheckBox("221");
//		setConditionValue(hwh[20], 3);
//		
//		setSymbol("\\+", 4);
//		
//		hwh[23] = new JCheckBox("201");
//		setConditionValue(hwh[23], 5);
//		hwh[21] = new JCheckBox("202");
//		setConditionValue(hwh[21], 6);
//		hwh[22] = new JCheckBox("200");
//		setConditionValue(hwh[22], 7);
//		
//		setSymbol("\\-", 8);
//		
//		hwh[25] = new JCheckBox("210");
//		setConditionValue(hwh[25], 9);
//		hwh[24] = new JCheckBox("212");
//		setConditionValue(hwh[24], 10);
//		hwh[26] = new JCheckBox("211");
//		setConditionValue(hwh[26], 11);
		y++;
		//TODO 杀码过滤
		setConditionTitle("杀码过滤:", 0);
		for(int i = 0; i < killChb.length; i++){
			killChb[i] = new JCheckBox(i+"");
			setConditionValue(killChb[i],i+1);
	    }
		y++;
		panelDown.setVisible(true);
		panelDown.setBounds(0,0,conditionWeight,conditionHight-60);
		cdFrame.add(panelDown);
		Panel cdPanel = new Panel();
		cdPanel.setVisible(true);
		cdPanel.setBounds(0, conditionHight-60, conditionWeight, 50);
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
//		for(int i = 0; i < 10; i++){
//			JLabel jLabel = new JLabel("组6");
//			jLabel.setFont(new Font(fontStyle, fontTck, 16));
//			jLabel.setForeground(Color.pink);
//			bags.gridx = 0;
//			bags.gridy = i+7;
//			bagLayout.setConstraints(jLabel, bags);
//			panel.add(jLabel);
//		}
		JLabel[] leftLab = new JLabel[9];
		leftLab[0] = new JLabel("");
		leftLab[1] = new JLabel("00");
		leftLab[2] = new JLabel("");
		leftLab[3] = new JLabel("");
		leftLab[4] = new JLabel("0-");
		leftLab[5] = new JLabel("");
		leftLab[6] = new JLabel("");
		leftLab[7] = new JLabel("0+");
		leftLab[8] = new JLabel("");
		for(int i = 0; i < leftLab.length;i++){
			bags.gridx = 0;
			bags.gridy = 8+i;
			leftLab[i].setFont(new Font(fontStyle, fontTck, 14));
			bagLayout.setConstraints(leftLab[i], bags);
			panel.add(leftLab[i]);
		}
		JLabel[] leftLab2 = new JLabel[9];
		leftLab2[0] = new JLabel("边 2");
		leftLab2[1] = new JLabel("中 1");
		leftLab2[2] = new JLabel("边 0");
		leftLab2[3] = new JLabel("边 1");
		leftLab2[4] = new JLabel("中 0");
		leftLab2[5] = new JLabel("边 2");
		leftLab2[6] = new JLabel("边 0");
		leftLab2[7] = new JLabel("中 2");
		leftLab2[8] = new JLabel("边 1");
		for(int i = 0; i < leftLab2.length;i++){
			bags.gridx = 1;
			bags.gridy = 8+i;
			leftLab2[i].setFont(new Font(fontStyle, fontTck, 13));
			leftLab2[i].setForeground(Color.red);
			bagLayout.setConstraints(leftLab2[i], bags);
			panel.add(leftLab2[i]);
		}
		JLabel[] leftLab3 = new JLabel[9];
		leftLab3[0] = new JLabel("");
		leftLab3[1] = new JLabel("11");
		leftLab3[2] = new JLabel("");
		leftLab3[3] = new JLabel("");
		leftLab3[4] = new JLabel("1-");
		leftLab3[5] = new JLabel("");
		leftLab3[6] = new JLabel("");
		leftLab3[7] = new JLabel("1+");
		leftLab3[8] = new JLabel("");
		for(int i = 0; i < leftLab3.length;i++){
			bags.gridx = 2;
			bags.gridy = 8+i;
			leftLab3[i].setFont(new Font(fontStyle, fontTck, 14));
			bagLayout.setConstraints(leftLab3[i], bags);
			panel.add(leftLab3[i]);
		}
		JLabel[] leftLab4 = new JLabel[9];
		leftLab4[0] = new JLabel("边 1");
		leftLab4[1] = new JLabel("中 0");
		leftLab4[2] = new JLabel("边 2");
		leftLab4[3] = new JLabel("边 0");
		leftLab4[4] = new JLabel("中 2");
		leftLab4[5] = new JLabel("边 1");
		leftLab4[6] = new JLabel("边 2");
		leftLab4[7] = new JLabel("中 1");
		leftLab4[8] = new JLabel("边 0");
		for(int i = 0; i < leftLab4.length;i++){
			bags.gridx = 3;
			bags.gridy = 8+i;
			leftLab4[i].setFont(new Font(fontStyle, fontTck, 13));
			leftLab4[i].setForeground(Color.red);
			bagLayout.setConstraints(leftLab4[i], bags);
			panel.add(leftLab4[i]);
		}	
		
		JLabel[] rightLab = new JLabel[9];
		rightLab[0] = new JLabel("");
		rightLab[1] = new JLabel("22");
		rightLab[2] = new JLabel("");
		rightLab[3] = new JLabel("");
		rightLab[4] = new JLabel("2-");
		rightLab[5] = new JLabel("");
		rightLab[6] = new JLabel("");
		rightLab[7] = new JLabel("2+");
		rightLab[8] = new JLabel("");
		for(int i = 0; i < rightLab.length;i++){
			bags.gridx = 27;
			bags.gridy = 8+i;
			rightLab[i].setFont(new Font(fontStyle, fontTck, 14));
			bagLayout.setConstraints(rightLab[i], bags);
			panel.add(rightLab[i]);
		}
		
		JLabel[] rightLab2 = new JLabel[9];
		rightLab2[0] = new JLabel("边 0");
		rightLab2[1] = new JLabel("中 2");
		rightLab2[2] = new JLabel("边 1");
		rightLab2[3] = new JLabel("边 2");
		rightLab2[4] = new JLabel("中 1");
		rightLab2[5] = new JLabel("边 0");
		rightLab2[6] = new JLabel("边 1");
		rightLab2[7] = new JLabel("中 0");
		rightLab2[8] = new JLabel("边 2");
		for(int i = 0; i < rightLab2.length;i++){
			bags.gridx = 28;
			bags.gridy = 8+i;
			rightLab2[i].setFont(new Font(fontStyle, fontTck, 13));
			rightLab2[i].setForeground(Color.red);
			bagLayout.setConstraints(rightLab2[i], bags);
			panel.add(rightLab2[i]);
		}	
		frame.add(panel);
	}
}





