package Algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
//解决电台选择问题
//假设有K1,K2,K3,K4,K5
//分别覆盖不同且多个地区，
//问如何选择购买可最优的覆盖完所有地区
public class 贪心算法 {
	public static void main(String[] args) {
		HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1. add("北京");
		hashSet1. add("上海");
		hashSet1. add("天津");
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2. add("广州");
		hashSet2. add("北京");
		hashSet2. add("深圳");
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3. add("成都");
		hashSet3.add("上海");
		hashSet3. add("杭州");
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("上海");
		hashSet4. add("天津");
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5. add("杭州");
		hashSet5. add("大连");

		
		//加入到map
		broadcasts. put("K1", hashSet1);
		broadcasts. put( "K2", hashSet2);
		broadcasts. put("K3", hashSet3);
		broadcasts.put("K4", hashSet4);
		broadcasts. put("K5", hashSet5);
		//存放所有城市
		HashSet<String> allAreas = new HashSet<String>();
		Collection<HashSet<String>> values = broadcasts.values();
		Iterator<HashSet<String>> iterator = values.iterator();
		while (iterator.hasNext()) {
			allAreas.addAll(iterator.next());
			
		}
		
		//创建ArrayList,存放选择的电台集合
		ArrayList<String> selects = new ArrayList<String>();
		//定义一个临时的集合，在遍历的过程中，存放逾历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
		HashSet<String> tempSet = new HashSet<String>(); 
		//定义给maxKey，保存在一 次遍历过程中， 能够覆盖最大未覆盖的地区对应的电台的key
		//如果maxKey不为null，则会加入到selects
		String maxKey = null;
		while(allAreas.size() != 0) { //如果allAreas不为0,则表示还没有覆盖到所有的地区
			maxKey = null;
		//遍历broadcasts,取出对应key
			for (Entry<String, HashSet<String>> a : broadcasts.entrySet()) {
				
				tempSet.clear();
				
				//当前key能覆盖的地区
				HashSet<String> area = a.getValue();
				tempSet.addAll(area);
				//取交集重新赋给tempSet 
				tempSet.retainAll(allAreas);
				if(tempSet.size() > 0 &&
					(maxKey == null || tempSet.size() >broadcasts.get(maxKey).size())){
					maxKey = a.getKey();
				}
				
			}
			//maxKey != null,就应该将maxKey加入selects
			if(maxKey != null) {
				selects.add(maxKey);
				//将maxKey指向的广播电台覆盖的地区，从allAreas去掉
				allAreas.removeAll(broadcasts.get(maxKey));
			}
			
		}
		System.out.println("結果：" + selects);		
	}
}
