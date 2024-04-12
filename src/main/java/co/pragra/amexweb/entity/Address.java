package co.pragra.amexweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
    private int id;
    private int streetNo;
    private String streetName;
    private String city;
    private String postCode;
    private AddressTypeEnum type;
}
