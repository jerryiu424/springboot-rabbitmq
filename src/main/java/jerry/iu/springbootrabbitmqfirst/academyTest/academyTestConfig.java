package jerry.iu.springbootrabbitmqfirst.academyTest;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"academy"})
@Configuration
public class academyTestConfig {

  @Bean
  public DirectExchange direct() {
    return new DirectExchange("academy_client");
  }

  private static class ReceiverConfig {

    @Bean
    public Queue userQueue() {
      return new Queue("user_management");
    }

    @Bean
    public Queue courseQueue() {
      return new Queue("course_management");
    }

    @Bean
    public Binding userBinding(DirectExchange direct,
                               Queue userQueue) {
      return BindingBuilder.bind(userQueue)
        .to(direct)
        .with("user_management");
    }

    @Bean
    public Binding courseBinding(DirectExchange direct,
                                 Queue courseQueue) {
      return BindingBuilder.bind(courseQueue)
        .to(direct)
        .with("course_management");
    }

    @Bean
    public RabbitMQReceiver rabbitMQReceiver() {
      return new RabbitMQReceiver();
    }
  }

  @Profile("sender")
  @Bean
  public RabbitMQSender rabbitMQSender() {
    return new RabbitMQSender();
  }
}
