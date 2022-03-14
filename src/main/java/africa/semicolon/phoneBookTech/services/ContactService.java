package africa.semicolon.phoneBookTech.services;

import africa.semicolon.phoneBookTech.data.repositories.ContactRepository;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBookTech.dtos.request.UpdateContactRequest;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import africa.semicolon.phoneBookTech.dtos.response.DeleteContactResponse;
import africa.semicolon.phoneBookTech.dtos.response.UpdateContactResponse;

public interface ContactService {
    AddContactResponseDto save(AddContactRequestDto contact);

    ContactRepository getDataBase();

    DeleteContactResponse delete(DeleteContactRequest deleteRequest);

    AddContactResponseDto search(String firstName);

    UpdateContactResponse editContact(UpdateContactRequest request, AddContactRequestDto contactToBeAdded);
}
