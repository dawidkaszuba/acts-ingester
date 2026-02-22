package pl.dawidkaszuba.acts_ingester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = ElasticsearchDataAutoConfiguration.class)
@EnableFeignClients
public class ActsIngesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActsIngesterApplication.class, args);
	}

}
