package jerry.iu.springbootrabbitmqfirst.cloudStreamTest;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface AcademyCloudStreamBinding {
  @Output("user_management")
  MessageChannel userChannel();
}
