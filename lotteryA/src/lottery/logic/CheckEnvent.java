package lottery.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import lottery.frame.Common;
import lottery.frame.Tools;
import lottery.view.Lottery3D;

/**
 * 选择框的选择事件<p>
 * @author DuanQingwei  @date 2012-9-22 <br>
 * @version 1.0 <br>
 */
public class CheckEnvent {

    public  static 	Lottery3D lottery3d = new Lottery3D();
	public CheckEnvent(){
		lottery3d.frame.setVisible(true);
		lottery3d.frame.addWindowListener(new Lottery3D());
//		setJunkoChbAction();
		setSumChbAction();
		setChoseBtnAction();
		setCancleBtnAction();
		setConditionBtnAction();
		//setShortcutAction();
		lottery3d.frame.addWindowListener(new WindowClose());
	}
	static class WindowClose extends WindowAdapter{
		public void windowClosing(WindowEvent e) { 								
			System.exit(0); 
		}
	}
//	/**
//	 * 顺子设置为单选
//	 */
//	private void setJunkoChbAction(){
//		for (JCheckBox box : lottery3d.junkoChb) {
//			box.addItemListener(new ItemListener() {
//				@Override
//				public void itemStateChanged(ItemEvent e) {
//					JCheckBox b = (JCheckBox) e.getSource();
//					if(lottery3d.junkoChb[0].isSelected() && lottery3d.junkoChb[0].equals(b)){
//						lottery3d.junkoChb[1].setSelected(false);
//						lottery3d.junkoChb[2].setSelected(false);
//					}
//					if(lottery3d.junkoChb[1].isSelected() && lottery3d.junkoChb[1].equals(b)){
//						lottery3d.junkoChb[0].setSelected(false);
//						lottery3d.junkoChb[2].setSelected(false);
//					}
//					if(lottery3d.junkoChb[2].isSelected() && lottery3d.junkoChb[2].equals(b)){
//						lottery3d.junkoChb[1].setSelected(false);
//						lottery3d.junkoChb[0].setSelected(false);
//					}
//				}
//			});
//		}
//	}
	/**
	 * 控制和值的选择监听<p>
	 * <br> 
	 * return void<br>
	 */
	public void setSumChbAction(){
		lottery3d.sumChb.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox checkBox = (JCheckBox) e.getSource();
				if(checkBox != null){
					if(checkBox.isSelected()){
						for(int i = 0; i < lottery3d.sumChbNum.length; i++){
							lottery3d.sumChbNum[i].setSelected(true);
						}
					}else{
						for(int i = 0; i < lottery3d.sumChbNum.length; i++){
							lottery3d.sumChbNum[i].setSelected(false);
						}
					}
				}
			}
			
		});
	}

	/**
	 * 设置快捷键的选择监听<p>
	 * <br> 
	 * return void<br>
	 */
//	private void setShortcutAction(){
//			//和值快捷键 中
//			lottery3d.sumChbShortcut[0].addItemListener(new ItemListener() {
//				@Override
//				public void itemStateChanged(ItemEvent e) {
//					JCheckBox checkBox = (JCheckBox) e.getSource();
//					if(checkBox != null){
//						if(checkBox.isSelected()){
//							for(int i = 10; i <=19; i++){
//								lottery3d.sumChbNum[i].setSelected(true);
//							}
//						}else{
//							for(int i = 10; i <=19; i++){
//								lottery3d.sumChbNum[i].setSelected(false);
//							}
//						}
//					}
//				}
//			});
//			//和值快捷键 边
//			lottery3d.sumChbShortcut[1].addItemListener(new ItemListener() {
//				@Override
//				public void itemStateChanged(ItemEvent e) {
//					JCheckBox checkBox = (JCheckBox) e.getSource();
//					if(checkBox != null){
//						if(checkBox.isSelected()){
//							for(int i = 0; i <=9; i++){
//								lottery3d.sumChbNum[i].setSelected(true);
//							}
//							for(int i = 20; i <=27; i++){
//								lottery3d.sumChbNum[i].setSelected(true);
//							}
//						}else{
//							for(int i = 0; i <=9; i++){
//								lottery3d.sumChbNum[i].setSelected(false);
//							}
//							for(int i = 20; i <=27; i++){
//								lottery3d.sumChbNum[i].setSelected(false);
//							}
//						}
//					}
//				}
//			});
//			//跨度快捷键 中
//			lottery3d.spanChbShortcut[0].addItemListener(new ItemListener() {
//				@Override
//				public void itemStateChanged(ItemEvent e) {
//					JCheckBox checkBox = (JCheckBox) e.getSource();
//					if(checkBox != null){
//						if(checkBox.isSelected()){
//							for(int i = 2; i <=7; i++){
//								lottery3d.spanChb[i].setSelected(true);
//							}
//						}else{
//							for(int i = 2; i <=7; i++){
//								lottery3d.spanChb[i].setSelected(false);
//							}
//						}
//					}
//				}
//			});
//			//跨度快捷键 边
//			lottery3d.spanChbShortcut[1].addItemListener(new ItemListener() {
//				@Override
//				public void itemStateChanged(ItemEvent e) {
//					JCheckBox checkBox = (JCheckBox) e.getSource();
//					if(checkBox != null){
//						if(checkBox.isSelected()){
//							for(int i = 0; i <=1; i++){
//								lottery3d.spanChb[i].setSelected(true);
//							}
//							for(int i = 8; i <=9; i++){
//								lottery3d.spanChb[i].setSelected(true);
//							}
//						}else{
//							for(int i = 0; i <=1; i++){
//								lottery3d.spanChb[i].setSelected(false);
//							}
//							for(int i = 8; i <=9; i++){
//								lottery3d.spanChb[i].setSelected(false);
//							}
//						}
//					}
//				}
//			});
//	}
	/**
	 * 选择按钮点击事件<p>
	 * <br> 
	 * return void<br>
	 */
	public void setChoseBtnAction(){
		lottery3d.choseBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setAllNotVisible();
				//直选数字
				List<JLabel> list0 = new ArrayList<JLabel>(); 
				if(lottery3d.rChb.isSelected()){
					for(JLabel label : lottery3d.lb000){
						list0.add(label);
					}
				}
				//组3数字
				List<JLabel> list3 = new ArrayList<JLabel>();
				if(lottery3d.rChb3.isSelected()){
					for(JLabel label : lottery3d.lb001){
						list3.add(label);
					}
				}
				//组6数字
				List<JLabel> list6 = new ArrayList<JLabel>();
				if(lottery3d.rChb6.isSelected()){
					for(JLabel label : lottery3d.lb012){
						list6.add(label);
					}
				}
				opertion0(list0);
				opertion3(list3);
				opertion6(list6);
				opertionAll(list0, list3, list6);
				//显示的数量
				int num = 0;
				//显示数字
				if(Common.isNotEmptyList(list0)){
					for (JLabel jLabel : list0) {
						jLabel.setVisible(true);
						num ++;
					}
				}
				//显示数字
				if(Common.isNotEmptyList(list3)){
					for (JLabel jLabel : list3) {
						jLabel.setVisible(true);
						num ++;
					}
				}
				//显示数字
				if(Common.isNotEmptyList(list6)){
					for (JLabel jLabel : list6) {
						jLabel.setVisible(true);
						num ++;
					}
				}
				lottery3d.lbNum.setText("共："+num+" 注 ");
			}
		});
	}

	/**
	 * 条件设置按钮点击事件<p>
	 * <br> 
	 * return void<br>
	 */
	public void setConditionBtnAction(){
		lottery3d.conditionBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lottery3d.cdFrame.setVisible(true);
			}
		});
	}
	/**
	 * 直选操作<p>
	 * <br> 
	 * return void<br>
	 */
	public void opertion0(List<JLabel> list0){
		
		//接收符合条件的数字
		List<JLabel> temp = new ArrayList<JLabel>();
		//组件是否被选中
		boolean isSelect = false;
		//直选和值
		if(Common.isNotEmptyList(list0)){
			for(JCheckBox box : lottery3d.sumChbNum){
				if(box.isSelected()){
					isSelect = true;
					for (JLabel label : list0) {
						if(Integer.parseInt(box.getText()) == Tools.getLabSum(label)){
							temp.add(label);
						}
					}
				}
			}
		}
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list0.removeAll(list0);
		}
		//跨度
		if(Common.isNotEmptyList(list0)){
			list0 = convert(list0, temp);
			temp.removeAll(temp);
			isSelect = false;
			for(int i = 0; i < lottery3d.spanChb.length; i++){
				if(lottery3d.spanChb[i].isSelected()){
					isSelect = true;
					int n = i ;
					for(JLabel label : list0){
						if(n == Tools.getSpan(label)){
							temp.add(label);
						}
					}
				}
			}
		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list0.removeAll(list0);
//		}
//		//直选 大小
//		if(Common.isNotEmptyList(list0)){
//			list0 = convert(list0, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			for(int i = 0; i < lottery3d.sizeChb.length; i++){
//				if(lottery3d.sizeChb[i].isSelected()){
//					isSelect = true;
//					for(JLabel label : list0){
//						if(i == Tools.getSize(label)){
//							temp.add(label);
//						}
//					}
//				}
//			}
//		}
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list0.removeAll(list0);
		}

		//直选 胆码 一次过滤
		if(Common.isNotEmptyList(list0)){
			list0 = convert(list0, temp);
			temp.removeAll(temp);
			isSelect = false;
			List<String> strBiles = new ArrayList<String>();
			for (JCheckBox	box : lottery3d.bilesChb1) {
				if(box.isSelected()){
					isSelect = true;
					strBiles.add(box.getText().trim());
				}
			}
			if(Common.isNotEmptyList(strBiles)){
				for(JLabel label : list0){
					if(Tools.isContain(label, strBiles)){
						temp.add(label);
					}
				}
			}
		}
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list0.removeAll(list0);
		}
		//直选 胆码 二次过滤
		if(Common.isNotEmptyList(list0)){
			list0 = convert(list0, temp);
			temp.removeAll(temp);
			isSelect = false;
			List<String> strBiles = new ArrayList<String>();
			for (JCheckBox	box : lottery3d.bilesChb2) {
				if(box.isSelected()){
					isSelect = true;
					strBiles.add(box.getText().trim());
				}
			}
			if(Common.isNotEmptyList(strBiles)){
				for(JLabel label : list0){
					if(Tools.isContain(label, strBiles)){
						temp.add(label);
					}
				}
			}
		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list0.removeAll(list0);
//		}
//		//直选 胆码 三次过滤
//		if(Common.isNotEmptyList(list0)){
//			list0 = convert(list0, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb3) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list0){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list0.removeAll(list0);
		}		
		//直选 胆码 四次过滤
//		if(Common.isNotEmptyList(list0)){
//			list0 = convert(list0, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb4) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list0){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list0.removeAll(list0);
//		}		
//		//直选 胆码 五次过滤
//		if(Common.isNotEmptyList(list0)){
//			list0 = convert(list0, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb5) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list0){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list0.removeAll(list0);
//		}		
//		//直选 胆码 六次过滤
//		if(Common.isNotEmptyList(list0)){
//			list0 = convert(list0, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb6) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list0){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list0.removeAll(list0);
//		}		
//		//直选 胆码 七次过滤
//		if(Common.isNotEmptyList(list0)){
//			list0 = convert(list0, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb7) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list0){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list0.removeAll(list0);
//		}		
//		//直选 胆码 八次过滤
//		if(Common.isNotEmptyList(list0)){
//			list0 = convert(list0, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb8) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list0){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list0.removeAll(list0);
		}		
		//直选 杀码 过滤
		if(Common.isNotEmptyList(list0)){
			list0 = convert(list0, temp);
			temp.removeAll(temp);
			isSelect = false;
			List<String> strBiles = new ArrayList<String>();
			for (JCheckBox	box : lottery3d.killChb) {
				if(box.isSelected()){
					isSelect = true;
					strBiles.add(box.getText().trim());
				}
			}
			if(Common.isNotEmptyList(strBiles)){
				for(JLabel label : list0){
					if(!Tools.isContain(label, strBiles)){
						temp.add(label);
					}
				}
			}
		}
		
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list0.removeAll(list0);
//		}
//		//组0几码组合
//		if(Common.isNotEmptyList(list0)){
//			list0 = convert(list0, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<JCheckBox> boxs = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.xCom.length; i++){
//				if(lottery3d.xCom[i].isSelected()){
//					isSelect = true;
//					boxs.add(lottery3d.xCom[i]);
//				}
//			}
//			List<JLabel> boxs2 = Tools.getComBoxList(list0,boxs);
//			if(boxs2 != null && boxs2.size() > 0){
//				for (JLabel jLabel : boxs2) {
//					temp.add(jLabel);
//				}
//			}
//		}
		//////////////////////////
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list0.removeAll(list0);
		}
		list0 = convert(list0, temp);
		temp.removeAll(temp);
		//第一组不定位胆码过滤
//		int n1 = Tools.thePlaceSixNum(list0, bilesGuolv());
//		if(n1 == 0){
//			list0.removeAll(list0);
//		};
//		//第二组不定位胆码过滤
//		int n2 = Tools.thePlaceSixNum(list0, sencondBilesGuolv());
//		if(n2 == 0){
//			list0.removeAll(list0);
//		};
		//号码012
		Tools.num012Condition(list0, lottery3d.num012Chb);
		//和值012
		Tools.sum012Condition(list0, lottery3d.sum012Chb);
		//跨度012
		Tools.span012Condition(list0, lottery3d.spanChb012);
		//和尾012
		Tools.sumWei012Condition(list0, lottery3d.sumWei012);
		//尾0-9
		Tools.sumWei0_9Condition(list0, lottery3d.sumWei0_9);
		//单双
//		Tools.oddevenCondition(list0, lottery3d.oddeven);
		//号码单双过滤
		Tools.numberOddEvenCondition2(list0, lottery3d.numberOddEven);
		//零二七九
		//Tools.n0279Condition(list0, lottery3d.n0279);
		// TODO Auto-generated method stub
	}
	/**
	 * 组3操作<p>
	 * <br> 
	 * return void<br>
	 */
	public void opertion3(List<JLabel> list3){
		//接收符合条件的数字
		List<JLabel> temp = new ArrayList<JLabel>();
		//组件是否被选中
		boolean isSelect = false;
		//组3 和值
		if(Common.isNotEmptyList(list3)){
			for(JCheckBox box : lottery3d.sumChbNum){
				if(box.isSelected()){
					isSelect = true;
					for (JLabel label : list3) {
						if(Integer.parseInt(box.getText()) == Tools.getLabSum(label)){
							temp.add(label);
						}
					}
				}
			}
		}
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list3.removeAll(list3);
		}
		//组3 跨度
		if(Common.isNotEmptyList(list3)){
			list3 = convert(list3, temp);
			temp.removeAll(temp);
			isSelect = false;
			for(int i = 0; i < lottery3d.spanChb.length; i++){
				if(lottery3d.spanChb[i].isSelected()){
					isSelect = true;
					int n = i ;
					for(JLabel label : list3){
						if(n == Tools.getSpan(label)){
							temp.add(label);
						}
					}
				}
			}
		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list3.removeAll(list3);
//		}
//		//组3 大小
//		if(Common.isNotEmptyList(list3)){
//			list3 = convert(list3, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			for(int i = 0; i < lottery3d.sizeChb.length; i++){
//				if(lottery3d.sizeChb[i].isSelected()){
//					isSelect = true;
//					for(JLabel label : list3){
//						if(i == Tools.getSize(label)){
//							temp.add(label);
//						}
//					}
//				}
//			}
//		}
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list3.removeAll(list3);
		}
		//胆码一次过滤
		if(Common.isNotEmptyList(list3)){
			list3 = convert(list3, temp);
			temp.removeAll(temp);
			isSelect = false;
			List<String> strBiles = new ArrayList<String>();
			for (JCheckBox	box : lottery3d.bilesChb1) {
				if(box.isSelected()){
					isSelect = true;
					strBiles.add(box.getText().trim());
				}
			}
			if(Common.isNotEmptyList(strBiles)){
				for(JLabel label : list3){
					if(Tools.isContain(label, strBiles)){
						temp.add(label);
					}
				}
			}
		}
		
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list3.removeAll(list3);
		}
		//胆码二次过滤
		if(Common.isNotEmptyList(list3)){
			list3 = convert(list3, temp);
			temp.removeAll(temp);
			isSelect = false;
			List<String> strBiles = new ArrayList<String>();
			for (JCheckBox	box : lottery3d.bilesChb2) {
				if(box.isSelected()){
					isSelect = true;
					strBiles.add(box.getText().trim());
				}
			}
			if(Common.isNotEmptyList(strBiles)){
				for(JLabel label : list3){
					if(Tools.isContain(label, strBiles)){
						temp.add(label);
					}
				}
			}
		}
		
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list3.removeAll(list3);
//		}
//		//胆码三次过滤
//		if(Common.isNotEmptyList(list3)){
//			list3 = convert(list3, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb3) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list3){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list3.removeAll(list3);
		}
		//胆码四次过滤
//		if(Common.isNotEmptyList(list3)){
//			list3 = convert(list3, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb4) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list3){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
		
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list3.removeAll(list3);
//		}
//		//胆码五次过滤
//		if(Common.isNotEmptyList(list3)){
//			list3 = convert(list3, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb5) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list3){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list3.removeAll(list3);
//		}
//		//胆码六次过滤
//		if(Common.isNotEmptyList(list3)){
//			list3 = convert(list3, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb6) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list3){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list3.removeAll(list3);
//		}
//		//胆码七次过滤
//		if(Common.isNotEmptyList(list3)){
//			list3 = convert(list3, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb7) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list3){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list3.removeAll(list3);
//		}
//		//胆码八次过滤
//		if(Common.isNotEmptyList(list3)){
//			list3 = convert(list3, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb8) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list3){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list3.removeAll(list3);
		}
		//杀码过滤
		if(Common.isNotEmptyList(list3)){
			list3 = convert(list3, temp);
			temp.removeAll(temp);
			isSelect = false;
			List<String> strBiles = new ArrayList<String>();
			for (JCheckBox	box : lottery3d.killChb) {
				if(box.isSelected()){
					isSelect = true;
					strBiles.add(box.getText().trim());
				}
			}
			if(Common.isNotEmptyList(strBiles)){
				for(JLabel label : list3){
					if(!Tools.isContain(label, strBiles)){
						temp.add(label);
					}
				}
			}
		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list3.removeAll(list3);
//		}
//		//组3几码组合
//		if(Common.isNotEmptyList(list3)){
//			list3 = convert(list3, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<JCheckBox> boxs = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.xCom.length; i++){
//				if(lottery3d.xCom[i].isSelected()){
//					isSelect = true;
//					boxs.add(lottery3d.xCom[i]);
//				}
//			}
//			List<JLabel> boxs2 = Tools.getComBoxList(list3,boxs);
//			if(boxs2 != null && boxs2.size() > 0){
//				for (JLabel jLabel : boxs2) {
//					temp.add(jLabel);
//				}
//			}
//		}
		//////////////////////////
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list3.removeAll(list3);
		}
		list3 = convert(list3, temp);
		temp.removeAll(temp);
		//第一组不定位胆码过滤
//		int n1 = Tools.thePlaceSixNum(list3, bilesGuolv());
//		if(n1 == 0){
//			list3.removeAll(list3);
//		};
//		//第二组不定位胆码过滤
//		int n2 = Tools.thePlaceSixNum(list3, sencondBilesGuolv());
//		if(n2 == 0){
//			list3.removeAll(list3);
//		};
		//号码012
		Tools.num012Condition(list3, lottery3d.num012Chb);
		//和值012
		Tools.sum012Condition(list3, lottery3d.sum012Chb);
		//跨度012
		Tools.span012Condition(list3, lottery3d.spanChb012);
		//和尾012
		Tools.sumWei012Condition(list3, lottery3d.sumWei012);
		//尾0-9
		Tools.sumWei0_9Condition(list3, lottery3d.sumWei0_9);
		//单双
		//Tools.oddevenCondition(list3, lottery3d.oddeven);
		//号码单双过滤
		Tools.numberOddEvenCondition2(list3, lottery3d.numberOddEven);
		//零二七九
		//Tools.n0279Condition(list3, lottery3d.n0279);
		// TODO Auto-generated method stub
	}
	
	/**
	 * 不定位胆码第一组过滤<p>
	 *  <br>
	 * @return void<br>
	 */
//	private List<List<JCheckBox>>  bilesGuolv(){
//		//不定位胆码第一位过滤
//		List<JCheckBox> bilesBoxs0 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.bilesChbOne.length; i++){
//			if(lottery3d.bilesChbOne[i].isSelected()){
//				bilesBoxs0.add(lottery3d.bilesChbOne[i]);
//			}
//		}
//		//不定位胆码第二位过滤
//		List<JCheckBox> bilesBoxs1 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.bilesChbTwo.length; i++){
//			if(lottery3d.bilesChbTwo[i].isSelected()){
//				bilesBoxs1.add(lottery3d.bilesChbTwo[i]);
//			}
//		}
//		//不定位胆码第三位过滤
//		List<JCheckBox> bilesBoxs2 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.bilesChbThree.length; i++){
//			if(lottery3d.bilesChbThree[i].isSelected()){
//				bilesBoxs2.add(lottery3d.bilesChbThree[i]);
//			}
//		}
//		//不定位胆码第四位过滤
//		List<JCheckBox> bilesBoxs3 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.bilesChbFour.length; i++){
//			if(lottery3d.bilesChbFour[i].isSelected()){
//				bilesBoxs3.add(lottery3d.bilesChbFour[i]);
//			}
//		}
//		//不定位胆码第五位过滤
//		List<JCheckBox> bilesBoxs4 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.bilesChbFive.length; i++){
//			if(lottery3d.bilesChbFive[i].isSelected()){
//				bilesBoxs4.add(lottery3d.bilesChbFive[i]);
//			}
//		}
//		//不定位胆码第六位过滤
//		List<JCheckBox> bilesBoxs5 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.bilesChbSix.length; i++){
//			if(lottery3d.bilesChbSix[i].isSelected()){
//				bilesBoxs5.add(lottery3d.bilesChbSix[i]);
//			}
//		}
//		List<List<JCheckBox>> listBiles = new ArrayList<List<JCheckBox>>();
//		if(bilesBoxs0 != null && bilesBoxs0.size() > 0){
//			listBiles.add(bilesBoxs0);
//		}
//		if(bilesBoxs1 != null && bilesBoxs1.size() > 0){
//			listBiles.add(bilesBoxs1);
//		}
//		if(bilesBoxs2 != null && bilesBoxs2.size() > 0){
//			listBiles.add(bilesBoxs2);
//		}
//		if(bilesBoxs3 != null && bilesBoxs3.size() > 0){
//			listBiles.add(bilesBoxs3);
//		}
//		if(bilesBoxs4 != null && bilesBoxs4.size() > 0){
//			listBiles.add(bilesBoxs4);
//		}
//		if(bilesBoxs5 != null && bilesBoxs5.size() > 0){
//			listBiles.add(bilesBoxs5);
//		}
//		if(listBiles != null && listBiles.size() == 1){
//			List<JCheckBox> bilesBoxstemp1 = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.bilesChbOne.length; i++){
//				bilesBoxstemp1.add(lottery3d.bilesChbOne[i]);
//			}
//			listBiles.add(bilesBoxstemp1);
//			List<JCheckBox> bilesBoxstemp2 = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.bilesChbOne.length; i++){
//				bilesBoxstemp2.add(lottery3d.bilesChbOne[i]);
//			}
//			listBiles.add(bilesBoxstemp2);
//		}else if(listBiles != null && listBiles.size() == 2){
//			List<JCheckBox> bilesBoxstemp1 = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.bilesChbOne.length; i++){
//				bilesBoxstemp1.add(lottery3d.bilesChbOne[i]);
//			}
//			listBiles.add(bilesBoxstemp1);
//		}
//		return listBiles;
//	}
	
//	/**
//	 * 不定位胆码第二组过滤<p>
//	 *  <br>
//	 * @return void<br>
//	 */
//	public List<List<JCheckBox>>  sencondBilesGuolv(){
//		//不定位胆码第一位过滤
//		List<JCheckBox> bilesBoxs0 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.secondBilesChbOne.length; i++){
//			if(lottery3d.secondBilesChbOne[i].isSelected()){
//				bilesBoxs0.add(lottery3d.secondBilesChbOne[i]);
//			}
//		}
//		//不定位胆码第二位过滤
//		List<JCheckBox> bilesBoxs1 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.secondBilesChbTwo.length; i++){
//			if(lottery3d.secondBilesChbTwo[i].isSelected()){
//				bilesBoxs1.add(lottery3d.secondBilesChbTwo[i]);
//			}
//		}
//		//不定位胆码第三位过滤
//		List<JCheckBox> bilesBoxs2 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.secondBilesChbThree.length; i++){
//			if(lottery3d.secondBilesChbThree[i].isSelected()){
//				bilesBoxs2.add(lottery3d.secondBilesChbThree[i]);
//			}
//		}
//		List<List<JCheckBox>> listBiles = new ArrayList<List<JCheckBox>>();
//		if(bilesBoxs0 != null && bilesBoxs0.size() > 0){
//			listBiles.add(bilesBoxs0);
//		}
//		if(bilesBoxs1 != null && bilesBoxs1.size() > 0){
//			listBiles.add(bilesBoxs1);
//		}
//		if(bilesBoxs2 != null && bilesBoxs2.size() > 0){
//			listBiles.add(bilesBoxs2);
//		}
//		if(listBiles != null && listBiles.size() == 1){
//			List<JCheckBox> bilesBoxstemp1 = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.secondBilesChbOne.length; i++){
//				bilesBoxstemp1.add(lottery3d.secondBilesChbOne[i]);
//			}
//			listBiles.add(bilesBoxstemp1);
//			List<JCheckBox> bilesBoxstemp2 = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.secondBilesChbOne.length; i++){
//				bilesBoxstemp2.add(lottery3d.secondBilesChbOne[i]);
//			}
//			listBiles.add(bilesBoxstemp2);
//		}else if(listBiles != null && listBiles.size() == 2){
//			List<JCheckBox> bilesBoxstemp1 = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.secondBilesChbOne.length; i++){
//				bilesBoxstemp1.add(lottery3d.secondBilesChbOne[i]);
//			}
//			listBiles.add(bilesBoxstemp1);
//		}
//		return listBiles;
//	}
//	
	/**
	 * 百十个过滤<p>
	 *  <br>
	 * @return void<br>
	 */
	//public List<List<JCheckBox>>  baiShiGeGuolv(){
//		//百过滤
//		List<JCheckBox> bilesBoxs0 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.bai.length; i++){
//			if(lottery3d.bai[i].isSelected()){
//				bilesBoxs0.add(lottery3d.bai[i]);
//			}
//		}
//		//不定位胆码第二位过滤
//		List<JCheckBox> bilesBoxs1 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.bilesChbTwo.length; i++){
//			if(lottery3d.bilesChbTwo[i].isSelected()){
//				bilesBoxs1.add(lottery3d.bilesChbTwo[i]);
//			}
//		}
//		//不定位胆码第三位过滤
//		List<JCheckBox> bilesBoxs2 = new ArrayList<JCheckBox>();
//		for(int i = 0; i < lottery3d.bilesChbThree.length; i++){
//			if(lottery3d.bilesChbThree[i].isSelected()){
//				bilesBoxs2.add(lottery3d.bilesChbThree[i]);
//			}
//		}
		List<List<JCheckBox>> listBiles = new ArrayList<List<JCheckBox>>();
//		if(bilesBoxs0 != null && bilesBoxs0.size() > 0){
//			listBiles.add(bilesBoxs0);
//		}
//		if(bilesBoxs1 != null && bilesBoxs1.size() > 0){
//			listBiles.add(bilesBoxs1);
//		}
//		if(bilesBoxs2 != null && bilesBoxs2.size() > 0){
//			listBiles.add(bilesBoxs2);
//		}
//		if(listBiles != null && listBiles.size() == 1){
//			List<JCheckBox> bilesBoxstemp1 = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.bilesChbOne.length; i++){
//				bilesBoxstemp1.add(lottery3d.bilesChbOne[i]);
//			}
//			listBiles.add(bilesBoxstemp1);
//			List<JCheckBox> bilesBoxstemp2 = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.bilesChbOne.length; i++){
//				bilesBoxstemp2.add(lottery3d.bilesChbOne[i]);
//			}
//			listBiles.add(bilesBoxstemp2);
//		}else if(listBiles != null && listBiles.size() == 2){
//			List<JCheckBox> bilesBoxstemp1 = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.bilesChbOne.length; i++){
//				bilesBoxstemp1.add(lottery3d.bilesChbOne[i]);
//			}
//			listBiles.add(bilesBoxstemp1);
//		}
//		return listBiles;
	//}
	
	/**
	 * 组6操作<p>
	 * <br> 
	 * return void<br>
	 */
	public void opertion6(List<JLabel> list6){
		//接收符合条件的数字
		List<JLabel> temp = new ArrayList<JLabel>();
		//组件是否被选中
		boolean isSelect = false;
		//组6 和值
		if(Common.isNotEmptyList(list6)){
			for(JCheckBox box : lottery3d.sumChbNum){
				if(box.isSelected()){
					isSelect = true;
					for (JLabel label : list6) {
						if(Integer.parseInt(box.getText()) == Tools.getLabSum(label)){
							temp.add(label);
						}
					}
				}
			}
		}
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list6.removeAll(list6);
		}
		// 跨度
		if(Common.isNotEmptyList(list6)){
			list6 = convert(list6, temp);
			temp.removeAll(temp);
			isSelect = false;
			for(int i = 0; i < lottery3d.spanChb.length; i++){
				if(lottery3d.spanChb[i].isSelected()){
					isSelect = true;
					int n = i ;
					for(JLabel label : list6){
						if(n == Tools.getSpan(label)){
							temp.add(label);
						}
					}
				}
			}
		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list6.removeAll(list6);
//		}
//		//组6 大小
//		if(Common.isNotEmptyList(list6)){
//			list6 = convert(list6, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			for(int i = 0; i < lottery3d.sizeChb.length; i++){
//				if(lottery3d.sizeChb[i].isSelected()){
//					isSelect = true;
//					for(JLabel label : list6){
//						if(i == Tools.getSize(label)){
//							temp.add(label);
//						}
//					}
//				}
//			}
//		}
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list6.removeAll(list6);
		}
		//胆码 一次过滤
		if(Common.isNotEmptyList(list6)){
			list6 = convert(list6, temp);
			temp.removeAll(temp);
			isSelect = false;
			List<String> strBiles = new ArrayList<String>();
			for (JCheckBox	box : lottery3d.bilesChb1) {
				if(box.isSelected()){
					isSelect = true;
					strBiles.add(box.getText().trim());
				}
			}
			if(Common.isNotEmptyList(strBiles)){
				for(JLabel label : list6){
					if(Tools.isContain(label, strBiles)){
						temp.add(label);
					}
				}
			}
		}
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list6.removeAll(list6);
		}
		//胆码 二次过滤
		if(Common.isNotEmptyList(list6)){
			list6 = convert(list6, temp);
			temp.removeAll(temp);
			isSelect = false;
			List<String> strBiles = new ArrayList<String>();
			for (JCheckBox	box : lottery3d.bilesChb2) {
				if(box.isSelected()){
					isSelect = true;
					strBiles.add(box.getText().trim());
				}
			}
			if(Common.isNotEmptyList(strBiles)){
				for(JLabel label : list6){
					if(Tools.isContain(label, strBiles)){
						temp.add(label);
					}
				}
			}
		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list6.removeAll(list6);
//		}
//		//胆码 三次过滤
//		if(Common.isNotEmptyList(list6)){
//			list6 = convert(list6, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb3) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list6){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list6.removeAll(list6);
//		}
		//胆码 四次过滤
//		if(Common.isNotEmptyList(list6)){
//			list6 = convert(list6, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb4) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list6){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list6.removeAll(list6);
//		}
//		//胆码 五次过滤
//		if(Common.isNotEmptyList(list6)){
//			list6 = convert(list6, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb5) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list6){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list6.removeAll(list6);
//		}
//		//胆码 六次过滤
//		if(Common.isNotEmptyList(list6)){
//			list6 = convert(list6, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb6) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list6){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list6.removeAll(list6);
//		}
//		//胆码 七次过滤
//		if(Common.isNotEmptyList(list6)){
//			list6 = convert(list6, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb7) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list6){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list6.removeAll(list6);
//		}
//		//胆码 八次过滤
//		if(Common.isNotEmptyList(list6)){
//			list6 = convert(list6, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<String> strBiles = new ArrayList<String>();
//			for (JCheckBox	box : lottery3d.bilesChb8) {
//				if(box.isSelected()){
//					isSelect = true;
//					strBiles.add(box.getText().trim());
//				}
//			}
//			if(Common.isNotEmptyList(strBiles)){
//				for(JLabel label : list6){
//					if(Tools.isContain(label, strBiles)){
//						temp.add(label);
//					}
//				}
//			}
//		}
		//有条件，但是没有查找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list6.removeAll(list6);
		}
		//杀码过滤
		if(Common.isNotEmptyList(list6)){
			list6 = convert(list6, temp);
			temp.removeAll(temp);
			isSelect = false;
			List<String> strBiles = new ArrayList<String>();
			for (JCheckBox	box : lottery3d.killChb) {
				if(box.isSelected()){
					isSelect = true;
					strBiles.add(box.getText().trim());
				}
			}
			if(Common.isNotEmptyList(strBiles)){
				for(JLabel label : list6){
					if(!Tools.isContain(label, strBiles)){
						temp.add(label);
					}
				}
			}
		}
//		//有条件，但是没有查找到数字
//		if(!Common.isNotEmptyList(temp) && isSelect){
//			list6.removeAll(list6);
//		}
//		//组6几码组合
//		if(Common.isNotEmptyList(list6)){
//			list6 = convert(list6, temp);
//			temp.removeAll(temp);
//			isSelect = false;
//			List<JCheckBox> boxs = new ArrayList<JCheckBox>();
//			for(int i = 0; i < lottery3d.xCom.length; i++){
//				if(lottery3d.xCom[i].isSelected()){
//					isSelect = true;
//					boxs.add(lottery3d.xCom[i]);
//				}
//			}
//			List<JLabel> boxs2 = Tools.getComBoxList(list6,boxs);
//			if(boxs2 != null && boxs2.size() > 0){
//				for (JLabel jLabel : boxs2) {
//					temp.add(jLabel);
//				}
//			}
//		}
		//////////////////////////
		//有条件，但是没有找到数字
		if(!Common.isNotEmptyList(temp) && isSelect){
			list6.removeAll(list6);
		}
		list6 = convert(list6, temp);
		temp.removeAll(temp);
		//不定位胆码第N位过滤
//		//第一组不定位胆码过滤
//		int n1 = Tools.thePlaceSixNum(list6, bilesGuolv());
//		if(n1 == 0){
//			list6.removeAll(list6);
//		};
//		//第二组不定位胆码过滤
//		int n2 = Tools.thePlaceSixNum(list6, sencondBilesGuolv());
//		if(n2 == 0){
//			list6.removeAll(list6);
//		};
		//号码012
		Tools.num012Condition(list6, lottery3d.num012Chb);
		//和值012
		Tools.sum012Condition(list6, lottery3d.sum012Chb);
		//跨度012
		Tools.span012Condition(list6, lottery3d.spanChb012);
		//和尾012
		Tools.sumWei012Condition(list6, lottery3d.sumWei012);
		//尾0-9
		Tools.sumWei0_9Condition(list6, lottery3d.sumWei0_9);
		//单双
		//Tools.oddevenCondition(list6, lottery3d.oddeven);
		//号码单双过滤
		Tools.numberOddEvenCondition2(list6, lottery3d.numberOddEven);
		//零二七九
		//Tools.n0279Condition(list6, lottery3d.n0279);
		// TODO Auto-generated method stub
	}
	
	/**
	 * 如果list2不为空，将list2的值赋给list<p>
	 * @param list<br> 
	 * return void<br>
	 */
	public List<JLabel> convert(List<JLabel> list,List<JLabel> list2){
		if(!Common.isNotEmptyList(list)){
			return null;
		}else{
			if(Common.isNotEmptyList(list2)){
				list.removeAll(list);
				for (JLabel jLabel : list2) {
					list.add(jLabel);
				}
			}
		}
		return list;
	}
	/**
	 * 将所有号码设置为不可见<p>
	 * <br> 
	 * return void<br>
	 */
	public void setAllNotVisible(){
		for(JLabel label : lottery3d.lb000){
			label.setVisible(false);
		}
		for(JLabel label : lottery3d.lb001){
			label.setVisible(false);
		}
		for(JLabel label : lottery3d.lb012){
			label.setVisible(false);
		}
	}
	
	/**
	 * 将所有号码设置为可见<p>
	 * <br> 
	 * return void<br>
	 */
	public void setAllVisible(){
		for(JLabel label : lottery3d.lb000){
			label.setVisible(true);
		}
		for(JLabel label : lottery3d.lb001){
			label.setVisible(true);
		}
		for(JLabel label : lottery3d.lb012){
			label.setVisible(true);
		}
	}
	/**
	 * 设置重新选择按钮<p>
	 * <br> 
	 * return void<br>
	 */
	public void setCancleBtnAction(){
		lottery3d.cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lottery3d.sumChb.setSelected(true);
				lottery3d.rChb.setSelected(true);
				lottery3d.rChb3.setSelected(true);
				lottery3d.rChb6.setSelected(true);
				for(JCheckBox checkBox : lottery3d.sumChbNum){
					checkBox.setSelected(true);
				}
				//setCheckBoxNoSelected(lottery3d.sizeChb);
				setCheckBoxNoSelected(lottery3d.spanChb);
				setCheckBoxNoSelected(lottery3d.killChb);
				setCheckBoxNoSelected(lottery3d.bilesChb1);
				setCheckBoxNoSelected(lottery3d.bilesChb2);
//				setCheckBoxNoSelected(lottery3d.bilesChb3);
//				setCheckBoxNoSelected(lottery3d.bilesChb4);
//				setCheckBoxNoSelected(lottery3d.bilesChbOne);
//				setCheckBoxNoSelected(lottery3d.bilesChbTwo);
//				setCheckBoxNoSelected(lottery3d.bilesChbThree);
//				setCheckBoxNoSelected(lottery3d.junkoChb);
//				setCheckBoxNoSelected(lottery3d.xCom);
				setCheckBoxNoSelected(lottery3d.num012Chb);
				setCheckBoxNoSelected(lottery3d.sum012Chb);
				setCheckBoxNoSelected(lottery3d.spanChb012);
				setCheckBoxNoSelected(lottery3d.sumWei012);
				setCheckBoxNoSelected(lottery3d.sumWei0_9);
//				setCheckBoxNoSelected(lottery3d.oddeven);
				setCheckBoxNoSelected(lottery3d.numberOddEven);
			//	setCheckBoxNoSelected(lottery3d.n0279);
			//	setCheckBoxNoSelected(lottery3d.n27);
//				setCheckBoxNoSelected(lottery3d.secondBilesChbOne);
//				setCheckBoxNoSelected(lottery3d.secondBilesChbTwo);
//				setCheckBoxNoSelected(lottery3d.secondBilesChbThree);
//				setCheckBoxNoSelected(lottery3d.weCB);
//				setCheckBoxNoSelected(lottery3d.ds_xdCB);
				//setCheckBoxNoSelected(lottery3d.heCB);
//				setCheckBoxNoSelected(lottery3d.zbCB);
//				setCheckBoxNoSelected(lottery3d.DS_XDCB);
				setCheckBoxNoSelected(lottery3d.spanChbShortcut);
				setCheckBoxNoSelected(lottery3d.sumChbShortcut);
//				setCheckBoxNoSelected(lottery3d.tboz);
//				setCheckBoxNoSelected(lottery3d.tb);
//				setCheckBoxNoSelected(lottery3d.sumTBtb);
				setCheckBoxNoSelected(lottery3d.c015);
				//setCheckBoxNoSelected(lottery3d.bilesRe1);
				//setCheckBoxNoSelected(lottery3d.bilesRe2);
				//setCheckBoxNoSelected(lottery3d.c27);
				setCheckBoxNoSelected(lottery3d.hw);
				setCheckBoxNoSelected(lottery3d.kd);
				setCheckBoxNoSelected(lottery3d.oz);
//				setCheckBoxNoSelected(lottery3d.tt1bt1);
//				setCheckBoxNoSelected(lottery3d.ttbt);
//				setCheckBoxNoSelected(lottery3d.tt0bt0);
				setCheckBoxNoSelected(lottery3d.kh);
//				setCheckBoxNoSelected(lottery3d.uk1);
//				setCheckBoxNoSelected(lottery3d.hkw);
//				setCheckBoxNoSelected(lottery3d.hwh);
				setCheckBoxNoSelected(lottery3d.startTB);
				//setCheckBoxNoSelected(lottery3d.tbNew);
				//setCheckBoxNoSelected(lottery3d.tbSub);
				//setCheckBoxNoSelected(lottery3d.tbAdd);
				//setCheckBoxNoSelected(lottery3d.ttbb);
			//	setCheckBoxNoSelected(lottery3d.c123);
			//	setCheckBoxNoSelected(lottery3d.equalOrNo);
			//	setCheckBoxNoSelected(lottery3d.tbThree);
				setCheckBoxNoSelected(lottery3d.ttbbSecond);
				setCheckBoxNoSelected(lottery3d.differ);
				setCheckBoxNoSelected(lottery3d.kw);
				setCheckBoxNoSelected(lottery3d.jjf);
				setCheckBoxNoSelected(lottery3d.fhx);
				setCheckBoxNoSelected(lottery3d.kwDiff);
				setCheckBoxNoSelected(lottery3d.sgl);
				setCheckBoxNoSelected(lottery3d.xxdd);
				setCheckBoxNoSelected(lottery3d.setn);
				setCheckBoxNoSelected(lottery3d.zsen);
				setCheckBoxNoSelected(lottery3d.starCircle);
				setCheckBoxNoSelected(lottery3d.tbFour);
				setAllVisible();
				lottery3d.lbNum.setText(lottery3d.lbNumText);
			}
		});
	}
	
	/**
	 * 将条件设置为未选中状态
	 * @param arry
	 */
	private void setCheckBoxNoSelected(JCheckBox[] arry){
		for(JCheckBox box:arry){
			if(box != null)
			box.setSelected(false);
		}
	}
//	/**
//	 * 将条件设置为选中状态
//	 * @param arry
//	 */
//	private void setCheckBoxSelected(JCheckBox[] arry){
//		for(JCheckBox box:arry){
//			box.setSelected(true);
//		}
//	}
	
	/**
	 * 共有的算法，不必每个类型的数据调用同样的方法
	 * @param list0
	 * @param list3
	 * @param list6
	 */
	private void opertionAll(List<JLabel> list0,List<JLabel> list3,List<JLabel> list6){
		//和 中边显示
		Tools.commonXMLCodtion(lottery3d.sumChbShortcut, "sumChbShortcut", list0,list3,list6);
		//跨 中边显示
		Tools.commonXMLCodtion(lottery3d.spanChbShortcut, "spanChbShortcut", list0,list3,list6);
		//77、II、ZZ、99
		//Tools.commonXMLCodtion(lottery3d.junkoChb, "junkoChb", list0,list3,list6);
		//WE
		//Tools.commonXMLCodtion(lottery3d.weCB, "weCB", list0,list3,list6);
		//ds-xd
//		Tools.commonXMLCodtion(lottery3d.ds_xdCB, "ds_xdCB", list0,list3,list6);
		//HE
		//Tools.commonXMLCodtion(lottery3d.heCB, "heCB", list0,list3,list6);
		//DS-XD
		//Tools.commonXMLCodtion(lottery3d.DS_XDCB, "DS_XDCB", list0,list3,list6);
		//ZB
		//Tools.commonXMLCodtion(lottery3d.zbCB, "zbCB", list0,list3,list6);
		//二七反正显
	//	Tools.n27Condition(lottery3d.n27, list0,list3,list6);
//		//BTOZ
//		Tools.tbozCondition(lottery3d.tboz, list0,list3,list6);
		//TB反正显
//		Tools.tbCondition(lottery3d.tb, list0,list3,list6);
		//sumTBtb
		//Tools.sumTBtbCondition(lottery3d.sumTBtb, list0,list3,list6);
		//和尾
		Tools.hwCondition(lottery3d.hw, list0,list3,list6);
		//跨度
		Tools.kdCondition(lottery3d.kd, list0,list3,list6);
		//C0 15
		Tools.c015Condition(lottery3d.c015, list0,list3,list6);
		//OZ
		Tools.ozCondition(lottery3d.oz, list0,list3,list6);
		//不定位胆码反显
		//Tools.bilesReCondition(Tools.bilesReMap(lottery3d.bilesRe1,lottery3d.bilesRe2), list0,list3,list6);
		//c27
		//Tools.c27Condition(lottery3d.c27, list0,list3,list6);
		//ttbt
//		Tools.ttbtCondition(lottery3d.ttbt, list0,list3,list6);
		//tt1bt1
//		Tools.tt1bt1Condition(lottery3d.tt1bt1, list0,list3,list6);
		
//		Tools.xmlDataCondition(lottery3d.tt0bt0,"tt0bt0", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.kh,"kh", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.startTB,"startTB", list0,list3,list6);
	//	Tools.xmlDataCondition(lottery3d.hkw,"hkw", list0,list3,list6);
	//	Tools.xmlDataCondition(lottery3d.hwh,"hwh", list0,list3,list6);
	//	Tools.xmlDataCondition(lottery3d.tbAdd,"tb_add", list0,list3,list6);
	//	Tools.xmlDataCondition(lottery3d.tbSub,"tb_sub", list0,list3,list6);
	//	Tools.tbNewCondition(lottery3d.tbNew, list0,list3,list6);
//		Tools.xmlDataCondition(lottery3d.uk1,"uk1", list0,list3,list6);
	//	Tools.xmlDataCondition(lottery3d.ttbb,"ttbb", list0,list3,list6);
	//	Tools.xmlDataCondition(lottery3d.equalOrNo,"equalOrNo", list0,list3,list6);
		//Tools.xmlDataCondition(lottery3d.c123,"c123", list0,list3,list6);
	//	Tools.xmlDataCondition(lottery3d.tbThree,"tbThree", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.ttbbSecond,"ttbbSecond", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.differ,"differ", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.kw,"kw", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.jjf,"jjf", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.kwDiff,"kwDiff", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.sgl,"sgl", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.xxdd,"xxdd", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.setn,"setn", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.zsen,"zsen", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.fhx,"fhx", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.starCircle,"starCircle", list0,list3,list6);
		Tools.xmlDataCondition(lottery3d.tbFour,"tbFour", list0,list3,list6);
		//TODO 所有方法调用 opertionALL
	}
}
