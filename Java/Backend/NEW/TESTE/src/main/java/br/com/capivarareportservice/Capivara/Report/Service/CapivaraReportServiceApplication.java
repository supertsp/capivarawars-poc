package br.com.capivarareportservice.Capivara.Report.Service;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapivaraReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapivaraReportServiceApplication.class, args);
		String uri = "mongodb+srv://root:root123@capireport-sgqyr.mongodb.net/test";
		MongoClientURI clientURI = new MongoClientURI(uri);
		MongoClient mongoClient = new MongoClient(clientURI);
		
		MongoDatabase mongoDatabase = mongoClient.getDatabase("CapivaraWarsReport");
		MongoCollection collection = mongoDatabase.getCollection("capivaraWarsReport");
		
		System.out.println("SUBIU!!!!!!!!!!!!!!!!!!");
	}

}
