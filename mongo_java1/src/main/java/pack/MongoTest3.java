package pack;

import java.util.Map.Entry;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoTest3 { 
	public static void main(String[] args) {
		// 불특정 필드를 처리하기 : 동적 처리
		String uri = "mongodb://localhost:27017";
		
		try (MongoClient client = MongoClients.create(uri)) {
			MongoDatabase db = client.getDatabase("test");
			MongoCollection<Document> collection = db.getCollection("customer");
			
			for(Document doc:collection.find()) {
				//각 Document 내의 field(Key-Value)를 반복
				for(Entry<String, Object> entry:doc.entrySet()) {
					String fieldName = entry.getKey();
					Object fieldValue = entry.getValue();
					System.out.print(fieldName + " " + fieldValue);
				}
				System.out.println();
			}
			
			System.out.println("건수 : " + collection.countDocuments());
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
	}
}
