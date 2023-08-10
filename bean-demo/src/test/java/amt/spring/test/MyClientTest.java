package amt.spring.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.amt.spring.demo.AppConfig;
import com.amt.spring.demo.beans.MyClient;

@SpringJUnitConfig(classes = AppConfig.class)
public class MyClientTest {
	@Autowired
	private MyClient client;
	
	@Test
	void demo() {
		client.work();
	}
}
