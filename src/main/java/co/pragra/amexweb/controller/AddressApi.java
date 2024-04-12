package co.pragra.amexweb.controller;

import co.pragra.amexweb.dao.AddressDAO;
import co.pragra.amexweb.entity.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressApi {
    private AddressDAO addressDAO;

    public AddressApi(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @GetMapping("/runddl")
    public boolean execute(){
       // addressDAO.createTable();
        return true;
    }

    @PostMapping("/api/address")
    public Address create(@RequestBody Address address){
        return addressDAO.createAddress(address);
    }

    @GetMapping("/api/address")
    public List<Address> getall(){
        return addressDAO.getAll();
    }
}
