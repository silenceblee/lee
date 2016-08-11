package lottery.frame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 或得JLabel的各种值<p>
 * @author DuanQingwei  @date 2012-9-21 <br>
 * @version 1.0 <br>
 */
public class Tools {

//	/**和 数据集合*/
//	private static Map<String,Set<String>> sumChbShortcutMap = new HashMap<String, Set<String>>();
//	/**跨 数据集合*/
//	private static Map<String,Set<String>> spanChbShortcutMap = new HashMap<String, Set<String>>();
//	
	/**xml定义的数据集*/
	private static Map<String,Map<String,Set<String>>> xmlMap = new HashMap<String, Map<String,Set<String>>>();
	static{
		try{
			SAXReader reader = new SAXReader();
			Document doc = reader.read(Tools.class.getResourceAsStream("/lottery/data/data.xml"));
			Element root = doc.getRootElement();
			for(Iterator<?> typeEle=root.elementIterator("type");typeEle.hasNext();){
				Element type = (Element) typeEle.next();
				String id = type.elementText("id");
				if(id != null && !"".equals(id)){
					Map<String,Set<String>> dataMap = new HashMap<String, Set<String>>();
					for(Iterator<?> mapEle=type.elementIterator("map");mapEle.hasNext();){
						Element map = (Element) mapEle.next();
						String key = map.elementText("key");
						String[] values = map.elementText("value").split(",");
						Set<String> set = new HashSet<String>();
						Collections.addAll(set, values);
						dataMap.put(key, set);
					}
					xmlMap.put(id, dataMap);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static Map<String, Map<String, Set<String>>> getXmlMap() {
		return xmlMap;
	}

	/**
	 * 取得JLabel和值<p>
	 * @param label
	 * @return<br> 
	 * return int<br>
	 */
	public static int getLabSum(JLabel label){
		if(label == null){
			return -1;
		}
		try{
			String labText = label.getText();
			int number = 0;
			for(int i = 0; i < labText.length(); i++){
				number += Integer.parseInt(""+labText.charAt(i));
			}
		    return number;
		}catch (Exception e) {
			 return -1;
		}
	}
	
	/**
	 * 取得JLabel跨度<p>
	 * @param label
	 * @return<br> 
	 * return int<br>
	 */
	public static int getSpan(JLabel label){
		if(label == null){
			return -1;
		}
		try{
			String labText = label.getText();
			int numbers[] = new int[labText.length()];
			for(int i = 0; i < labText.length(); i++){
				numbers[i] = Integer.parseInt(""+labText.charAt(i));
			}
		    return getMax(numbers) - getMin(numbers);
		}catch (Exception e) {
			 return -1;
		}
	}
	/**
	 * 获取数组最大值<p>
	 * @param num
	 * @return<br> 
	 * return int<br>
	 */
	public static  int getMax(int num[]){
		int temp = num[0];;
		for (int i = 0; i < num.length - 1; i++) {
			if(num[i] < num[i + 1]){
				temp = num[i + 1];
			}
		}
		return temp;
	}
	/**
	 * 获取数组最小值<p>
	 * @param num
	 * @return<br> 
	 * return int<br>
	 */
	public static  int getMin(int num[]){
		int temp = num[0];;
		for (int i = 0; i < num.length - 1; i++) {
			if(num[i] > num[i + 1]){
				temp = num[i + 1];
			}
		}
		return temp;
	}
	/**
	 * 大小判断<p>
	 * @return<br> 
	 * return int（0：小小小 ，1：小小大，2：小大大，3：大大大）<br>
	 */
	public static int getSize(JLabel label){
		if(label == null){
			return -1;
		}
		try{
			String labText = label.getText();
			if(Integer.parseInt(""+labText.charAt(0)) < 5 && Integer.parseInt(""+labText.charAt(1)) < 5 && Integer.parseInt(""+labText.charAt(2)) < 5){
				return 0;
			}else if(Integer.parseInt(""+labText.charAt(0)) < 5 && Integer.parseInt(""+labText.charAt(1)) < 5 && Integer.parseInt(""+labText.charAt(2)) >= 5){
				return 1;
			}else if(Integer.parseInt(""+labText.charAt(0)) >= 5 && Integer.parseInt(""+labText.charAt(1)) < 5 && Integer.parseInt(""+labText.charAt(2)) < 5){
				return 1;
			}else if(Integer.parseInt(""+labText.charAt(0)) < 5 && Integer.parseInt(""+labText.charAt(1)) >= 5 && Integer.parseInt(""+labText.charAt(2)) < 5){
				return 1;
			}else if(Integer.parseInt(""+labText.charAt(0)) < 5 && Integer.parseInt(""+labText.charAt(1)) >= 5 && Integer.parseInt(""+labText.charAt(2)) >= 5){
				return 2;
			}else if(Integer.parseInt(""+labText.charAt(0)) >= 5 && Integer.parseInt(""+labText.charAt(1)) < 5 && Integer.parseInt(""+labText.charAt(2)) >= 5){
				return 2;
			}else if(Integer.parseInt(""+labText.charAt(0)) >= 5 && Integer.parseInt(""+labText.charAt(1)) >= 5 && Integer.parseInt(""+labText.charAt(2)) < 5){
				return 2;
			}else if(Integer.parseInt(""+labText.charAt(0)) >= 5 && Integer.parseInt(""+labText.charAt(1)) >= 5 && Integer.parseInt(""+labText.charAt(2)) >= 5){
				return 3;
			}else{
				return -1;
			}
		}catch (Exception e) {
			 return -1;
		}
	}
	
	/**
	 * 不定位胆码判断<p>
	 * @param label
	 * @param strBiles
	 * @return<br> 
	 * return boolean<br>
	 */
	public static boolean isContain(JLabel label,List<String> strBiles){
		boolean flag = false;
		try{
			String labText = label.getText();
			for (String string : strBiles) {
				if(labText.contains(string)){
					flag = true;
				}
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 不定位胆码第N位判断<p>
	 * @param labs 显示去数字
	 * @param boxs 第N位要显示的数字 
	 * @param num 第N位(0,1,2)<br>
	 * @return void<br>
	 */
	public static void bilesPlace(List<JLabel> labs,List<JCheckBox> boxs,int num,String string){
		if(labs != null && labs.size() > 0 && boxs != null && boxs.size() > 0){
			 for(int i =0; i < labs.size(); ){
				 String labText = labs.get(i).getText().trim();
				 if(labText.length() >= 3 && num <= 2){
					 String numChar = labText.charAt(num)+"";//第Num为位数字
					 boolean isContain = false;
					 for(JCheckBox box : boxs){
						 String n = box.getText();
						 if(numChar.trim().equals(n.trim())){
							 isContain = true;//第num 位包含在boxs数字中
						 }
					 }
					 if(!isContain){ //不包含，去掉该lab
						 labs.remove(i);
					 }else{ //进入下一次循环
						 i++;
					 }
				 }
			 }
		}
	}
	/**
	 * 由大到小，冒泡排序<p>
	 * @param list
	 * @return <br>
	 * @return String[]<br>
	 */
    public static String[] bubbleSort(String[] list) 
    { 
       int i;
       String temp;
       for (int j = 0; j < list.length; j++) 
       { 
           for (i = list.length - 1; i > j; i--) 
           { 
               if (list[j].compareTo(list[i]) > 0) 
               { 
                   temp = list[j]; 
                   list[j] = list[i]; 
                   list[i] = temp; 
               } 
           } 
       } 

       return list; 
    }
 
    /**
     *  不定位胆码位数过滤<p>
     * @param labs
     * @param boxs 已勾选了不定位胆码组数<br>
     * @return -1 不做操作  0 不合条件 1 和条件<br>
     */
    public static int thePlaceSixNum(List<JLabel> labs,List<List<JCheckBox>> boxs){
    	if(boxs != null && boxs.size() > 0){
    		//勾选了三个以内
    		if(boxs.size() == 3){
    			List<JCheckBox> boxs0 = boxs.get(0);
    			List<JCheckBox> boxs1 = boxs.get(1);
    			List<JCheckBox> boxs2 = boxs.get(2);
    			thePlaceNum(labs, boxs0, boxs1, boxs2);
    			return 1;
    		}else if(boxs.size() > 3){
    			//组合的多位数(3个以上)
    			Set<String> dataSetAll = new HashSet<String>();
//    			List<String> dataSet = new ArrayList<String>();
    			List<JCheckBox> boxs0 = boxs.get(0);
    			List<JCheckBox> boxs1 = boxs.get(1);
    			List<JCheckBox> boxs2 = boxs.get(2);
    			List<JCheckBox> boxs3 = boxs.get(3);
    			List<JCheckBox> boxs4 = null;
    			List<JCheckBox> boxs5 = null;
    			if(boxs.size() == 5)
    				boxs4 = boxs.get(4);
    			if(boxs.size() == 6){
    				boxs4 = boxs.get(4);
    				boxs5 = boxs.get(5);
    			}
    			for (int i = 0; i < boxs0.size(); i++) {
					String txt0 = boxs0.get(i).getText().trim();
					for (int j = 0; j < boxs1.size(); j++) {
						String txt1 = boxs1.get(j).getText().trim();
						for (int k = 0; k < boxs2.size(); k++) {
							String txt2 = boxs2.get(k).getText().trim();
							for (int l = 0; l < boxs3.size(); l++) {
								String txt3 = boxs3.get(l).getText().trim();
								if(boxs4 != null && boxs4.size() > 0){
									for (int m = 0; m < boxs4.size(); m++) {
										String txt4 = boxs4.get(m).getText().trim();
										if(boxs5 != null && boxs5.size() > 0){
											for (int n = 0; n < boxs5.size(); n++) {
												String txt5 = boxs5.get(n).getText().trim();
												String[] strs = bubbleSort(new String[]{txt0,txt1,txt2,txt3,txt4,txt5});
												String num = "";
												for (String str : strs) {
													num += str;
												}
												dataSetAll.add(num);
											}
										}else{
											String[] strs = bubbleSort(new String[]{txt0,txt1,txt2,txt3,txt4});
											String num = "";
											for (String str : strs) {
												num += str;
											}
											dataSetAll.add(num);
										}
									}
								}else{
									String[] strs = bubbleSort(new String[]{txt0,txt1,txt2,txt3});
									String num = "";
									for (String str : strs) {
										num += str;
									}
									dataSetAll.add(num);
								}
							}
						}
					}
				}
    			if(dataSetAll != null && dataSetAll.size() > 0){
	    			//除去有3个以上的数字
	    			Set<String> dataSet = new HashSet<String>();
	    			for (Iterator<String> it = dataSetAll.iterator(); it.hasNext();) {
						String str = it.next();
						Set<Character> set = new HashSet<Character>();
						for (int j = 0; j < str.length(); j++) {
							set.add(str.charAt(j));
						}
						if(set.size() <= 3){
							dataSet.add(str);
						}
					}
	    			if(dataSet != null && dataSet.size() > 0){
	    				//最终组成的三位数
	    				Set<String> nums = new HashSet<String>();
	    				for(Iterator<String> it = dataSet.iterator(); it.hasNext();){
	    					String str = it.next();
	    					//判断词组数字有多少个（1-3个）
	    					Set<Character> setN = new HashSet<Character>();
	    					for (int i = 0; i < str.length(); i++) {
	    						setN.add(str.charAt(i));
							}
	    					if(setN.size() == 1){//组成一个直选数
	    						nums.add(str.substring(0,3));
	    					}else{//组成非直选的3位数
	    						for (int i = 0; i < str.length() - 2; i++) {
	    							String txt0 = str.charAt(i)+"";
	    							for (int j = i + 1; j < str.length() - 1 ; j++) {
										String txt1 = str.charAt(j) + "";
										for (int k = j + 1; k < str.length(); k++) {
											String txt2 = str.charAt(k) + "";
											if(txt0.equals(txt1) && txt0.equals(txt2)){
												//组成的直选过滤掉
											}else{
												String num = "";
												if(setN.size() == 2){ //组成组3数
													if(txt0.equals(txt1)){
					    								num = txt0 + txt1 + txt2;
					    							}else if(txt0.equals(txt2)){
					    								num = txt0 + txt2 + txt1;
					    							}else if(txt1.equals(txt2)){
					    								num = txt1 + txt2 + txt0;
					    							}
													if(!"".equals(num)){
														nums.add(num);
													}
												}else if(setN.size() == 3){//组成组6数
													if(txt0.equals(txt1)){
														//过滤掉组3数
					    							}else if(txt0.equals(txt2)){
					    								//过滤掉组3数
					    							}else if(txt1.equals(txt2)){
					    								//过滤掉组3数
					    							}else{
					    								String[] strs = bubbleSort(new String[]{txt0,txt1,txt2});
					    								for (String string : strs) {
					    									num += string;
					    								}
					    								nums.add(num);
					    							}
				    							}
											}
										}
									}
								}
	    					}
	    				}
	    				removeNotContainNum(labs, nums);
        				return 1;
	    			}else{
	    				return 0;
	    			}
    			}else{
    				return 0;	
    			}
    		}
    	}
    	return -1;
    }
    
    
    
    /**
     * 不定位胆码位数过滤<p>
     * @param labs
     * @param boxs0 第一位所选数字
     * @param boxs1 第二位所选数字
     * @param boxs2 第三位所选数字 <br>
     * @return void<br>
     */
	public static void thePlaceNum(List<JLabel> labs,List<JCheckBox> boxs0,List<JCheckBox> boxs1,List<JCheckBox> boxs2){
			if(labs != null && labs.size() > 0){
				Set<String> nums = new HashSet<String>();
				for (JCheckBox box0 : boxs0) {
					String txt0 = box0.getText().trim();
					for(JCheckBox box1 : boxs1){
						String txt1 = box1.getText().trim();
						for(JCheckBox box2 : boxs2){
							String txt2 = box2.getText().trim();
							String num = "";
							if(txt0.equals(txt1)){
								num = txt0 + txt1 + txt2;
							}else if(txt0.equals(txt2)){
								num = txt0 + txt2 + txt1;
							}else if(txt1.equals(txt2)){
								num = txt1 + txt2 + txt0;
							}else{
								String[] strs = bubbleSort(new String[]{txt0,txt1,txt2});
								for (String string : strs) {
									num += string;
								}
							}
							nums.add(num);
						}
					}
				}
				removeNotContainNum(labs, nums);
			}
	}
	
	/**
	 *  删除不包含的数组<p>
	 * @param labs
	 * @param nums <br>
	 * @return void<br>
	 */
	public static void removeNotContainNum(List<JLabel> labs,Set<String> nums){
		if(labs != null && labs.size() > 0){
			if(nums != null && nums.size() > 0){
				for(int i = 0; i < labs.size();){
					String txt = labs.get(i).getText().trim();
					boolean isContain = false;
					for(String str : nums){
						if(txt.equals(str)){
							isContain = true;
							break;
						}
					} 
					if(isContain){
						i++;
					}else{
						labs.remove(i);
					}
				}
			}
		}
	}
	/**
	 * 是否是顺子<p>
	 * @param label
	 * @return<br> 
	 * return boolean<br>
	 */
	public static boolean isJunko(JLabel label){
		boolean flag = false;
		try{
			String labText = label.getText();
			int n0 = Integer.parseInt(""+labText.charAt(0));
			int n1 = Integer.parseInt(""+labText.charAt(1));
			int n2 = Integer.parseInt(""+labText.charAt(2));
			if((n2 - n1 == 1) && (n1 - n0 == 1)){
				flag = true;
			}else if((n0 - n1 == 1) && (n1 - n2 == 1)){
				flag = true;
			}else if((n1 - n0 == 1) && (n0 - n2 == 1)){
				flag = true;
			}else if((n0 - n2 == 1) && (n2 - n1 == 1)){
				flag = true;
			}else if((n2 - n0 == 1) && (n0 - n1 == 1)){
				flag = true;
			}else if((n1 - n2 == 1) && (n2 - n0 == 1)){
				flag = true;
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * 是否是半顺子<p>
	 * @param label
	 * @return<br> 
	 * return boolean<br>
	 */
	public static boolean isBanJunko(JLabel label){
		boolean flag = false;
		try{
			String labText = label.getText();
			int n0 = Integer.parseInt(""+labText.charAt(0));
			int n1 = Integer.parseInt(""+labText.charAt(1));
			int n2 = Integer.parseInt(""+labText.charAt(2));
			if((n2 - n1 == 1) || (n1 - n2 == 1)|| (n1 - n0 == 1)|| (n0 - n1 == 1)|| (n2 - n0 == 1)|| (n0 - n2 == 1)){
				flag = true;
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 单双判断<p>
	 * @return<br> 
	 * return int（0：单单单 ，1：单单双，2：单双双，3：双双双）<br>
	 */
	public static int addOrEvenJudge(JLabel label){
		if(label == null){
			return -1;
		}
		try{
			String labText = label.getText();
			if(isAdd(Integer.parseInt(""+labText.charAt(0))) && isAdd(Integer.parseInt(""+labText.charAt(1))) && isAdd(Integer.parseInt(""+labText.charAt(2)))){
				return 0;
			}else if(isAdd(Integer.parseInt(""+labText.charAt(0))) && isAdd(Integer.parseInt(""+labText.charAt(1))) && !isAdd(Integer.parseInt(""+labText.charAt(2)))){
				return 1;
			}else if(isAdd(Integer.parseInt(""+labText.charAt(0))) && !isAdd(Integer.parseInt(""+labText.charAt(1))) && isAdd(Integer.parseInt(""+labText.charAt(2)))){
				return 1;
			}else if(!isAdd(Integer.parseInt(""+labText.charAt(0))) && isAdd(Integer.parseInt(""+labText.charAt(1))) && isAdd(Integer.parseInt(""+labText.charAt(2)))){
				return 1;
			}else if(!isAdd(Integer.parseInt(""+labText.charAt(0))) && !isAdd(Integer.parseInt(""+labText.charAt(1))) && isAdd(Integer.parseInt(""+labText.charAt(2)))){
				return 2;
			}else if(!isAdd(Integer.parseInt(""+labText.charAt(0))) && isAdd(Integer.parseInt(""+labText.charAt(1))) && !isAdd(Integer.parseInt(""+labText.charAt(2)))){
				return 2;
			}else if(isAdd(Integer.parseInt(""+labText.charAt(0))) && !isAdd(Integer.parseInt(""+labText.charAt(1))) && !isAdd(Integer.parseInt(""+labText.charAt(2)))){
				return 2;
			}else if(!isAdd(Integer.parseInt(""+labText.charAt(0))) && !isAdd(Integer.parseInt(""+labText.charAt(1))) && !isAdd(Integer.parseInt(""+labText.charAt(2)))){
				return 3;
			}else{
				return -1;
			}
		}catch (Exception e) {
			 return -1;
		}
	}
	/**
	 * 判断是否为奇数<p>
	 * @return <br>
	 * @return boolean<br>
	 */
	public static boolean isAdd(Integer num){
		if(num % 2 == 0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 大中小判断<p>
	 * @return<br> 
	 * return String（SSS：小小小 ，MMM：中中中，BBB：大大大）<br>
	 */
	public static int getExeSize(JLabel label){
		if(label == null){
			return -1;
		}
		try{
			String labText = label.getText();
			if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 0){
				return 0;// "SSS";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 1){
				return 1;//"MMM";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 2){
				return 2;//"BBB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 1){
				return 3;//"SSM";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 0){
				return 3;//"SSM";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 0){
				return 3;//"SSM";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 2){
				return 4;//"SSB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 0){
				return 4;//"SSB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 0){
				return 4;//"SSB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 0){
				return 5;//"MMS";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 1){
				return 5;//"MMS";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 1){
				return 5;//"MMS";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 2){
				return 6;//"MMB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 1){
				return 6;//"MMB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 1){
				return 6;//"MMB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 0){
				return 7;//"BBS";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 2){
				return 7;//"BBS";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 2){
				return 7;//"BBS";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 1){
				return 8;//"BBM";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 2){
				return 8;//"BBM";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 2){
				return 8;//"BBM";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 2){
				return 9;//"SMB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 1){
				return 9;//"SMB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 2){
				return 9;//"SMB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 0){
				return 9;//"SMB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 1 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 0){
				return 9;//"SMB";
			}else if(isBigOrSmall(Integer.parseInt(""+labText.charAt(0))) == 2 && isBigOrSmall(Integer.parseInt(""+labText.charAt(1))) == 0 && isBigOrSmall(Integer.parseInt(""+labText.charAt(2))) == 1){
				return 9;//"SMB";
			}else{
				return -1;
			}
		}catch (Exception e) {
			 return -1;
		}
	}
	/**
	 * 大中小判断<p>
	 * @param num
	 * @return 0：小  1:中  2：大 <br>
	 * @return int<br>
	 */
	public static int isBigOrSmall(Integer num){
		if(num < 4 )
			return 0;
		else if(num > 6)
			return 2;
		else 
			return 1;
	}
	
	/**
	 * 去除list中，不包含checkNumLab的数<p>
	 * @param list
	 * @param checkNumLab
	 * @return <br>
	 * @return List<JCheckBox><br>
	 */
	public static List<JLabel> getComBoxList(List<JLabel> list,List<JCheckBox> checkNumLab){
//		List<String> strs = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		if(checkNumLab != null && checkNumLab.size() > 0){
			for (JCheckBox box : checkNumLab) {
//				strs.add(box.getText().trim());	
				sb.append(box.getText().trim());
			}
			if(list != null && list.size() > 0){
				for(int i = 0; i < list.size(); ){
					String num = list.get(i).getText().trim();
					String str = sb.toString();
					if(str.contains(num.charAt(0)+"") && str.contains(num.charAt(1)+"") && str.contains(num.charAt(2)+"")){
						i++;
					}else{
						list.remove(i);
					}
				}
			}
		}
		return list;
	}
	/**
	 * 号码123过滤<p>
	 * @param list
	 * @param num012Chb <br>
	 * @return void<br>
	 */
	public static void num012Condition(List<JLabel> list,JCheckBox num012Chb[]){
		if(list != null && list.size() > 0){
			if(num012Chb.length == 3){
				//00
				if(num012Chb[0].isSelected() || num012Chb[1].isSelected() || num012Chb[2].isSelected()){
					StringBuffer num00 = new StringBuffer();
						num00.append("000.333.666.999.001.002.003.356.");
						num00.append("004.005.006.007.008.009.338.339.");
						num00.append("668.669.996.998.336.337.667.997.");
						num00.append("330.334.335.663.664.665.993.994.");
						num00.append("995.331.332.660.662.990.992.661.");
						num00.append("991.013.016.019.029.039.049.059.");
						num00.append("069.079.089.389.689.023.026.038.");
						num00.append("068.169.379.679.034.035.036.037.");
						num00.append("067.269.369.469.569.046.056.139.");
						num00.append("359.136.239.349.368.236.367.346");
					StringBuffer num11 = new StringBuffer();
						num11.append("111.444.777.118.119.448.449.");
						num11.append("778.779.110.112.113.114.115.116.");
						num11.append("117.446.447.774.776.445.441.442.");
						num11.append("443.771.772.773.440.770.014.017.");
						num11.append("179.479.047.149.178.124.478.134.");
						num11.append("127.148.167.137.147.157.145.146.");
						num11.append("247.467.347.457.775");
					StringBuffer num22 = new StringBuffer();
						num22.append("222.555.888.228.229.558.559.");
						num22.append("889.226.227.556.557.885.886.887.");
						num22.append("220.221.223.224.225.552.554.882.");
						num22.append("884.553.551.880.881.025.028.058.");
						num22.append("289.589.125.158.259.278.578.128.");
						num22.append("268.568.258.238.248.358.458.235.");
						num22.append("257.245.256.883.550.");
						num22.append("012.015.024.123.018.027.045.");
						num22.append("126.135.234.048.057.129.138.156.");
						num22.append("237.246.345.078.159.168.249.267.");
						num22.append("348.357.456.189.279.378.459.468.");
						num22.append("567.489.579.678.789");
					for(int i = 0; i < list.size();){
						String text = list.get(i).getText().trim();
						boolean isContain = false;
						if(num012Chb[0].isSelected()){
							if(num00.toString().contains(text)){
								isContain = true;
							}
						}
						if(num012Chb[1].isSelected() && !isContain){
							if(num11.toString().contains(text)){
								isContain = true;
							}
						}
						if(num012Chb[2].isSelected() && !isContain){
							if(num22.toString().contains(text)){
								isContain = true;
							}
						}
						if(isContain){
							i ++;
						}else{
							list.remove(i);
						}
					}
				}
			}
		}
	}
	
//	/**
//	 * 判断出现的号码中，是否有两位以上的数能被n整除<p>
//	 * @param str
//	 * @param n
//	 * @return <br>
//	 * @return boolean<br>
//	 */
//	private static boolean isModel(String str, int n){
//		if(str != null && str.length() > 2){
//			int num = 0;
//			if(Integer.parseInt(str.charAt(0)+"") % n == 0){
//				num ++;
//			}
//			if(Integer.parseInt(str.charAt(1)+"") % n == 0){
//				num ++;
//			}
//			if(Integer.parseInt(str.charAt(2)+"") % n == 0){
//				num ++;
//			}
//			if(num >= 2){
//				return true;
//			}
//		}
//		return false;
//	}
	/**
	 * 和值012过滤<p>
	 * @param list
	 * @param sum012Chb <br>
	 * @return void<br>
	 */
	public static void sum012Condition(List<JLabel> list,JCheckBox sum012Chb[]){
		if(list != null && list.size() > 0){
			if(sum012Chb.length == 3){
				if(sum012Chb[0].isSelected() || sum012Chb[1].isSelected() || sum012Chb[2].isSelected()){
					for(int i = 0; i < list.size();){
						int sum = getLabSum(list.get(i));
						boolean isContain = false;
						if(sum012Chb[0].isSelected()){
							if(sum % 3 == 0){
								isContain = true;
							}
						}
						if(sum012Chb[1].isSelected() && !isContain){
							if(sum % 3 == 1){
								isContain = true;
							}
						}
						if(sum012Chb[2].isSelected() && !isContain){
							if(sum % 3 == 2){
								isContain = true;
							}
						}
						if(isContain){
							i ++;
						}else{
							list.remove(i);
						}
					}
				}
			}
		}
	}
	
	/**
	 * 跨度012<p>
	 * @param list
	 * @param span012 <p>
	 * void
	 */
	public static void span012Condition(List<JLabel> list,JCheckBox span012[]){
		if(list != null && list.size() > 0){
			String selectNum = "";
			for(int i = 0; i < span012.length; i++){
				JCheckBox box = span012[i];
				if(box.isSelected()){
					selectNum += box.getText();
				}
			}
			if(selectNum != ""){//改组条件没有选择，不处理
				if(!selectNum.contains("0")){ //去除0 3 6 9跨度
					removeSpan(list, 0);
					removeSpan(list, 3);
					removeSpan(list, 6);
					removeSpan(list, 9);
				}
				if(!selectNum.contains("1")){ //去除1 4 7跨度
					removeSpan(list, 1);
					removeSpan(list, 4);
					removeSpan(list, 7);
				}
				if(!selectNum.contains("2")){ //去除2 5 8跨度
					removeSpan(list, 2);
					removeSpan(list, 5);
					removeSpan(list, 8);
				}
			}
		}
	}
	
	/**
	 * 去除相等的跨度<p>
	 * @param list
	 * @param span <p>
	 * void
	 */
	public static void removeSpan(List<JLabel> list,int span){
		if(list != null && list.size() > 0)
		for(int i = 0; i < list.size(); ){
			JLabel label = list.get(i);
			if(getSpan(label) == span){
				list.remove(i);
			}else{
				i++;
			}
		}
	}
	/**
	 * 和尾012<p>
	 * @param list
	 * @param span012 <p>
	 * void
	 */
	public static void sumWei012Condition(List<JLabel> list,JCheckBox span012[]){
		if(list != null && list.size() > 0){
			String selectNum = "";
			for(int i = 0; i < span012.length; i++){
				JCheckBox box = span012[i];
				if(box.isSelected()){
					selectNum += box.getText();
				}
			}
			if(selectNum != ""){//改组条件没有选择，不处理
				if(!selectNum.contains("0")){ //去除0.3.6.9.10.13.16.19.20.23.26.和值
					int[] sums = {0,3,6,9,10,13,16,19,20,23,26};
					for (int sum : sums) {
						removeSum(list, sum);
					}
				}
				if(!selectNum.contains("1")){ //去除1.4.7.11.14.17.21.24.27和值
					int[] sums = {1,4,7,11,14,17,21,24,27};
					for (int sum : sums) {
						removeSum(list, sum);
					}
				}
				if(!selectNum.contains("2")){ //去除2.5.8.12.15.18.22.25和值
					int[] sums = {2,5,8,12,15,18,22,25};
					for (int sum : sums) {
						removeSum(list, sum);
					}
				}
			}
		}
	}
	/**
	 * 去除相等的和值<p>
	 * @param list
	 * @param span <p>
	 * void
	 */
	public static void removeSum(List<JLabel> list,int sum){
		if(list != null && list.size() > 0)
		for(int i = 0; i < list.size(); ){
			JLabel label = list.get(i);
			if(getLabSum(label) == sum){
				list.remove(i);
			}else{
				i++;
			}
		}
	}
	
	/**
	 * 尾0——9的和值<p>
	 * @param list
	 * @param span012 <p>
	 * void
	 */
	public static void sumWei0_9Condition(List<JLabel> list,JCheckBox span012[]){
		if(list != null && list.size() > 0 ){
			List<Integer> nums = new ArrayList<Integer>();
			for(int i=0; i < span012.length; i++){
				JCheckBox box = span012[i];
				if(box.isSelected()){
					nums.add(Integer.parseInt(box.getText().trim()));
				}
			}
			if(nums.size() > 0){
				for(int i=0; i <= 9; i++){
					if(!nums.contains(i)){ //i不包含在被选中的号码中
						//去除相应的和值
						for(int j=0; j < list.size();){
							int sum = getLabSum(list.get(j));
							if(i == sum%10){
								list.remove(j);
							}else{
								j++;
							}
						}
					}
				}
			}
		}
	}
	/**
	 * 单双
	 * @param list
	 * @param span012
	 */
	public static void oddevenCondition(List<JLabel> list,JCheckBox span012[]){
		if(list != null && list.size() > 0 ){
			List<Integer> nums = new ArrayList<Integer>();
			for(int i=0; i < span012.length; i++){
				JCheckBox box = span012[i];
				if(box.isSelected()){
					nums.add(Integer.parseInt(box.getText().trim()));
				}
			}
			if(nums.size() > 0){
				for(int i=1; i <= 2; i++){
					if(!nums.contains(i)){ //i不包含在被选中的号码中
						//去除相应的和值
						for(int j=0; j < list.size();){
							int sum = getLabSum(list.get(j));
							if(i%2 == sum%2){
								list.remove(j);
							}else{
								j++;
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 *  号码单双过滤条件判断
	 * @param lab
	 * @param type
	 * @return
	 */
	public static String oddEven(JLabel lab,String type){
		String text = lab.getText();
		int val1 = Integer.parseInt(text.charAt(0)+"")%2;
		int val2 = Integer.parseInt(text.charAt(1)+"")%2;
		int val3 = Integer.parseInt(text.charAt(2)+"")%2;
		if("111".equals(type)){
			if(val1  == 1 && val2  == 1 && val3  == 1){
				return "111";
			}
		}else if("222".equals(type)){
			if(val1 == 0 && val2 == 0 && val3 == 0){
				return "222";
			}
		}else if("11".equals(type)){
			if((val1 == 1 && val2 ==1) || (val1 == 1 && val3 == 1) || (val2 == 1 && val3 ==1)){
				return "11";
			}
		}else if("22".equals(type)){
			if((val1 == 0 && val2 ==0) || (val1 == 0 && val3 == 0) || (val2 == 0 && val3 ==0)){
				return "22";
			}
		}
		return "";
	}
	/**
	 * 号码单双过滤
	 * @param list
	 * @param numberOddEven
	<br/>
	2015-7-11修改，<br/>
	111 的号码从 11 分出来<br/>
	222 的号码从 22 分出来
	 */
	public static void numberOddEvenCondition2(List<JLabel> list,JCheckBox numberOddEven[]){
		if(list != null && list.size() > 0){
			Set<JLabel> set = new HashSet<JLabel>();
			boolean selected = false;
			if(numberOddEven[0].isSelected()){
				selected = true;
				//111=百13579十13579个13579组合的号码
				for(int i = 0; i < list.size();i++){
					if("111".equals(Tools.oddEven(list.get(i), "111")) ){
						set.add(list.get(i));
					}
				}
			}
			if(numberOddEven[1].isSelected()){
				selected = true;
				//11=百13579十13579个O123456789组合的号码
				for(int i = 0; i < list.size();i++){
					System.out.println(list.get(i).getText());
					if("11".equals(Tools.oddEven(list.get(i), "11")) && !"111".equals(Tools.oddEven(list.get(i), "111"))){
						set.add(list.get(i));
					}
				}
			}
			if(numberOddEven[2].isSelected()){
				selected = true;
				//22=百O2468十O2468个O123456789组合的号码
				for(int i = 0; i < list.size();i++){
					if("22".equals(Tools.oddEven(list.get(i), "22")) && !"222".equals(Tools.oddEven(list.get(i), "222"))){
						set.add(list.get(i));
					}
				}
			}
			if(numberOddEven[3].isSelected()){
				selected = true;
				//222=百O2468十O2468个O2468组合的号码
				for(int i = 0; i < list.size();i++){
					if("222".equals(Tools.oddEven(list.get(i), "222"))){
						set.add(list.get(i));
					}
				}
			}
			//if(set.size() > 0){
				if(selected)
				for(int i = 0; i < list.size();){
					if(set.contains(list.get(i))){
						i++;
					}else{
						list.remove(i);
					}
				}
			//}
		}
	}
	
	/**
	 * 号码单双过滤
	 * @param list
	 * @param numberOddEven
	 */
	public static void numberOddEvenCondition(List<JLabel> list,JCheckBox numberOddEven[]){
		if(list != null && list.size() > 0){
			if(numberOddEven[0].isSelected()){
				//111=百13579十13579个13579组合的号码
				for(int i = 0; i < list.size();){
					if("111".equals(Tools.oddEven(list.get(i), "111")) ){
						i++;
					}else{
						list.remove(i);
					}
				}
			}
			if(numberOddEven[1].isSelected()){
				//11=百13579十13579个O123456789组合的号码
				for(int i = 0; i < list.size();){
					if("11".equals(Tools.oddEven(list.get(i), "11"))){
						i++;
					}else{
						list.remove(i);
					}
				}
			}
			if(numberOddEven[2].isSelected()){
				//22=百O2468十O2468个O123456789组合的号码
				for(int i = 0; i < list.size();){
					if("22".equals(Tools.oddEven(list.get(i), "22"))){
						i++;
					}else{
						list.remove(i);
					}
				}
			}
			if(numberOddEven[3].isSelected()){
				//222=百O2468十O2468个O2468组合的号码
				for(int i = 0; i < list.size();){
					if("222".equals(Tools.oddEven(list.get(i), "222"))){
						i++;
					}else{
						list.remove(i);
					}
				}
			}
		}
	}
	
	
	/**
	 * 和尾大小单双过滤
	 * @param list
	 * @param heweiOddEven
	 */
	public static void heweiOddEvenCondition(List<JLabel> list,JCheckBox heweiOddEven[]){
		if(list != null && list.size() > 0){
			  String text = "";
			  int selectedNum = 0;
			  for (int i = 0; i < heweiOddEven.length; i++) {
				  JCheckBox box = heweiOddEven[i];
				  if(!box.isSelected()){
					  text += box.getText();
				  }else{
					  selectedNum++;
				  }
			  }
			  //有被选中的条件
			  if(selectedNum > 0)
			  if(!"".equals(text)){
				  for(int i = 0; i <text.length();i++){
					  int value = Integer.parseInt(text.charAt(i)+"");
					  for(int j = 0; j <list.size();){
						  int sum = Tools.getLabSum(list.get(j));
						  if(sum%10 == value){
							  list.remove(j);
						  }else{
							  j++;
						  }
					  }
				  }
			  }
		}
	}
	
	/**
	 * 将lab标签的值转换为数字
	 * @param lab
	 * @return
	 */
	public static int getLabNum(JLabel lab){
		String text = lab.getText();
		int value = Integer.parseInt(text);
		return value;
	}
	
	public static void baiShiGeCondition(List<JLabel> list,JCheckBox baiBoxs[],JCheckBox shiBoxs[],JCheckBox geBoxs[]){
		if(list!=null && list.size() > 0){
			//百位选中的数
			 String baiStr = "";
			//十位选中的数
			 String shiStr = "";
			//个位选择的数
			 String geStr = "";
			for (JCheckBox jCheckBox : baiBoxs) {
				if(jCheckBox.isSelected()){
					baiStr += jCheckBox.getText();
				}
			}
			for (JCheckBox jCheckBox : shiBoxs) {
				if(jCheckBox.isSelected()){
					shiStr += jCheckBox.getText();
				}
			}
			for (JCheckBox jCheckBox : geBoxs) {
				if(jCheckBox.isSelected()){
					geStr += jCheckBox.getText();
				}
			}
			String numStr3 = "0123456789";
			if("".equals(baiStr) && "".equals(shiStr) && "".equals(geStr)){
				//都没选
				return ;
			}else if(!"".equals(baiStr) && "".equals(shiStr) && "".equals(geStr)){
				//只选了百
				containNum(list, baiStr);
			}else if("".equals(baiStr) && !"".equals(shiStr) && "".equals(geStr)){
				//只选了十
				containNum(list, shiStr);
			}else if("".equals(baiStr) && "".equals(shiStr) && !"".equals(geStr)){
				//只选了个
				containNum(list, geStr);
			}else if(!"".equals(baiStr) && !"".equals(shiStr) && "".equals(geStr)){
				//选了百十
				containNums(list, baiStr, shiStr,numStr3);
			}else if(!"".equals(baiStr) && "".equals(shiStr) && !"".equals(geStr)){
				//选了百个
				containNums(list, baiStr, geStr,numStr3);
			}else if("".equals(baiStr) && !"".equals(shiStr) && !"".equals(geStr)){
				//选了十个
				containNums(list, shiStr, geStr,numStr3);
			}else if(!"".equals(baiStr) && !"".equals(shiStr) && !"".equals(geStr)){
				//选了百十个
				containNums(list, baiStr, shiStr, geStr);
			}
		}
	}
	
	/**
	 * 包含一组数字的标签 百
	 * @param list
	 * @param numStr 数字
	 */
	public static void containNum(List<JLabel> list,String numStr){
		 Set<JLabel> set = new HashSet<JLabel>();
		 for(int i = 0; i <numStr.length();i++){
			  String value = numStr.charAt(i)+"";
			  for(int j = 0; j < list.size(); j++){
				  if(list.get(j).getText().contains(value)){
					  set.add(list.get(j));
				  }
			  }
		 }
		 list.clear();
		 for (JLabel jLabel : set) {
			list.add(jLabel);
		}
	}
	/**
	 * 包含两组的标签
	 * @param list
	 * @param numStr1 数字
	 * @param numStr2 数字
	 */
	public static void containNums(List<JLabel> list,String numStr1,String numStr2,String numStr3){
		 Set<String> set = new HashSet<String>();
		 
		 for(int i = 0; i <numStr1.length();i++){
			  String txt0 = numStr1.charAt(i)+"";
			  for(int k = 0; k < numStr2.length(); k++){
				  String txt1 = numStr2.charAt(k)+"";
				  for(int j = 0; j < numStr3.length(); j++){
					    String txt2 = numStr3.charAt(j) + "";
					    String num = "";
						if(txt0.equals(txt1)){
							num = txt0 + txt1 + txt2;
						}else if(txt0.equals(txt2)){
							num = txt0 + txt2 + txt1;
						}else if(txt1.equals(txt2)){
							num = txt1 + txt2 + txt0;
						}else{
							String[] strs = bubbleSort(new String[]{txt0,txt1,txt2});
							for (String string : strs) {
								num += string;
							}
						}
					    set.add(num);
				  }
			  }
		 }
		 
		 Set<JLabel> setJLabel = new HashSet<JLabel>();
		 for (String num : set) {
 			for(int i = 0; i < list.size(); i++){
				String text = list.get(i).getText().trim();
				if(num.equals(text)){
					setJLabel.add(list.get(i));
				}
			}
		}
		 list.clear();
		 for (JLabel jLabel : setJLabel) {
			list.add(jLabel);
		}
	}
	
	/**
	 * 	不定位胆码过滤(反显)
	 * @param list
	 * @param reBiles
	 */
	public static void reBilesChbCondition(List<JLabel> list,JCheckBox reBiles1[],JCheckBox reBiles2[]){
		if(list != null && list.size() > 0){
			String text1 = "";
			String text2 = "";
			for(int i = 0; i < reBiles1.length; i++){
				 if(reBiles1[i].isSelected()){
					 text1 += reBiles1[i].getText();
				 }
			}
			for(int i = 0; i < reBiles2.length; i++){
				 if(reBiles2[i].isSelected()){
					 text2 += reBiles2[i].getText();
				 }
			}
			if(!"".equals(text1) && !"".equals(text2)){
				 for(int i = 0; i <text1.length();i++){
					 String val1 = text1.charAt(i)+"";
					 for(int j = 0; j <text2.length();j++){
						 String val2 = text2.charAt(j)+"";
						 if(val1.equals(val2)){
							 Tools.removeContain(list, val1,null);
						 }else{
							 Tools.removeContain(list, val1,val2);
						 }
					 }
				 }
			}
		}
	}
	
	public static void removeContain(List<JLabel> list,String num,String num1){
		for(int i = 0; i < list.size(); ){
			if(num != null && num1 == null){
				if(list.get(i).getText().contains(num)){
					list.remove(i);
				}else{
					i++;
				}
			}else if(num != null && num1 != null){
				String text = list.get(i).getText();
				if(text.contains(num) && text.contains(num1)){
					list.remove(i);
				}else{
					i++;
				}
			}
		}
	}
	
	/**
	 * 零二七九过滤
	 * @param list
	 * @param n0279Boxs
	 */
	public static void n0279Condition(List<JLabel> list,JCheckBox[] n0279Boxs){
		if(list != null && list.size() > 0){
			//交集
			List<String> intersection = getIntersection(n0279Boxs);
			if(intersection.size() > 0){
				for(int i = 0; i< list.size();){
					String num = list.get(i).getText().trim();
					if(!intersection.contains(num)){
						list.remove(i);//不包含，则去除
					}else{
						i++;
					}
				}
			}
		}
	}
	
	/**
	 * 获取选择0279选择按钮中的交集，如果只选择了一个，交集为这个的数据
	 * @param n0279Boxs
	 * @return
	 */
	private static List<String> getIntersection(JCheckBox[] n0279Boxs){
		//交集
		List<String> intersection = new ArrayList<String>();
		if(n0279Boxs[0].isSelected()){
			intersection.addAll(list0279_0);
		}
		if(n0279Boxs[1].isSelected()){
			if(intersection.size()==0){
				intersection.addAll(list0279_2);
			}else{//不为空，则取交集
				for(int i=0;i<intersection.size();){
					if(!list0279_2.contains(intersection.get(i))){//不包含在内，则去除
						intersection.remove(i);
					}else{
						i++;
					}
				}
				if(intersection.size()==0){//比较后没有交集
					return intersection;
				}
			}
		}
		if(n0279Boxs[2].isSelected()){
			if(intersection.size() == 0){
				intersection.addAll(list0279_7);
			}else{//不为空，则取交集
				for(int i=0;i<intersection.size();){
					if(!list0279_7.contains(intersection.get(i))){//不包含在内，则去除
						intersection.remove(i);
					}else{
						i++;
					}
				}
				if(intersection.size()==0){//比较后没有交集
					return intersection;
				}
			}
		}
		if(n0279Boxs[3].isSelected()){
			if(intersection.size() == 0){
				intersection.addAll(list0279_9);
			}else{//不为空，则取交集
				for(int i=0;i<intersection.size();){
					if(!list0279_9.contains(intersection.get(i))){//不包含在内，则去除
						intersection.remove(i);
					}else{
						i++;
					}
				}
				if(intersection.size()==0){//比较后没有交集
					return intersection;
				}
			}
		}
		return intersection;
	}
	
	/**
	 * 二七反显过滤
	 * @param list
	 * @param n27Boxs
	 */
	public static void n27Condition(List<JLabel> list,JCheckBox[] n27Boxs){
		if(list != null && list.size() > 0){
			//并集
			List<String> union = new ArrayList<String>();
			if(n27Boxs[0].isSelected()){
				union.addAll(list0279_2);
			}
			if(n27Boxs[1].isSelected()){
				union.addAll(list0279_7);
			}
			if(union.size() > 0){
				for(int i = 0; i< list.size();){
					if(union.contains(list.get(i).getText().trim())){
						list.remove(i);//包含，则去除
					}else{
						i++;
					}
				}
			}
		}
	}
	
	/**零二七九 零包含数字*/
	private static List<String> list0279_0 = Arrays.asList(
			   "000","333","666","999","001","002","003","004","005","006","007","008","009","119","229","338","339","449","559","668",
			   "669","779","996","889","998","110","113","116","226","336","337","446","556","667","776","886","997","220","330","223",
			   "334","335","663","664","665","993","994","995","331","332","443","660","553","662","773","990","883","992","440","550",
			   "661","770","880","991","012","013","014","015","016","017","018","019","029","039","049","059","069","079","089","189",
			   "289","389","489","589","689","789","023","024","025","026","027","028","038","048","058","068","078","169","179","279",
			   "379","479","579","679","123","034","035","036","037","047","057","067","149","159","269","369","469","569","678","045",
			   "046","056","129","139","168","259","378","134","126","138","167","249","268","359","459","568","135","136","137","239",
			   "349","368","468","234","146","156","238","267","358","567","235","236","237","348","367","467","246","256","347","357",
			   "345","346","356","456");
	/**零二七九 二包含数字*/
	private static List<String> list0279_2 = Arrays.asList(
			 "222","002","003","004","228","229","112","113","114","226","227","220","221","330","223","224","225","552","882","331",
			 "332","441","442","662","772","992","440","012","013","014","029","039","049","289","023","024","025","026","027","028",
			 "038","048","279","123","034","035","036","037","047","149","269","124","125","045","046","129","139","259","278","134",
			 "126","127","128","138","148","249","268","135","136","137","147","239","258","234","145","146","238","248","267","235",
			 "236","237","247","257","245","246","256"
			);
	/**零二七九 七包含数字*/
	private static List<String> list0279_7 = Arrays.asList(
			 "777","007","558","559","668","669","778","779","996","117","227","337","447","557","774","667","776","885","886","887",
			 "997","775","995","771","772","773","770","017","059","069","079","589","689","789","027","058","068","078","169","179",
			 "279","379","479","579","679","037","047","057","067","159","178","269","369","469","569","678","158","168","259","278",
			 "378","478","578","127","167","268","359","459","568","137","147","157","258","368","468","267","358","458","567","237",
			 "247","257","367","467","347","357","457"
			);
	/**零二七九 九包含数字*/
	private static List<String> list0279_9 = Arrays.asList(
			"002","003","004","005","006","007","228","229","338","339","448","449","558","559","668","669","778","779","996","112",
			 "113","114","115","116","117","885","886","887","997","220","221","330","882","884","993","994","995","331","441","660",
			 "771","883","992","440","550","551","661","770","012","013","014","015","016","017","029","039","049","059","069","079",
			 "289","389","489","589","689","789","023","024","025","026","027","028","038","048","058","068","078","169","179","279",
			 "379","479","579","679","123","034","035","036","037","047","057","067","149","159","178","269","369","469","569","678",
			 "124","125","045","046","056","129","139","158","168","259","278","378","478","578","134","126","127","128","138","148",
			 "167","249","268","359","459","568","134","126","127","128","138","148","167","249","268","359","459","568","135","136",
			 "137","147","157","239","258","349","368","468","135","136","137","147","157","239","258","349","368","468","145","146",
			 "156","238","248","358","458","348"
			);
	 /**
	  * xml文件中定义好的，需要显示的数字过滤
	  * @param condtionBoxs
	  * @param id
	  * @param lists
	  */
	 @SafeVarargs
	public static void commonXMLCodtion(JCheckBox[] condtionBoxs,String id,List<JLabel> ...lists){
		 if(lists == null || lists.length < 1){
			 return;
		 }
		 //每个条件要显示的数字
		 Map<String, Set<String>> dataMap = xmlMap.get(id);
		 if(dataMap == null || dataMap.isEmpty()){
			 return;
		 }
		 Set<String> all = new HashSet<String>();
		 for(int i=0,len = condtionBoxs.length; i < len; i++){
			 if(condtionBoxs[i].isSelected()){
				 all.addAll(dataMap.get(i+""));
			 }
		 }
		 if(all.size() < 1){
			 return;
		 }
		 for(List<JLabel> list : lists){
			 for(int i = 0; i <list.size();){
				 String txt = list.get(i).getText().trim();
				 if(all.contains(txt)){
					 i++;
				 }else{
					 list.remove(i);
				 }
			 }
		 }
	 }
	 
	 /**
	  * 二七反正显
	  * @param condtionBoxs
	  * @param lists
	  */
	 @SafeVarargs
	public static void n27Condition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 if(lists == null || lists.length < 1){
			 return;
		 }
//		 if(condtionBoxs[0].isSelected() && condtionBoxs[1].isSelected()){
//			 return;
//		 }
//		 if(!condtionBoxs[0].isSelected() && !condtionBoxs[1].isSelected()){
//			 return;
//		 }
		 //每个条件要显示的数字
		 Map<String, Set<String>> dataMap = xmlMap.get("n27");
		 if(dataMap == null || dataMap.isEmpty()){
			 return;
		 }
		 Set<String> all = dataMap.get("0");
		 if(all == null || all.size() < 1){
			 return;
		 }
		 if(condtionBoxs[0].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(all.contains(txt)){
						 i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
		 if(condtionBoxs[1].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(all.contains(txt)){
						 list.remove(i);
					 }else{
						 i++; 
					 }
				 }
			 }
		 }
		
	 }
	 
	 /**
	  * TBOZ条件过滤
	  * @param condtionBoxs
	  * @param lists
	  */
	 @SafeVarargs
	public static void tbozCondition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 if(lists == null || lists.length < 1){
			 return;
		 }
		 //每个条件要显示的数字
		 Map<String, Set<String>> dataMap = xmlMap.get("TBOZ");
		 if(dataMap == null || dataMap.isEmpty()){
			 return;
		 }
		 Set<String> all0 = dataMap.get("0");
		 if(all0 == null || all0.size() < 1){
			 return;
		 }
		 Set<String> all1 = dataMap.get("1");
		 if(all1 == null || all1.size() < 1){
			 return;
		 }
		 if(condtionBoxs[0].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(!all0.contains(txt)){
						 i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
		 if(condtionBoxs[1].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(all0.contains(txt)){
						i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
		 if(condtionBoxs[2].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(all1.contains(txt)){
						 i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
		 if(condtionBoxs[3].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(!all1.contains(txt)){
						 i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
		
	 }
	 
	 /**
	  * TB反正显
	  * @param condtionBoxs
	  * @param lists
	  */
	 @SafeVarargs
	public static void tbCondition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 if(lists == null || lists.length < 1){
			 return;
		 }
		 //每个条件要显示的数字
		 Map<String, Set<String>> dataMap = xmlMap.get("TB");
		 if(dataMap == null || dataMap.isEmpty()){
			 return;
		 }
		 Set<String> all = dataMap.get("0");
		 if(all == null || all.size() < 1){
			 return;
		 }
		 if(condtionBoxs[0].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(all.contains(txt)){
						 i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
		 if(condtionBoxs[1].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(all.contains(txt)){
						 list.remove(i);
					 }else{
						 i++; 
					 }
				 }
			 }
		 }
		
	 }
	 
	 /**
	  * sumTBtb反正显
	  * @param condtionBoxs
	  * @param lists
	  */
	 @SafeVarargs
	public static void sumTBtbCondition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 if(lists == null || lists.length < 1){
			 return;
		 }
		 //每个条件要显示的数字
		 Map<String, Set<String>> dataMap = xmlMap.get("sumTBtb");
		 if(dataMap == null || dataMap.isEmpty()){
			 return;
		 }
		 Set<String> all = new HashSet<String>();
		 if(condtionBoxs[0].isSelected()){
			 all.addAll(dataMap.get("0"));
		 }
		 if(condtionBoxs[1].isSelected()){
			 all.addAll(dataMap.get("1"));
		 }
		 if(all.size() > 0){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(all.contains(txt)){
						 i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
		 all.clear();
		 all.addAll(dataMap.get("2"));
		 if(condtionBoxs[2].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(all.contains(txt)){
						 i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
		 if(condtionBoxs[3].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(all.contains(txt)){
						 list.remove(i);
					 }else{
						 i++; 
					 }
				 }
			 }
		 }
		
	 }
	 
	 /**
	  * 和尾算法
	  * @param condtionBoxs
	  * @param lists
	  */
	 @SafeVarargs
	public static void hwCondition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 Integer[][] data = new Integer[4][];
		 data[0] = new Integer[]{1,11,21,3,13,23};
		 data[1] = new Integer[]{5,15,25,7,17,27,9,19};
		 data[2] = new Integer[]{0,10,20,2,12,22,4,14,24};
		 data[3] = new Integer[]{6,16,26,8,18};
		 List<Integer> dataList = new  ArrayList<Integer>();
		 for(int i = 0; i < 4; i++){
			 if(condtionBoxs[i].isSelected()){
				 for(Integer num : data[i])
				 dataList.add(num);
			 }
		 }
		 if(dataList.isEmpty()){
			 return;
		 }
		 for(List<JLabel> list : lists){
			 for(int i = 0; i < list.size(); ){
				 if(dataList.contains(getLabSum(list.get(i)))){
					 i++;
				 }else{
					 list.remove(i);
				 }
			 }
		 }
	 }
	 /**
	  * 跨度算法
	  * @param condtionBoxs
	  * @param lists
	  */
	 @SafeVarargs
	public static void kdCondition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 Integer[][] data = new Integer[4][];
		 data[0] = new Integer[]{1,3};
		 data[1] = new Integer[]{5,7,9};
		 data[2] = new Integer[]{0,2,4};
		 data[3] = new Integer[]{6,8};
		 List<Integer> dataList = new  ArrayList<Integer>();
		 for(int i = 0; i < 4; i++){
			 if(condtionBoxs[i].isSelected()){
				 for(Integer num : data[i])
				 dataList.add(num);
			 }
		 }
		 if(dataList.isEmpty()){
			 return;
		 }
		 for(List<JLabel> list : lists){
			 for(int i = 0; i < list.size(); ){
				 if(dataList.contains(getSpan(list.get(i)))){
					 i++;
				 }else{
					 list.remove(i);
				 }
			 }
		 }
	 }
	 
	 /**
	  * c015算法
	  * @param condtionBoxs
	  * @param lists
	  */
	 @SafeVarargs
	public static void c015Condition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 if(condtionBoxs[0].isSelected() && !condtionBoxs[1].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i < list.size(); ){
					 if(getLabSum(list.get(i)) <= 14){
						 i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
		 if(!condtionBoxs[0].isSelected() && condtionBoxs[1].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i < list.size(); ){
					 if(getLabSum(list.get(i)) > 14){
						 i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
	 }
	 
	 /**
	  * OZ条件过滤
	  * @param condtionBoxs
	  * @param lists
	  */
	 @SafeVarargs
	public static void ozCondition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 if(lists == null || lists.length < 1){
			 return;
		 }
		 //每个条件要显示的数字
		 Map<String, Set<String>> dataMap = xmlMap.get("TBOZ");
		 if(dataMap == null || dataMap.isEmpty()){
			 return;
		 }
		 Set<String> all1 = dataMap.get("1");
		 if(all1 == null || all1.size() < 1){
			 return;
		 }
		 if(condtionBoxs[0].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(all1.contains(txt)){
						 i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
		 if(condtionBoxs[1].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 if(!all1.contains(txt)){
						 i++;
					 }else{
						 list.remove(i);
					 }
				 }
			 }
		 }
		
	 }
	 
	 /**
	  * 不定位胆码反显过滤过滤
	  * @param condtionBoxs
	  * @return 不定位胆码或者不定位胆码（反显）的数字
	  */
	 @SafeVarargs
	public static List<List<String>> bilesReMap(JCheckBox[] ...condtionBoxs){
		List<List<String>> list = new ArrayList<List<String>>();
		for(int i = 0; i < condtionBoxs.length; i++){
			JCheckBox[] condtionRow = condtionBoxs[i];
			List<String> dataList = new ArrayList<String>();
			for(JCheckBox box : condtionRow){
				if(box.isSelected())
					dataList.add(box.getText().trim());
			}
			if(!dataList.isEmpty()){
				list.add(dataList);
			}
		}
		return list;
	 }
	 /**
	  * 不定位胆码反显过滤过滤
	  * @param condtionBoxs
	  * @return 不定位胆码或者不定位胆码（反显）的数字
	  */
	 @SafeVarargs
	public static void bilesReCondition(List<List<String>> datalists,List<JLabel> ...lists){
		 if(datalists == null || datalists.size() == 0){
			 return;
		 }else if(datalists.size() == 1){
			 List<String> dataList = datalists.get(0);
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 boolean isExit = false;
					 for(int j = 0; j < dataList.size(); j++){
						 String data = dataList.get(j);
						 if(txt.contains(data)){
							 isExit = true;
							 break;
						 }
					 }
					 if(isExit){
						 list.remove(i);
					 }else{
						 i++;
					 }
				 }
			 }
		 }else if(datalists.size() == 2){
			 List<String> dataList1 = datalists.get(0);
			 List<String> dataList2 = datalists.get(1);
			 Set<String> set = new HashSet<String>();
			 for(int i = 0; i < dataList1.size(); i ++){
				 for(int j = 0; j < dataList2.size(); j ++){
					  set.add(dataList1.get(i)+dataList2.get(j));
				 }
			 }
			 Iterator<String> it = set.iterator();
			 while(it.hasNext()){
				 String data = it.next();
				 String d1 = data.charAt(0)+"";
				 String d2 = data.charAt(1)+"";
				 boolean isEqual = d1.equals(d2);
				 for(List<JLabel> list : lists){
					 for(int i = 0; i <list.size();){
						 String txt = list.get(i).getText().trim();
						 boolean isExist = false;
						 if(isEqual){
							 if(txt.contains(data)){
								 isExist = true;
							 }
						 }else{
							 if(txt.contains(d1) && txt.contains(d2)){
								 isExist = true;
							 }
						 }
						 if(isExist){
							 list.remove(i);
						 }else{
							 i++;
						 }
					 }
				 }
			 }
		 }
	 }
	 /**
	  * c27条件过滤
	  * @param condtionBoxs
	  * @param lists
	  */
	 @SafeVarargs
	public static void c27Condition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 if(condtionBoxs[0].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 boolean isRemove = false;
					 if(txt.contains("2") || txt.contains("3") || txt.contains("4")){
						  if(txt.contains("5") || txt.contains("6") || txt.contains("7")){
							  isRemove = true;
						  }
					 }else{
						 isRemove = true;
					 }
					 if(isRemove){
						 list.remove(i);
					 }else{
						 i++;
					 }
				 }
			 }
		 }
		if (condtionBoxs[1].isSelected()) {
			String[] s1 = new String[] { "2", "3", "4" };
			String[] s2 = new String[] { "5", "6", "7" };
			Set<String> set = new HashSet<String>();
			for (int i = 0; i < s1.length; i++) {
				for (int j = 0; j < s2.length; j++) {
					set.add(s1[i] + s2[j]);
				}
			}
			for (List<JLabel> list : lists) {
				for (int i = 0; i < list.size();) {
					String txt = list.get(i).getText().trim();
					boolean isExist = false;
					Iterator<String> it = set.iterator();
					while (it.hasNext()) {
						String data = it.next();
						String d1 = data.charAt(0) + "";
						String d2 = data.charAt(1) + "";
						boolean isEqual = d1.equals(d2);
						if (isEqual) {
							if (txt.contains(data)) {
								isExist = true;
								break;
							}
						} else {
							if (txt.contains(d1) && txt.contains(d2)) {
								isExist = true;
								break;
							}
						}
					}
					if (!isExist) {
						list.remove(i);
					} else {
						i++;
					}
				}
			}
		}
		 if(condtionBoxs[2].isSelected()){
			 for(List<JLabel> list : lists){
				 for(int i = 0; i <list.size();){
					 String txt = list.get(i).getText().trim();
					 boolean isRemove = false;
					 if(txt.contains("5") || txt.contains("6") || txt.contains("7")){
						  if(txt.contains("2") || txt.contains("3") || txt.contains("4")){
							  isRemove = true;
						  }
					 }else{
						 isRemove = true;
					 }
					 if(isRemove){
						 list.remove(i);
					 }else{
						 i++;
					 }
				 }
			 }
		 }
	 }
	 /**
	  * TTBT条件过滤
	  * @param condtionBoxs
	  * @param lists
	  */
	 @SafeVarargs
	public static void ttbtCondition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 if(lists == null || lists.length < 1){
			 return;
		 }
		 //每个条件要显示的数字
		 Map<String, Set<String>> dataMap = xmlMap.get("ttbt");
		 if(dataMap == null || dataMap.isEmpty()){
			 return;
		 }
		 Set<String> all = new HashSet<String>();
		 for(int i=0,len = condtionBoxs.length; i < len; i++){
			 if(condtionBoxs[i].isSelected()){
				 all.addAll(dataMap.get(i+""));
			 }
		 }
		 if(all.size() < 1){
			 return;
		 }
		 for(List<JLabel> list : lists){
			 for(int i = 0; i <list.size();){
				 String txt = list.get(i).getText().trim();
				 if(all.contains(txt)){
					 i++;
				 }else{
					 list.remove(i);
				 }
			 }
		 }
	 }
	 /**
	  * TT2TT1BT1条件过滤
	  * @param condtionBoxs
	  * @param lists
	  */
	 @SafeVarargs
	public static void tt1bt1Condition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 if(lists == null || lists.length < 1){
			 return;
		 }
		 //每个条件要显示的数字
		 Map<String, Set<String>> dataMap = xmlMap.get("tt1bt1");
		 if(dataMap == null || dataMap.isEmpty()){
			 return;
		 }
		 Set<String> all = new HashSet<String>();
		 for(int i=0,len = condtionBoxs.length; i < len; i++){
			 if(condtionBoxs[i].isSelected()){
				 all.addAll(dataMap.get(i+""));
			 }
		 }
		 if(all.size() < 1){
			 return;
		 }
		 for(List<JLabel> list : lists){
			 for(int i = 0; i <list.size();){
				 String txt = list.get(i).getText().trim();
				 if(all.contains(txt)){
					 i++;
				 }else{
					 list.remove(i);
				 }
			 }
		 }
	 }
	 
	 /**
	  * 获取两个集合的交集
	  * @param set1 集合1
	  * @param set2 集合2
	  * @return
	  */
	 private static Set<String> getIntersection(Set<String> set1, Set<String> set2){
		 Set<String> set = new HashSet<String>();
		 Iterator<String> it = set1.iterator();
		 while (it.hasNext()) {
			String num = it.next();
			if(set2.contains(num)){
				set.add(num);
			}
			
		}
		 return set;
	 }
	 
	/**
	 * tb过滤(新)<br>
	 * T=(‹T+›交集‹T-›）并集（‹B+›交集‹B-›）<br>
	 * B=(‹T+›交集‹B-›）并集（‹B+›交集‹T-›）<br>
	 * @param condtionBoxs
	 * @param lists
	 */
	 @SafeVarargs
	public static void tbNewCondition(JCheckBox[] condtionBoxs,List<JLabel> ...lists){
		 if(lists == null || lists.length < 1){
			 return;
		 }
		 if(!condtionBoxs[0].isSelected() && ! condtionBoxs[1].isSelected()){
			 return;
		 }
		 //每个条件要显示的数字
		 Map<String, Set<String>> addMap = xmlMap.get("tb_add");
		 if(addMap == null || addMap.isEmpty()){
			 return;
		 }
		 Map<String, Set<String>> subMap = xmlMap.get("tb_sub");
		 if(subMap == null || subMap.isEmpty()){
			 return;
		 }
		 Set<String> tAdd = addMap.get("0");
		 Set<String> bAdd = addMap.get("1");
		 Set<String> tSub = subMap.get("0");
		 Set<String> bSub = subMap.get("1");
		 Set<String> all = new HashSet<String>();
		  
		 if(condtionBoxs[0].isSelected()){
			 //T=(‹T+›交集‹T-›）并集（‹B+›交集‹B-›）
			 all.addAll(getIntersection(tAdd,tSub));
			 all.addAll(getIntersection(bAdd,bSub));
		 }
		 
		 if(condtionBoxs[1].isSelected()){
			 //B=(‹T+›交集‹B-›）并集（‹B+›交集‹T-›
			 all.addAll(getIntersection(tAdd,bSub));
			 all.addAll(getIntersection(bAdd,tSub));
		 }
		 
		 if(all.size() < 1){
			 return;
		 }
		 for(List<JLabel> list : lists){
			 for(int i = 0; i <list.size();){
				 String txt = list.get(i).getText().trim();
				 if(all.contains(txt)){
					 i++;
				 }else{
					 list.remove(i);
				 }
			 }
		 }
	 }
	 
	 /**
	  * 通用条件过滤
	  * @param condtionBoxs  条件选项
	  * @param key xmlMap key
	  * @param lists 显示的数据集
	  */
	 @SafeVarargs
	public static void xmlDataCondition(JCheckBox[] condtionBoxs,String key,List<JLabel> ...lists){
		 if(lists == null || lists.length < 1){
			 return;
		 }
		 //每个条件要显示的数字
		 Map<String, Set<String>> dataMap = xmlMap.get(key);
		 if(dataMap == null || dataMap.isEmpty()){
			 return;
		 }
		 Set<String> all = new HashSet<String>();
		 for(int i=0,len = condtionBoxs.length; i < len; i++){
			 if(condtionBoxs[i].isSelected()){
				 all.addAll(dataMap.get(i+""));
			 }
		 }
		 if(all.size() < 1){
			 return;
		 }
		 for(List<JLabel> list : lists){
			 for(int i = 0; i <list.size();){
				 String txt = list.get(i).getText().trim();
				 if(all.contains(txt)){
					 i++;
				 }else{
					 list.remove(i);
				 }
			 }
		 }
	 }
}

 
