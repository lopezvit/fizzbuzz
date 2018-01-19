package fi.serviceflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author Alejandro López(alejandro) {@literal <Alejandro.Lopez@xplain.net>} on 18/01/2018.
 */
@SpringBootApplication
public class FizzBuzzApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(FizzBuzzApplication.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(FizzBuzzApplication.class, args);
  }
}
