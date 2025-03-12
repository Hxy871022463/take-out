package skytakeout.takeoutserver;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@OpenAPIDefinition(info = @Info(title = "测试用例" , description = "对Swagger3进行测试" , version = "1.0.0"))
@Slf4j
@SpringBootApplication

public class TakeOutServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeOutServerApplication.class, args);
    }

}
