package lottery.frame;

import javax.swing.JCheckBox;

import lottery.logic.CheckEnvent;

/**
 * 其他选项是否被选择<p>
 * @author DuanQingwei  @date 2012-10-1 <br>
 * @version 1.0 <br>
 */
public class SelectType {

	/**
	 * 判断是否设置了其他条件<p>
	 * @return<br> 
	 * return boolean<br>
	 */
	public static  boolean isAllNotSelect(){
		//如果其他条件都没被选择，则全部显示
		boolean isAllNotSelected = true;
		if(isAllNotSelected){
			for(JCheckBox box : CheckEnvent.lottery3d.sumChbNum){
				if(box.isSelected()){
					isAllNotSelected = false;
					break;
				}
			}
		}
		if(isAllNotSelected){
			for(JCheckBox box : CheckEnvent.lottery3d.spanChb){
				if(box.isSelected()){
					isAllNotSelected = false;
					break;
				}
			}
		}
//		if(isAllNotSelected){
//			for(JCheckBox box :CheckEnvent.lottery3d.sizeChb){
//				if(box.isSelected()){
//					isAllNotSelected = false;
//					break;
//				}
//			}
//		}
		if(isAllNotSelected){
			for(JCheckBox box : CheckEnvent.lottery3d.bilesChb1){
				if(box.isSelected()){
					isAllNotSelected = false;
					break;
				}
			}
		}
		if(isAllNotSelected){
			for(JCheckBox box : CheckEnvent.lottery3d.bilesChb2){
				if(box.isSelected()){
					isAllNotSelected = false;
					break;
				}
			}
		}
		
		if(isAllNotSelected){
			for(JCheckBox box : CheckEnvent.lottery3d.killChb){
				if(box.isSelected()){
					isAllNotSelected = false;
					break;
				}
			}
		}
		
//		if(isAllNotSelected){
//			for(JCheckBox box : CheckEnvent.lottery3d.junkoChb){
//				if(box.isSelected()){
//					isAllNotSelected = false;
//					break;
//				}
//			}
//		}
		return isAllNotSelected;
	}
}
