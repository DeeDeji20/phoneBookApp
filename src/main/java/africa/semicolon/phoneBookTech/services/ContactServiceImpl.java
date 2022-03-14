package africa.semicolon.phoneBookTech.services;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.data.repositories.ContactRepository;
import africa.semicolon.phoneBookTech.data.repositories.ContactRepositoryImpl;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBookTech.dtos.request.UpdateContactRequest;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import africa.semicolon.phoneBookTech.dtos.response.DeleteContactResponse;
import africa.semicolon.phoneBookTech.dtos.response.UpdateContactResponse;
import africa.semicolon.phoneBookTech.exception.ContactNotFoundException;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    private ContactRepository db = new ContactRepositoryImpl();
    @Override
    public AddContactResponseDto save(AddContactRequestDto request) {
        Contact contactToBeAdded = new Contact(request.getFirstName(),
                                    request.getLastName(),
                                    request.getMobile());
        db.addContact(contactToBeAdded);
        AddContactResponseDto response = getResponse(contactToBeAdded);
        return response;
    }

    private AddContactResponseDto getResponse(Contact contactToBeAdded) {
        AddContactResponseDto response = new AddContactResponseDto();
        response.setFullName(contactToBeAdded.getFirstName() + " " +  contactToBeAdded.getLastName());
        response.setMobile(contactToBeAdded.getMobile());
        response.setStatus("Contact saved");
        return response;
    }

    @Override
    public ContactRepository getDataBase() {
        return db;
    }

    @Override
    public DeleteContactResponse delete(DeleteContactRequest deleteRequest) {
        Contact contactToBeDeleted = new Contact(deleteRequest.getFirstName(), deleteRequest.getMobile());
        db.removeContact(contactToBeDeleted);
        return null;
    }

    @Override
    public AddContactResponseDto search(String params) {
        for (Contact contact : db.findAll()){
            if (isValidContactInPhoneBook(params, contact)) {
                AddContactResponseDto response = new AddContactResponseDto();
                response.setFullName(contact.getFirstName() + " " + contact.getLastName());
                response.setMobile(contact.getMobile());
                return response;
            }
        }
        throw new ContactNotFoundException(params + "not found");
    }

    @Override
    public List<Contact> getAllContacts() {
        return db.findAll();
    }

    @Override
    public UpdateContactResponse editContact(UpdateContactRequest request, String mobile) {
       List<Contact> contacts= db.findBy(mobile);
       if(contacts.isEmpty()) throw new ContactNotFoundException("Contact not found");
       else {
           System.out.println(contacts.get(0));
           if (request.getFirstName() != null) contacts.get(0).setFirstName(request.getFirstName());
           if (request.getLastName() != null) contacts.get(0).setLastName(request.getLastName());
           if (request.getMobile() != null) contacts.get(0).setMobile(request.getMobile());
           if (request.getOffice() != null) contacts.get(0).setOffice(request.getOffice());
           System.out.println(contacts.get(0));
       }

        db.addContact(contacts.get(0));
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
