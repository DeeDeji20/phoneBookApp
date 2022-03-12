package africa.semicolon.phoneBookTech.dtos.response;

import lombok.Data;

@Data
public class AddContactResponseDto {
    private String fullName;
    private String mobile;
    private String status;
}
