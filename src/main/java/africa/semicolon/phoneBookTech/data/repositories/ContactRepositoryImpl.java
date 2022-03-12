package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contact;
import africa.semicolon.phoneBookTech.exception.ContactExistsException;

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
        Contact foundContact = findBy(contact.getFirstName());
        dataBase.remove(foundContact);
        count--;
    }

    @Override
    public Contact findBy(String name) {
        for (Contact contact : dataBase) {
            if (contact.getFirstName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
}
