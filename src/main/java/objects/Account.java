package objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
    private String accountName;
    private String webSite;
    private String type;
    private String description;
    private String phone;

    public Account(String accountName, String webSite, String type, String description, String phone) {
        this.accountName = accountName;
        this.webSite = webSite;
        this.type = type;
        this.description = description;
        this.phone = phone;
    }
}
