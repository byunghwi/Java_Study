import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class E06_JSON {
	// # JSON
	// - JavaScript에서 사용하는 Map타입
	// - 문자열만으로 Map을 표현할 수 있다.
	// - { 
	//	   Key : Value ,
	//	   Key : Value ,
	//	   Key : Value 
	//	  }
	
	// # JSON Value에 사용되는 자바스크립트 타입들
	// - '', "" : String
	// - 숫자, 소수 : Number
	// - [] : Array
	// - {} : JSON
	
	// Java에서는 JSON 타입을 지원하지 않기 때문에
	// 데이터들을 JSON 형태의 문자열로 만들어 줘야한다(Parsing, Binding)
	public static String PATH = "D:\\Java_IO\\JSON.json";
	
	public static void main(String[] args) throws IOException {
		//다음 Map에 저장된 데이터를 JSON형태의 문자열로 생성하여 출력하라.
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "민수");
		map.put("age", 15);
		map.put("tel", "010-9796-9885");
		map.put("blood", "AB");
		map.put("money", 50000);
		map.put("제일 좋아하는 장난감", "축구공");
		map.put("programming", new String[] {"JAVA","PYTHON", "JS"});
		
		
		//JSON Form으로 변환하기
		String result = makeJSON(map);
		//System.out.println(result);
		
		System.out.println();
		
		System.out.println("JSON to Map -->");
		//JSON파일에 저장된 데이터를 JAVA맵으로 변환하는 메서드를 만드시오.	
		for(Map.Entry<String, Object> entry : jsonFileToMap().entrySet()) {
			System.out.println("key -> "+ entry.getKey() +"\t value ->" + entry.getValue());
		}
		
	}
	
	public static String makeJSON(HashMap<String, Object> origin) {
		
		StringBuilder result= new StringBuilder();
		result.append("{");
		int count = 0;
		int count2 = 0;
		int count3 = 0;
		for (Map.Entry<String, Object> entry : origin.entrySet()) {	
			if(entry.getValue() instanceof String) {
				result.append( entry.getKey() + ":" + "\""+entry.getValue()+"\"");
			}else if(entry.getValue() instanceof Integer) {
				result.append( entry.getKey()+ ":" +entry.getValue());
			}else if(entry.getValue() instanceof Object[]) {
				
				result.append( entry.getKey() + ":[" );
				if (entry.getValue() instanceof String[]) {
					System.out.println();
					for(String entry2 : (String[]) entry.getValue()) {
						result.append( "\""+entry2+"\"");
						count2++;
						if(count2 < ((String[]) entry.getValue()).length) {
							result.append( "," );
						}
					}	
				} else {
					for(int entry2 : (Integer[]) entry.getValue()) {
						result.append(entry2);
						count3++;
						if(count3 < ((Integer[]) entry.getValue()).length) {
							result.append( "," );
						}
					}
				}
				result.append("]");			
			}
			
			count++;
		
			if(count<origin.size()) {
				result.append(", ");
			}
		}
		result.append("}");
		
		try {
			FileWriter fw = new FileWriter(PATH);
			fw.write(result.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Map to JSON -> " + result.toString());
		return result.toString();
		
	}
	
	public static HashMap<String, Object> jsonFileToMap() throws IOException{
		HashMap<String, Object> jsonToMap = new HashMap<String, Object>();
		BufferedReader br = null;
		String jsonType="";
		try {
			br = new BufferedReader(new FileReader(PATH)) ;
			jsonType = br.readLine();
		} catch (FileNotFoundException e) {
			System.err.println("파일이 없습니다.");
			e.printStackTrace();
		}finally {
			if(br!= null)
				br.close();
		}
		
		//{money:50000, name:"홍길동", tel:"010-9796-9885", blood:"AB", age:15, programming:['JAVA', 'PYTHON', 'JS']}
		
		jsonType = jsonType.substring(1, jsonType.length()-1);
		String [] entry = jsonType.split(", ");
		for (String et : entry) {
			String keyValue [] = et.split(":");
			if(et.contains("[")) {
				if(et.contains("\"")) {		
					String valuesArr[] = (keyValue[1].replace("[", "").replace("]", "").replace("\"", "")).split(",");
					jsonToMap.put(keyValue[0], valuesArr);
				}else {
					 String valuesArr[] = (keyValue[1].replace("[", "").replace("]", "").replace("\"", "")).split(",");
					 int valuesArrRs[] = new int[valuesArr.length];
					 int count = 0;
					 for(String a : valuesArr) {
						 valuesArrRs[count++] = Integer.parseInt(a);
					 }
					jsonToMap.put(keyValue[0], valuesArrRs);
				}
			}else {	
				//String일때
				if(et.contains("\"")) {
					jsonToMap.put(keyValue[0], keyValue[1].replaceAll("\"", ""));
				}else {
					jsonToMap.put(keyValue[0], Integer.parseInt(keyValue[1]));
				}
				
			}
		}
		
		System.out.println(((String[])(jsonToMap.get("programming")))[0]);
		System.out.println((Integer)(jsonToMap.get("age")));
		System.out.println(jsonToMap.get("programming") instanceof String[]);
		System.out.println(jsonToMap.get("zip") instanceof int[]);
		
		return jsonToMap;
	}
}


