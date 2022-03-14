package africa.semicolon.phoneBookTech.controllers;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import africa.semicolon.phoneBookTech.dtos.response.DeleteContactResponse;
import africa.semicolon.phoneBookTech.services.ContactService;
import africa.semicolon.phoneBookTech.services.ContactServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact/")
public class ContactController {
    ContactService service = new ContactServiceImpl();

    @PostMapping("/saveContact")
    public AddContactResponseDto save(@RequestBody AddContactRequestDto contact){
        return service.save(contact);
    }

    @DeleteMapping("/{id}")
    public DeleteContactResponse delete(@RequestBody DeleteContactRequest contact, @PathVariable String id){
        return service.delete(contact);
    }

    @GetMapping("/{searchParams}")
    public AddContactResponseDto search(@PathVariable String searchParams){
        return service.search(searchParams);
    }

    @GetMapping("/allContact")
    public List<Contact> getAllContact(){
        return service.getAllContacts();
    }

}

