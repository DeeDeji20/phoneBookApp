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



}