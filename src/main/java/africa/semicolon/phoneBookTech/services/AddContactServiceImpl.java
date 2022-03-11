package africa.semicolon.phoneBookTech.services;

import africa.semicolon.phoneBookTech.data.models.Contacts;
import africa.semicolon.phoneBookTech.data.repositories.ContactRepository;
import africa.semicolon.phoneBookTech.data.repositories.ContactRepositoryImpl;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;

public class AddContactServiceImpl implements AddContactService{
    private ContactRepository db = new ContactRepositoryImpl();
    @Override
    public AddContactResponseDto save(AddContactRequestDto request) {
        System.out.println(request.getFirstName());
        Contacts contactToBeAdded = new Contacts(request.getFirstName(),
                                    request.getLastName(),
                                    request.getMobile());

        db.addContact(contactToBeAdded);

        AddContactResponseDto response = new AddContactResponseDto();
        response.setFirstName(contactToBeAdded.getFirstName());
        response.setLastName(contactToBeAdded.getLastName());
        response.setMobile(contactToBeAdded.getMobile());
        return response;
    }

    @Override
    public ContactRepository getDataBase() {
        return db;
    }
}
