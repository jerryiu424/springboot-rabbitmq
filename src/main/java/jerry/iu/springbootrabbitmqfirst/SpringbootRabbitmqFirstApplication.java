package jerry.iu.springbootrabbitmqfirst;

import jerry.iu.springbootrabbitmqfirst.cloudStreamTest.AcademyCloudStreamBinding;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableBinding(AcademyCloudStreamBinding.class)
@SpringBootApplication
@EnableScheduling
public class SpringbootRabbitmqFirstApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(SpringbootRabbitmqFirstApplication.class, args);
  }

  @Profile("usage_message")
  @Bean
  public CommandLineRunner usage() {
    return args -> {
      System.out.println("This app uses Spring Profiles to control its behavior.\n");
      System.out.println("Sample usage: java -jar rabbit - tutorials.jar --spring.profiles.active = hello - world, sender");
    };
  }


}
