package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    ContactRepository contactRepository;
    @BeforeEach
    void setUp(){
        contactRepository = new ContactRepositoryImpl();
    }
    @Test
    void tetsThatContactCanBeAddedToRepository() {
        //given
        Contact contact = new Contact("Dee", "Deji", "07031054664");
        contactRepository.addContact(contact);
        assertEquals(1, contactRepository.count());
    }

    @Test
    void testThatContactCanBeDeleted(){
        //given
        Contact contact1 = new Contact("Dee", "Deji", "07031054664");
        //when
        contactRepository.addContact(contact1);
        //given
        Contact contact2 = new Contact("lota", "onwuka", "09023452145");
        //when
        contactRepository.addContact(contact2);
        //assert
        assertEquals(2,contactRepository.count());
        contactRepository.removeContact(contact2);
        assertEquals(1,contactRepository.count());
    }

    @Test
    void testThatWeCanFindContactByFirstName(){
        //given
        Contact contact1 = new Contact("Dee", "Deji", "07031054664");
        //when
        contactRepository.addContact(contact1);

        Contact foundContact = contactRepository.findBy("Dee");
        //assert
        assertEquals(contact1,foundContact);


    }



}