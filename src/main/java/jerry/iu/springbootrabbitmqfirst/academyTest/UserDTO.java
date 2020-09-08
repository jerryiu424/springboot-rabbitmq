package jerry.iu.springbootrabbitmqfirst.academyTest;

import lombok.*;

import java.io.Serializable;

/**
 * A user.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private String fullName;

  private String email;

}
