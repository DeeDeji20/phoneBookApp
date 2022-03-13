package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.exception.ContactExistsException;
import africa.semicolon.phoneBookTech.exception.ContactNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    private List<Contact> dataBase = new ArrayList<>();
    private int count;

    @Override
    public Contact addContact(Contact contact) {
        validateContact(contact);
        dataBase.add(contact);
        count++;
        return contact;
    }

    private void validateContact(Contact contact) {
        for (Contact contactInPhoneBook : dataBase) {
            if (contactInPhoneBook.equals(contact)||
                contactInPhoneBook.getMobile().equalsIgnoreCase(contact.getMobile())
            ) throw new ContactExistsException("Contact exists");
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void removeContact(Contact contact) {
//        Contact foundContact = findBy(contact.getFirstName());
        dataBase.remove(contact);
        count--;
    }

    @Override
    public List<Contact> findBy(String name) {
        List<Contact> contacts = new ArrayList<>();
        for (Contact contact : dataBase) {
            if (contact.getFirstName().equalsIgnoreCase(name)) contacts.add(contact);
        }
        if (contacts.isEmpty()) throw new ContactNotFoundException("Not found");
        return contacts;
    }

    @Override
    public Contact findContactBy(String mobile) {
        for (Contact contact : dataBase) {
            if (contact.getMobile().equalsIgnoreCase(mobile)) {
                return contact;
            }else throw new ContactNotFoundException("Contact Not Found");        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return dataBase;
    }
}
