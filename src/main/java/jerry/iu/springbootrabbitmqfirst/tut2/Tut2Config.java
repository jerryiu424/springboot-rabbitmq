package jerry.iu.springbootrabbitmqfirst.tut2;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut2", "work-queues"})
@Configuration
public class Tut2Config {

  @Profile("sender")
  @Bean
  public Tut2Sender sender() {
    return new Tut2Sender();
  }
}
