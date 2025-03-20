package objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {
    private String salutation;
    private String firstName;
    private String lastName;
    private String accountName;
    private String phoneContact;
}

