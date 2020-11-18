//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONValue;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//public class E07_JsonSimple {
//	//외부라이브러리 추가 -> 프로젝트 우클릭 -> BuildPath -> Lib Tab -> Add External Jar File
//	public static void main(String[] args) {
//		//map처럼 데이터를 추가한다.
//		JSONObject obj = new JSONObject();
//		
//		//JSON 배열을 만들기 위해서는 ArrayList를 사용해야한다.
//		ArrayList<String> arr = new ArrayList<String>();
//		
//		arr.add("Game");
//		arr.add("Soccer");
//		arr.add("Billiard");
//		
//		//JSON
//		obj.put("car", "BMW");
//		obj.put("addr", "금천구");
//		obj.put("age", 27);
//		obj.put("hobies", arr);
//		
//		//toString이 구현되어있음.
//		System.out.println(obj);
//		
//		String jsonStr = obj.toString();
//		System.out.println(jsonStr);
//		
//		JSONParser parser = new JSONParser();
//		
//		try {
//			JSONObject obj2 = (JSONObject)parser.parse(new FileReader("D:\\Java_IO\\JSON.json"));
//			
//			//JSONObject 내부의 배열 꺼내서 사용하기.
//			JSONArray programs = (JSONArray)(obj2.get("programming"));
//			
//			for (Object program : programs) {
//				System.out.println(program);
//			}
//			
//			//JSONObject 내부의 JSONObject 사용하기
//			JSONObject minsu = (JSONObject) obj2.get("민수");
//			System.out.println(minsu.get("제일 좋아하는 장난감"));
//			System.out.println(minsu.get("나이"));
//		} catch (ParseException e) {
//			System.out.println("Parse 오류");
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			System.out.println("파일 없음 오류");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("입출력 오류");
//			e.printStackTrace();
//		}
//	}
//}
