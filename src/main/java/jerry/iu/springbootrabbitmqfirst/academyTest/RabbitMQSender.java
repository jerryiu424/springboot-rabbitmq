package jerry.iu.springbootrabbitmqfirst.academyTest;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class RabbitMQSender {

  @Autowired
  private RabbitTemplate template;

  @Scheduled(fixedDelay = 1000, initialDelay = 500)
  public void send() {
    UserDTO userDTO = new UserDTO();
    userDTO.setFullName("Ash Ketchum");
    userDTO.setEmail("ash@gmail.com");
//    template.convertAndSend("", "user_management", userDTO );
//    template.send("user_management", userDTO);
  }
}
