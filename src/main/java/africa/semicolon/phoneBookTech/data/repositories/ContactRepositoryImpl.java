package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{
    private List<Contacts> dataBase = new ArrayList<>();
    private int count;

    @Override
    public Contacts addContact(Contacts contact) {
        dataBase.add(contact);
        count++;
        return contact;
    }

    @Override
    public int count() {
        return count;
    }
}
