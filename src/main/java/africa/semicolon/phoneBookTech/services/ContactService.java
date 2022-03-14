package africa.semicolon.phoneBookTech.services;

import africa.semicolon.phoneBookTech.data.repositories.ContactRepository;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import africa.semicolon.phoneBookTech.dtos.response.DeleteContactResponse;

public interface ContactService {
    AddContactResponseDto save(AddContactRequestDto contact);

    ContactRepository getDataBase();

    DeleteContactResponse delete(DeleteContactRequest deleteRequest);

    AddContactResponseDto findBy(String firstName);
}
