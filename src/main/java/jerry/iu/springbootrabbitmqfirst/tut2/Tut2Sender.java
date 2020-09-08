package jerry.iu.springbootrabbitmqfirst.tut2;

import jerry.iu.springbootrabbitmqfirst.academyTest.UserDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tut2Sender {

  @Autowired
  private RabbitTemplate template;

  @Scheduled(fixedDelay = 1000, initialDelay = 500)
  public void send() {

    template.convertAndSend("", "user_management", new UserDTO().toBuilder()
      .fullName("Ash Ketchum")
      .email("ash@gmail.com")
      .build().toString());
  }

}
