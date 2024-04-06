package co.pragra.amexweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
