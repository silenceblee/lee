package lottery.frame;

import java.util.List;

/**
 * 通用判断类<p>
 * @author DuanQingwei  @date 2012-10-3 <br>
 * @version 1.0 <br>
 */
@SuppressWarnings("rawtypes")
public class Common {

	/**
	 * list是否为空<p>
	 * @param list
	 * @return<br> 
	 * return boolean<br>
	 */
	public static boolean isNotEmptyList( List list){
		if(list == null || list.size() <= 0){
			return false;
		}else{
			return true;
		}
	}
}
