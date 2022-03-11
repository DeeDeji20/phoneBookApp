package africa.semicolon.phoneBookTech.dtos.request;

import lombok.Data;

@Data
public class AddContactRequestDto {
    private String firstName;
    private String lastName;
    private String mobile;
}
