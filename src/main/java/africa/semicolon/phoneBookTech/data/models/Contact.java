package africa.semicolon.phoneBookTech.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Document("Contacts")

public class Contact {
    @Id
    private String id;
    @NonNull  @Getter @Setter
    private String firstName;
    @NonNull @Getter @Setter
    private String lastName;
    private String middleName;
    @NonNull  @Getter @Setter
    private String mobile;
    private String office;

    public Contact(String firstName, String mobile) {
        this.firstName = firstName;
        this.mobile = mobile;
    }
}
