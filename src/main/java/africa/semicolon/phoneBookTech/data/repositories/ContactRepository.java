package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contact;

public interface ContactRepository {
    Contact addContact(Contact contact);
    int count();

    void removeContact(Contact contact);

    Contact findBy(String name);

}
