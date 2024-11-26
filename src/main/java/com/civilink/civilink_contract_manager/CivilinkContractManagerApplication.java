package com.civilink.civilink_contract_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CivilinkContractManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CivilinkContractManagerApplication.class, args);
	}

}
