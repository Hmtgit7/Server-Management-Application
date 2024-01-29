package com.sparkdevelopie.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sparkdevelopie.server.Model.Server;
import com.sparkdevelopie.server.enumeration.Status;
import com.sparkdevelopie.server.repo.ServerRepo;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepo serverRepo){
		return args -> {
			serverRepo.save(new Server(null,"192.168.1.160", "Ubuntu Linux", "16 GB", "Personal PC", "https://localhost:8080/server/image/server1.png", Status.SERVER_UP));
			serverRepo.save(new Server(null,"192.168.1.161", "Ubuntu Linux", "16 GB", "Personal PC", "https://localhost:8080/server/image/server2.png", Status.SERVER_UP));
			serverRepo.save(new Server(null,"192.168.1.162", "Ubuntu Linux", "16 GB", "Personal PC", "https://localhost:8080/server/image/server3.png", Status.SERVER_UP));
			serverRepo.save(new Server(null,"192.168.1.163", "Ubuntu Linux", "16 GB", "Personal PC", "https://localhost:8080/server/image/server4.png", Status.SERVER_UP));
		};
	}
}