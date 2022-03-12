package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contacts;

public interface ContactRepository {
    Contacts addContact(Contacts contact);
    int count();

    void removeContact(Contacts contact);

    Contacts findBy(String name);

}
