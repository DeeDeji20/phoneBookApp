package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contact;

import java.util.List;

public interface ContactRepository {
    Contact addContact(Contact contact);
    int count();

    void removeContact(Contact contact);

    List<Contact> findBy(String name);

    List<Contact> findAll();

}
