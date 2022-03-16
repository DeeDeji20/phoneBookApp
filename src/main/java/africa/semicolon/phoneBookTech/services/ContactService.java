package africa.semicolon.phoneBookTech.services;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.data.repositories.ContactRepository;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBookTech.dtos.request.UpdateContactRequest;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import africa.semicolon.phoneBookTech.dtos.response.DeleteContactResponse;
import africa.semicolon.phoneBookTech.dtos.response.UpdateContactResponse;

import java.util.List;

public interface ContactService {
    AddContactResponseDto save(AddContactRequestDto contact);

    ContactRepository getDataBase();

//    DeleteContactResponse delete(DeleteContactRequest deleteRequest);

    DeleteContactResponse delete(String mobile);

    List<AddContactResponseDto> search(String firstName);

    List<Contact> getAllContacts();

    UpdateContactResponse edit(UpdateContactRequest request, String mobile);
}
