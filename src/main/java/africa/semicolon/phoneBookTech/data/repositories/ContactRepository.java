package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String> {
//    Contact addContact(Contact contact);
//    int count();
//
//    void removeContact(Contact contact);
//
//    List<Contact> findBy(String name);
//
//    List<Contact> findAll();

List<Contact> findByMobile(String mobile);

}
