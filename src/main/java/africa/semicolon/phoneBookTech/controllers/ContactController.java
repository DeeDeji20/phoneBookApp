package africa.semicolon.phoneBookTech.controllers;

import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import africa.semicolon.phoneBookTech.services.ContactService;
import africa.semicolon.phoneBookTech.services.ContactServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact/")
public class ContactController {
    ContactService service = new ContactServiceImpl();

    @PostMapping("/saveContact")
    public AddContactResponseDto Contact(@RequestBody AddContactRequestDto contact){
        return service.save(contact);
    }
}
