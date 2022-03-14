package africa.semicolon.phoneBookTech.services;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBookTech.dtos.request.UpdateContactRequest;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import africa.semicolon.phoneBookTech.dtos.response.UpdateContactResponse;
import africa.semicolon.phoneBookTech.exception.ContactNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {

    ContactService contactService;
    @BeforeEach
    void setUp(){
        contactService = new ContactServiceImpl();
    }

    @Test
    void testThatAContactCanBeAddedToRepository(){
//        given
        AddContactRequestDto contactToBeAdded = new AddContactRequestDto();
        contactToBeAdded.setFirstName("Deji");
        contactToBeAdded.setLastName("Dee");
        contactToBeAdded.setMobile("070");
//        when
        contactService.save(contactToBeAdded);
//        check that
        assertEquals(1, contactService.getDataBase().count());
    }

    @Test
    void testThatCorrectResponseIsGottenBack() {
        //        given
        AddContactRequestDto contactToBeAdded = new AddContactRequestDto();
        contactToBeAdded.setFirstName("Deji");
        contactToBeAdded.setLastName("Dee");
        contactToBeAdded.setMobile("070");
//        when
       AddContactResponseDto response = contactService.save(contactToBeAdded);
        assertEquals(1, contactService.getDataBase().count());
        assertNotNull(response);
       assertEquals("Deji Dee", response.getFullName());
       assertEquals("070", response.getMobile());

    }

    @Test
    void testThatAcontactCanBeDeletedFromRepository(){
        //        given
        AddContactRequestDto contactToBeAdded = new AddContactRequestDto();
        contactToBeAdded.setFirstName("Deji");
        contactToBeAdded.setLastName("Dee");
        contactToBeAdded.setMobile("070");
        AddContactResponseDto response1 = contactService.save(contactToBeAdded);
        //        given
        AddContactRequestDto contactToBeAdded2 = new AddContactRequestDto();
        contactToBeAdded2.setFirstName("Lota");
        contactToBeAdded2.setLastName("Onwuka");
        contactToBeAdded2.setMobile("07054");

        AddContactResponseDto response2 = contactService.save(contactToBeAdded2);

        DeleteContactRequest deleteRequest = new DeleteContactRequest();
        deleteRequest.setFirstName("Lota");
        deleteRequest.setMobile("07054");
        contactService.delete(deleteRequest);
        assertEquals(1, contactService.getDataBase().count());
    }

    @Test
    void testThatAContactCanBeRetrievedByFirstName(){
        //        given
        AddContactRequestDto contactToBeAdded = new AddContactRequestDto();
        contactToBeAdded.setFirstName("Deji");
        contactToBeAdded.setLastName("Dee");
        contactToBeAdded.setMobile("070");
        contactService.save(contactToBeAdded);
        //        given
        AddContactRequestDto contactToBeAdded2 = new AddContactRequestDto();
        contactToBeAdded2.setFirstName("Lota");
        contactToBeAdded2.setLastName("Onwuka");
        contactToBeAdded2.setMobile("07054");

        contactService.save(contactToBeAdded2);

        AddContactResponseDto response2 = contactService.search(contactToBeAdded2.getFirstName());

        assertEquals("Lota Onwuka", response2.getFullName());
        assertEquals("07054", response2.getMobile());
    }

    @Test
    void testThatAcontactCanBeRetrievedByLastName() {
        //        given
        AddContactRequestDto contactToBeAdded = new AddContactRequestDto();
        contactToBeAdded.setFirstName("Deji");
        contactToBeAdded.setLastName("Dee");
        contactToBeAdded.setMobile("070");
        contactService.save(contactToBeAdded);
        //        given
        AddContactRequestDto contactToBeAdded2 = new AddContactRequestDto();
        contactToBeAdded2.setFirstName("Lota");
        contactToBeAdded2.setLastName("Onwuka");
        contactToBeAdded2.setMobile("07054");

        contactService.save(contactToBeAdded2);

        AddContactResponseDto response2 = contactService.search(contactToBeAdded2.getLastName());

        assertEquals("Lota Onwuka", response2.getFullName());
        assertEquals("07054", response2.getMobile());
    }

    @Test
    void testThatAcontactCanBeRetrievedByPhoneNumber() {
        //        given
        AddContactRequestDto contactToBeAdded = new AddContactRequestDto();
        contactToBeAdded.setFirstName("Deji");
        contactToBeAdded.setLastName("Dee");
        contactToBeAdded.setMobile("070");
        contactService.save(contactToBeAdded);
        //        given
        AddContactRequestDto contactToBeAdded2 = new AddContactRequestDto();
        contactToBeAdded2.setFirstName("Lota");
        contactToBeAdded2.setLastName("Onwuka");
        contactToBeAdded2.setMobile("07054");

        contactService.save(contactToBeAdded2);

        AddContactResponseDto response2 = contactService.search(contactToBeAdded2.getMobile());

        assertEquals("Lota Onwuka", response2.getFullName());
        assertEquals("07054", response2.getMobile());
    }

    @Test
    void testThatUnknownContact_ReturnsNotFoundException() {
        //        given
        AddContactRequestDto contactToBeAdded = new AddContactRequestDto();
        contactToBeAdded.setFirstName("Deji");
        contactToBeAdded.setLastName("Dee");
        contactToBeAdded.setMobile("070");
        contactService.save(contactToBeAdded);
        //        given
        AddContactRequestDto contactToBeAdded2 = new AddContactRequestDto();
        contactToBeAdded2.setFirstName("Lota");
        contactToBeAdded2.setLastName("Onwuka");
        contactToBeAdded2.setMobile("07054");

        contactService.save(contactToBeAdded2);

        assertThrows(ContactNotFoundException.class, ()-> contactService.search("fum"));
    }


//    @Test
//    void testThatContactCanBeUpdated() {
//        //        given
//        AddContactRequestDto contactToBeAdded = new AddContactRequestDto();
//        contactToBeAdded.setFirstName("Deji");
//        contactToBeAdded.setLastName("Dee");
//        contactToBeAdded.setMobile("070");
//        contactService.save(contactToBeAdded);
//        //        given
//        AddContactRequestDto contactToBeAdded2 = new AddContactRequestDto();
//        contactToBeAdded2.setFirstName("Lota");
//        contactToBeAdded2.setLastName("Onwuka");
//        contactToBeAdded2.setMobile("07054");
//
//        contactService.save(contactToBeAdded2);
//
//        UpdateContactRequest request = new UpdateContactRequest();
//        request.setFirstName("Deola");
//        request.setLastName("Oladeji");
//        request.setMobile("0904");
//        contactService.editContact(request, contactToBeAdded);
//
//        UpdateContactResponse response = new UpdateContactResponse();
//        assertEquals("Contact updated", response.getMessage());
//    }
}