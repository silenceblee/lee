package lottery.data;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import lottery.frame.Tools;

public class Test {

	public static void main(String[] args) {
		Map<String, Set<String>> dataMap = Tools.getXmlMap().get("ttbbSecond");
		 Iterator<String> it = dataMap.get("0").iterator();
		 while (it.hasNext()) {
			String v = it.next();
			if(dataMap.get("1").contains(v))
				System.out.println(v);
			
		}
	}
}
