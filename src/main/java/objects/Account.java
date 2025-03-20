package objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private String accountName;
    private String webSite;
    private String type;
    private String description;
    private String phone;
}
