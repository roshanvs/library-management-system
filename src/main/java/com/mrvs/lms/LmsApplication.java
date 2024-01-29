package com.mrvs.lms;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {
//		String connectionString = "mongodb+srv://mohammedvsroshan:7l3umGANWXdtbbmI@cluster0.egedcow.mongodb.net/?retryWrites=true&w=majority";
//		ServerApi serverApi = ServerApi.builder()
//				.version(ServerApiVersion.V1)
//				.build();
//		MongoClientSettings settings = MongoClientSettings.builder()
//				.applyConnectionString(new ConnectionString(connectionString))
//				.serverApi(serverApi)
//				.build();
//		// Create a new client and connect to the server
//		try (MongoClient mongoClient = MongoClients.create(settings)) {
//			try {
//				// Send a ping to confirm a successful connection
//				MongoDatabase database = mongoClient.getDatabase("admin");
//				database.runCommand(new Document("ping", 1));
//				System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
//			} catch (MongoException e) {
//				e.printStackTrace();
//			}}
		SpringApplication.run(LmsApplication.class, args);
	}

}
