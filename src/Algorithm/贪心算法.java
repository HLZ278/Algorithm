package Algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
//�����̨ѡ������
//������K1,K2,K3,K4,K5
//�ֱ𸲸ǲ�ͬ�Ҷ��������
//�����ѡ��������ŵĸ��������е���
public class ̰���㷨 {
	public static void main(String[] args) {
		HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1. add("����");
		hashSet1. add("�Ϻ�");
		hashSet1. add("���");
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2. add("����");
		hashSet2. add("����");
		hashSet2. add("����");
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3. add("�ɶ�");
		hashSet3.add("�Ϻ�");
		hashSet3. add("����");
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("�Ϻ�");
		hashSet4. add("���");
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5. add("����");
		hashSet5. add("����");

		
		//���뵽map
		broadcasts. put("K1", hashSet1);
		broadcasts. put( "K2", hashSet2);
		broadcasts. put("K3", hashSet3);
		broadcasts.put("K4", hashSet4);
		broadcasts. put("K5", hashSet5);
		//������г���
		HashSet<String> allAreas = new HashSet<String>();
		Collection<HashSet<String>> values = broadcasts.values();
		Iterator<HashSet<String>> iterator = values.iterator();
		while (iterator.hasNext()) {
			allAreas.addAll(iterator.next());
			
		}
		
		//����ArrayList,���ѡ��ĵ�̨����
		ArrayList<String> selects = new ArrayList<String>();
		//����һ����ʱ�ļ��ϣ��ڱ����Ĺ����У�������������еĵ�̨���ǵĵ����͵�ǰ��û�и��ǵĵ����Ľ���
		HashSet<String> tempSet = new HashSet<String>(); 
		//�����maxKey��������һ �α��������У� �ܹ��������δ���ǵĵ�����Ӧ�ĵ�̨��key
		//���maxKey��Ϊnull�������뵽selects
		String maxKey = null;
		while(allAreas.size() != 0) { //���allAreas��Ϊ0,���ʾ��û�и��ǵ����еĵ���
			maxKey = null;
		//����broadcasts,ȡ����Ӧkey
			for (Entry<String, HashSet<String>> a : broadcasts.entrySet()) {
				
				tempSet.clear();
				
				//��ǰkey�ܸ��ǵĵ���
				HashSet<String> area = a.getValue();
				tempSet.addAll(area);
				//ȡ�������¸���tempSet 
				tempSet.retainAll(allAreas);
				if(tempSet.size() > 0 &&
					(maxKey == null || tempSet.size() >broadcasts.get(maxKey).size())){
					maxKey = a.getKey();
				}
				
			}
			//maxKey != null,��Ӧ�ý�maxKey����selects
			if(maxKey != null) {
				selects.add(maxKey);
				//��maxKeyָ��Ĺ㲥��̨���ǵĵ�������allAreasȥ��
				allAreas.removeAll(broadcasts.get(maxKey));
			}
			
		}
		System.out.println("�Y����" + selects);		
	}
}
