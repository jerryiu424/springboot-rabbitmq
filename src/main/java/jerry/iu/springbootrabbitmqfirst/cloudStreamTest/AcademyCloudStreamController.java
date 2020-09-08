package jerry.iu.springbootrabbitmqfirst.cloudStreamTest;

import jerry.iu.springbootrabbitmqfirst.academyTest.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AcademyCloudStreamController {

  private MessageChannel messageChannel;

  public AcademyCloudStreamController(AcademyCloudStreamBinding academyCloudStreamBinding){
    messageChannel = academyCloudStreamBinding.userChannel();
  }

  @GetMapping("/helloworld/{name}")
  public void send(@PathVariable String name){
    UserDTO userDTO = new UserDTO().toBuilder()
      .fullName(name)
      .email("ash@gmail.com")
      .build();

    Message<UserDTO> message = MessageBuilder.withPayload(userDTO).build();
    this.messageChannel.send(message);

    log.info("The user object SENT is:" + userDTO.toString());
  }

}
