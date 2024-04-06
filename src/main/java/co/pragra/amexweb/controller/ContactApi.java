package co.pragra.amexweb.controller;

import co.pragra.amexweb.dao.ContactDao;
import co.pragra.amexweb.entity.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactApi {
    private ContactDao dao;

    public ContactApi(ContactDao dao) {
        this.dao = dao;
    }

    @GetMapping("/contact")
    public List<Contact> getAll(){
        return dao.getContacts();
    }

    @PostMapping("/contact")
    public Contact createNew(@RequestBody  Contact contact) {
        return dao.insert(contact);
    }

    @PutMapping("/contact")
    public Contact update(@RequestBody  Contact contact) {
        return dao.update(contact);
    }
}
