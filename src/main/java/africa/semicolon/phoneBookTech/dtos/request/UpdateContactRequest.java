package africa.semicolon.phoneBookTech.dtos.request;

import lombok.Data;

@Data
public class UpdateContactRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String mobile;
    private String office;
}
