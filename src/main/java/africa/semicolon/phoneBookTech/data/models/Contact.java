package africa.semicolon.phoneBookTech.data.models;

import lombok.*;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Contact {
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
