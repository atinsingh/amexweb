package co.pragra.amexweb.dao;

import co.pragra.amexweb.entity.Contact;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactDao {
    private JdbcTemplate template;

    public ContactDao(JdbcTemplate template) {
        this.template = template;
    }
    // Inserting a contact
    public Contact insert(Contact contact){
        String sql = "INSERT INTO CONTACT VALUES ( ?,  ?, ?, ?, ?)";
        template.update(sql, contact.getId(),
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getPhone(),
                        contact.getEmail()
        );
        return contact;
    }
    //Updating contact
    public Contact update(Contact contact) {
        Contact queryContact = template.queryForObject("SELECT * FROM CONTACT WHERE ID = ? ", new BeanPropertyRowMapper<>(Contact.class), contact.getId());
        if(contact!=null) {
            String sql = "UPDATE CONTACT SET EMAIL = ? WHERE ID = ?";
            template.update(sql,contact.getEmail(), contact.getId());
        }
        return template.queryForObject("SELECT * FROM CONTACT WHERE ID = ? ", new BeanPropertyRowMapper<>(Contact.class), contact.getId());
    }
    // reading contacts
    // reading a contact
    public List<Contact> getContacts(){
        String sql = "SELECT * FROM CONTACT";
        return template.query(sql, new BeanPropertyRowMapper<>(Contact.class));
    }
    // delete a contact

}
