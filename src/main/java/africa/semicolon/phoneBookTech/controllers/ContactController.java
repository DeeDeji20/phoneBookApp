package africa.semicolon.phoneBookTech.controllers;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBookTech.dtos.request.UpdateContactRequest;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import africa.semicolon.phoneBookTech.dtos.response.ApiResponse;
import africa.semicolon.phoneBookTech.dtos.response.DeleteContactResponse;
import africa.semicolon.phoneBookTech.dtos.response.UpdateContactResponse;
import africa.semicolon.phoneBookTech.exception.ContactExistsException;
import africa.semicolon.phoneBookTech.exception.ContactNotFoundException;
import africa.semicolon.phoneBookTech.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    ContactService service;

    @PostMapping("/saveContact")
    public AddContactResponseDto save(@RequestBody AddContactRequestDto contact){
        return service.save(contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        try{
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        }catch(ContactExistsException ex){
            return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/{searchParams}")
    public ResponseEntity<?> search(@PathVariable String searchParams){
        try {
            return new ResponseEntity<>(service.search(searchParams), HttpStatus.OK);
        }catch (ContactNotFoundException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),  HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allContact")
    public List<Contact> getAllContact(){
        return service.getAllContacts();
    }

    @PatchMapping("/editContact/{mobile}")
    public ResponseEntity<?> edit(@RequestBody UpdateContactRequest request, @PathVariable String mobile){
        try{
            return new ResponseEntity<>(service.edit(request, mobile), HttpStatus.OK);
        }catch(ContactNotFoundException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}

