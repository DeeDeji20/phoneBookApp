package africa.semicolon.phoneBookTech.services;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.data.repositories.ContactRepository;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBookTech.dtos.request.UpdateContactRequest;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import africa.semicolon.phoneBookTech.dtos.response.DeleteContactResponse;
import africa.semicolon.phoneBookTech.dtos.response.UpdateContactResponse;
import africa.semicolon.phoneBookTech.exception.ContactExistsException;
import africa.semicolon.phoneBookTech.exception.ContactNotFoundException;
import africa.semicolon.phoneBookTech.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository db;
    @Override
    public AddContactResponseDto save(AddContactRequestDto request) {
        Contact contactToBeAdded = new Contact(request.getFirstName(),
                                    request.getLastName(),
                                    request.getMobile());
        db.save(contactToBeAdded);
        AddContactResponseDto response = ModelMapper.map(contactToBeAdded);
        return response;
    }

    @Override
    public ContactRepository getDataBase() {
        return db;
    }

    @Override
    public DeleteContactResponse delete(String mobile) {
        for (Contact contact : db.findAll()) {
            if(contact.getMobile().equalsIgnoreCase(mobile)) db.delete(contact);
            else throw new ContactExistsException("Contact doesn't exist");
        }
        DeleteContactResponse response = new DeleteContactResponse();
        response.setMessage("Deleted");
        return response;
    }

    @Override
    public List<AddContactResponseDto> search(String params) {
        List<AddContactResponseDto> contacts = new ArrayList<>();

        for (Contact contact : db.findAll()){
            System.out.println(db.findAll());
            if (isValidContactInPhoneBook(params, contact)) {
                AddContactResponseDto response = new AddContactResponseDto();
                response.setFullName(contact.getFirstName() + " " + contact.getLastName());
                response.setMobile(contact.getMobile());
                contacts.add(response);
                System.out.println(response);
            }
              else throw new ContactNotFoundException(params + " not found");
        }
            return contacts;
    }

    @Override
    public List<Contact> getAllContacts() {
        return db.findAll();
    }

    @Override
    public UpdateContactResponse edit(UpdateContactRequest request, String mobile) {
       List<Contact> contacts= db.findByMobile(mobile);
       if(contacts.isEmpty()) throw new ContactNotFoundException("Contact not found");
       else {
           ModelMapper.checkValidUpdateRequest(request, contacts);
       }
        db.save(contacts.get(0));
        UpdateContactResponse response= new UpdateContactResponse();
        response.setMessage("Conatct edited");
        System.out.println(response.getMessage());
        return response;
    }

    private boolean isValidContactInPhoneBook(String params, Contact contact) {
        return contact.getFirstName().trim().equalsIgnoreCase(params) ||
                contact.getLastName().trim().equalsIgnoreCase(params) ||
                contact.getMobile().trim().equalsIgnoreCase(params);
    }
}
