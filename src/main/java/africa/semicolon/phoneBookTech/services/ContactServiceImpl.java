package africa.semicolon.phoneBookTech.services;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.data.repositories.ContactRepository;
import africa.semicolon.phoneBookTech.data.repositories.ContactRepositoryImpl;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import africa.semicolon.phoneBookTech.dtos.response.DeleteContactResponse;

public class ContactServiceImpl implements ContactService {
    private ContactRepository db = new ContactRepositoryImpl();
    @Override
    public AddContactResponseDto save(AddContactRequestDto request) {
        
        Contact contactToBeAdded = new Contact(request.getFirstName(),
                                    request.getLastName(),
                                    request.getMobile());
        db.addContact(contactToBeAdded);

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
    public AddContactResponseDto findBy(String name) {
        for (Contact contact : db.findAll()){
            if (contact.getFirstName().equalsIgnoreCase(name)||
                contact.getLastName().equalsIgnoreCase(name)) {
                AddContactResponseDto response = new AddContactResponseDto();
                response.setFullName(contact.getFirstName() + " " + contact.getLastName());
                response.setMobile(contact.getMobile());
                return response;
            }
        }
        return null;
    }
}
