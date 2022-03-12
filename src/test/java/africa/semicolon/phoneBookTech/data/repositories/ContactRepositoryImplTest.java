package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contacts;
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
        Contacts contact = new Contacts("Dee", "Deji", "07031054664");
        contactRepository.addContact(contact);
        assertEquals(1, contactRepository.count());
    }

    @Test
    void testThatContactCanBeDeleted(){
        //given
        Contacts contact1 = new Contacts("Dee", "Deji", "07031054664");
        //when
        contactRepository.addContact(contact1);
        //given
        Contacts contact2 = new Contacts("lota", "onwuka", "09023452145");
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
        Contacts contact1 = new Contacts("Dee", "Deji", "07031054664");
        //when
        contactRepository.addContact(contact1);

        Contacts foundContact = contactRepository.findBy("Dee");
        //assert
        assertEquals(contact1,foundContact);


    }



}