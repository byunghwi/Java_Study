package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
	Map<String, Map<String, String>> phoneBook = new HashMap<String, Map<String,String>>();
	Map<String, String> groupMap = new HashMap<String, String>();
	
	//그룹추가
	public void addGroup(String group) {

		if(phoneBook.containsKey(group)) {
			System.out.println("\t※ ("+group+")" + " 이미 해당 그룹이 있습니다.");
			return;
		}
		phoneBook.put(group, new HashMap<String, String>());
		System.out.println("(" + group + ") 그룹이 추가되었습니다.");
	}
	
	//전화번호 추가
	public void addPhoneNum(String num, String name, String group) {
		groupMap = phoneBook.get(group);
		groupMap.put(num, name);		
	}
	
	//이쁘게 찍기
	public void printPhoneBook() {
		for (String group : phoneBook.keySet()) {
			
			//정렬하기.
			System.out.println("\n=============" +group+"("+phoneBook.get(group).size() +")"+  "=============");
				
		    for (Map.Entry<String, String> entry : sortByName(group)) {
				System.out.println(entry.getValue() + " : " + entry.getKey());
			}
		}
	}
	
	//이름 순으로 정렬하기.
	public List<Map.Entry<String, String>> sortByName(String group){
		List<Map.Entry<String, String>> listEntrySort = new ArrayList<>(phoneBook.get(group).entrySet());
		Collections.sort(listEntrySort, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		return listEntrySort;
	}
	
	//이름과 일치하는 항목 찾기
	public void findName(String name) {
		int countName = 0;
		System.out.println("\n=============찾으시는 이름과 일치하는 목록입니다=============");
		for (String group : phoneBook.keySet()) {
			for (Map.Entry<String, String> entry : sortByName(group)) {
				if(entry.getValue().contains(name)) {
					System.out.println(entry.getValue() + " : " + entry.getKey());
					countName++;
				}	
			}
		}
		if(countName > 0)
			System.out.println("총 "+ countName + " 건입니다.");
		else
			System.out.println("일치하는 항목이 없습니다.");
	}
	
	//번호와 일치하는 항목 찾기
	public void findNum(String num) {
		int countNum = 0;
		System.out.println("\n=============찾으시는 번호과 일치하는 목록입니다=============");
		for (String group : phoneBook.keySet()) {
			for (Map.Entry<String, String> entry : sortByName(group)) {
				if(entry.getKey().contains(num)) {
					System.out.println(entry.getValue() + " : " + entry.getKey());
					countNum++;
				}	
			}
		}
		
		if(countNum > 0)
			System.out.println("총 "+ countNum + " 건입니다.");
		else
			System.out.println("일치하는 항목이 없습니다.");
	}
}
