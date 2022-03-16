package africa.semicolon.phoneBookTech.data.repositories;

import africa.semicolon.phoneBookTech.data.models.Contact;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

;

@DataMongoTest
public class ContactRepositoryTest {

        @Autowired
        private africa.semicolon.phoneBookTech.data.repositories.ContactRepository repository;

        @Test
        public void saveContactTest(){
                Contact contact = new Contact("Dee", "Deji", "090");
                Contact saveContact = repository.save(contact);
                assertNotNull(saveContact.getId());
                assertEquals(1, repository.count());
                assertThat(saveContact.getId(), is(notNullValue()));
                assertThat(repository.count(), is(1L));
        }



    }

