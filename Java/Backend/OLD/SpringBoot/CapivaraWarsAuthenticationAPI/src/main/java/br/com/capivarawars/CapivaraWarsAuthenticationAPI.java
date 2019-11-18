package br.com.capivarawars;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CapivaraWarsAuthenticationAPI {

	public static void main(String[] args) {
		SpringApplication.run(CapivaraWarsAuthenticationAPI.class, args);

		System.out.println(
				"\n\n"
				+ "         ^_^    +---------+        \n"
				+ "  .-----/  0\\   | SIGN IN |       \n"
				+ " /  \\     __/   +---------+       \n"
				+ " \\  /_- -/      |  NICK   |       \n"
				+ "  \\\\\\  \\\\\\      |  PASS   |  \n"
				+ "~~~~~~~~~~~~~~~~+~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				+ ">>> NOW, RUNNING A CAPIVARA SERVER DATABASE ON A RIVER API ;)\n"
		);
	}

	
}
