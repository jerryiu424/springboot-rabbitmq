package jerry.iu.springbootrabbitmqfirst.tut1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "JerryRabbitMQueue")
public class Tut1Receiver {

  @RabbitHandler
  public void receive(String in) {
    System.out.println(" [x] Received '" + in + "'");
  }
}
