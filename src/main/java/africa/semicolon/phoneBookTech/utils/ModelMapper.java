package africa.semicolon.phoneBookTech.utils;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.dtos.request.UpdateContactRequest;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;

import java.util.List;

public class ModelMapper {
    public static AddContactResponseDto map(Contact contactToBeAdded) {
        AddContactResponseDto response = new AddContactResponseDto();
        response.setFullName(contactToBeAdded.getFirstName() + " " +  contactToBeAdded.getLastName());
        response.setMobile(contactToBeAdded.getMobile());
        response.setStatus("Contact saved");
        return response;
    }

    public static void checkValidUpdateRequest(UpdateContactRequest request, List<Contact> contacts) {
        if (request.getFirstName() != null) contacts.get(0).setFirstName(request.getFirstName());
        if (request.getLastName() != null) contacts.get(0).setLastName(request.getLastName());
        if (request.getMobile() != null) contacts.get(0).setMobile(request.getMobile());
        if (request.getOffice() != null) contacts.get(0).setOffice(request.getOffice());
    }
}
