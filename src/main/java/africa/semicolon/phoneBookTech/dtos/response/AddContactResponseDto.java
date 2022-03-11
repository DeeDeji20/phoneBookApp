package africa.semicolon.phoneBookTech.dtos.response;

import lombok.Data;

@Data
public class AddContactResponseDto {
    private String firstName;
    private String lastName;
    private String mobile;
}
