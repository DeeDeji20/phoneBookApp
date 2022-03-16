package africa.semicolon.phoneBookTech.controllers;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBookTech.dtos.request.UpdateContactRequest;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import africa.semicolon.phoneBookTech.dtos.response.DeleteContactResponse;
import africa.semicolon.phoneBookTech.dtos.response.UpdateContactResponse;
import africa.semicolon.phoneBookTech.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact/")
public class ContactController {
    @Autowired
    ContactService service;

    @PostMapping("/saveContact")
    public AddContactResponseDto save(@RequestBody AddContactRequestDto contact){
        return service.save(contact);
    }

    @DeleteMapping("/{id}")
    public DeleteContactResponse delete(@PathVariable String id){
        return service.delete(id);
    }

    @GetMapping("/find/{searchParams}")
    public List<AddContactResponseDto>  search(@PathVariable String searchParams){
        return service.search(searchParams);
    }

    @GetMapping("/allContact")
    public List<Contact> getAllContact(){
        return service.getAllContacts();
    }

    @PatchMapping("/editContact/{mobile}")
    public UpdateContactResponse edit(@RequestBody UpdateContactRequest request, @PathVariable String mobile){
        return service.edit(request, mobile);
    }
}

