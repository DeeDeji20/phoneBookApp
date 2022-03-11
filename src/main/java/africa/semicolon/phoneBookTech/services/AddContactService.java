package africa.semicolon.phoneBookTech.services;

import africa.semicolon.phoneBookTech.data.repositories.ContactRepository;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;

public interface AddContactService {
    AddContactResponseDto save(AddContactRequestDto contact);

    ContactRepository getDataBase();
}
