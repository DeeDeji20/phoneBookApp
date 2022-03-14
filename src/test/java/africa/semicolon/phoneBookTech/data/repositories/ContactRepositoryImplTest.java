package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.exception.ContactExistsException;
import africa.semicolon.phoneBookTech.exception.ContactNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    ContactRepository contactRepository;
    @BeforeEach
    void setUp(){
        contactRepository = new ContactRepositoryImpl();
    }
    @Test
    void testThatContactCanBeAddedToRepository() {
        //given
        Contact contact = new Contact("Dee", "Deji", "07031054664");
        contactRepository.addContact(contact);
        assertEquals(1, contactRepository.count());
    }

//    @Test
//    void testThatAddingDuplicateContact_ThrowsException() {
//        //given
//        Contact contact = new Contact("Dee", "Deji", "07031054664");
//        contactRepository.addContact(contact);
//        Contact contact2 = new Contact("Dee", "Deji", "07031054664");
//
//        assertThrows(ContactExistsException.class, ()-> contactRepository.addContact(contact2));
//    }

//    @Test
//    void testThatAddingDuplicateNumber_ThrowsException() {
//        //given
//        Contact contact = new Contact("Dee", "Deji", "07031054664");
//        contactRepository.addContact(contact);
//        Contact contact2 = new Contact("Dee", "Deo", "07031054664");
//
//        assertThrows(ContactExistsException.class, ()-> contactRepository.addContact(contact2));
//
//    }

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
    void testThatWeCanFindContactsByFirstName(){
        //given
        Contact contact1 = new Contact("Dee", "Deji", "07031054664");
        Contact contact2 = new Contact("Dee", "fum", "07031096634");
        //when
        contactRepository.addContact(contact1);
        contactRepository.addContact(contact2);
        List<Contact> foundContacts = contactRepository.findBy("Dee");
        //assert
        assertEquals(2,foundContacts.size());
    }

    @Test
    void testThatWeCanFindOneContactByFirstName(){
        //given
        Contact contact1 = new Contact("Dee", "Deji", "07031054664");
        Contact contact2 = new Contact("Deji", "fum", "07031096634");
        //when
        contactRepository.addContact(contact1);
        contactRepository.addContact(contact2);
        List<Contact> foundContacts = contactRepository.findBy("Dee");
        //assert
        assertEquals(1,foundContacts.size());
    }

    @Test
    void testThatWeCanFindOneContactByLastName(){
        //given
        Contact contact1 = new Contact("Dee", "Deji", "07031054664");
        Contact contact2 = new Contact("Deji", "fum", "07031096634");
        //when
        contactRepository.addContact(contact1);
        contactRepository.addContact(contact2);
        List<Contact> foundContacts = contactRepository.findBy("fum");
        //assert
        assertEquals(1,foundContacts.size());
    }

    @Test
    void testThatIfTwoContacts_WithSameNameExist_WeCanFindContactsByFirstName(){
        //given
        Contact contact1 = new Contact("Dee", "Deji", "07031054664");
        Contact contact2 = new Contact("Dee", "fum", "07031096634");
        //when
        contactRepository.addContact(contact1);
        contactRepository.addContact(contact2);
        List<Contact> foundContacts = contactRepository.findBy("Dee");
        //assert
        assertEquals(2,foundContacts.size());
    }

    @Test
    void testThatWeCanFindContactByMobile(){
        //given
        Contact contact1 = new Contact("Dee", "Deji", "07031054664");
        //when
        contactRepository.addContact(contact1);

        List<Contact>foundContact = contactRepository.findBy("07031054664");
        assertEquals(1,foundContact.size());
    }

    @Test
    void testThatIfContactAlreadyExists_ThrowsException(){
        //given
        Contact contact1 = new Contact("Dee", "Deji", "07031054664");
        //when
        contactRepository.addContact(contact1);

        assertThrows(ContactNotFoundException.class, ()-> contactRepository.findBy("Lota"));
    }

    @Test
    void testThatAllContactsCanBeGotten() {
        //given
        Contact contact1 = new Contact("Dee", "Deji", "07031054664");
        Contact contact2 = new Contact("Dee", "fum", "07031096634");
        //when
        contactRepository.addContact(contact1);
        contactRepository.addContact(contact2);
//
        List<Contact> all = contactRepository.findAll();
        assertEquals(2, all.size());
    }



//    @Test
//    void testUpdateContact(){
//        //given
//        Contact contact1 = new Contact("Dee", "Deji", "07031054664");
//        Contact contact2 = new Contact("Dee", "fum", "07031096634");
//        contactRepository.addContact(contact1);
//        contactRepository.addContact(contact2);
//
//        contactRepository.updateContact(contact1);
////        Contact[] found = Arrays.stream(new Contact[]{"Sophie", ""}).toArray()
//        assertEquals(contact1, contactRepository.findBy("Sophie"));
//    }
}