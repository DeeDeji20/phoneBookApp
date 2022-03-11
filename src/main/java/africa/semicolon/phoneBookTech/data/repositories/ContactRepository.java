package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contacts;

public interface ContactRepository {
    Contacts addContact(Contacts contact);
    int count();
}
