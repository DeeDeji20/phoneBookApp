package africa.semicolon.phoneBookTech.services;

import africa.semicolon.phoneBookTech.dtos.request.AddContactRequestDto;
import africa.semicolon.phoneBookTech.dtos.response.AddContactResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddContactServiceImplTest {

    AddContactService contactService;
    @BeforeEach
    void setUp(){
        contactService = new AddContactServiceImpl();
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
    void testThatCorrectResponseIsGottenBacked() {
        //        given
        AddContactRequestDto contactToBeAdded = new AddContactRequestDto();
        contactToBeAdded.setFirstName("Deji");
        contactToBeAdded.setLastName("Dee");
        contactToBeAdded.setMobile("070");
//        when
       AddContactResponseDto response = contactService.save(contactToBeAdded);
        assertEquals(1, contactService.getDataBase().count());
        System.out.println(response.getFirstName());
        assertNotNull(response);
       assertEquals("Deji", response.getFirstName());
       assertEquals("Dee", response.getLastName());
       assertEquals("070", response.getMobile());

    }
}