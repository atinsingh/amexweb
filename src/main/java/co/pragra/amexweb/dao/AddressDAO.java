package co.pragra.amexweb.dao;

import co.pragra.amexweb.entity.Address;
import co.pragra.amexweb.entity.AddressTypeEnum;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AddressDAO {
    private NamedParameterJdbcTemplate template;

    public AddressDAO(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

//    public void createTable(){
//        String sql = "CREATE TABLE ADDRESS(ID INT PRIMARY KEY, HOUSE_NUMBER  INT,\n" +
//                      "STREET_NAME VARCHAR(255),  CITY_NAME VARCHAR(255),\n" +
//                      "ZIP_CODE VARCHAR(255), ADDRESS_TYPE INT )";
//
//        template.execute(sql, ps ->  true);
//    }

    public Address createAddress(Address address) {
        String sql = "INSERT  INTO  ADDRESS  VALUES (:id, :house,:streetName, :city, :zip, :type)";

        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource().addValue("id",address.getId())
                        .addValue("house", address.getStreetNo())
                        .addValue("streetName", address.getStreetName())
                        .addValue("city", address.getCity())
                        .addValue("zip", address.getPostCode())
                        .addValue("type", address.getType().ordinal());

        int update = template.update(sql, sqlParameterSource);
        if(update==-1){
            throw new RuntimeException("Nothing got inserted");
        }
        return address;
    }

    public List<Address> getAll(){
        String sql = "SELECT * FROM ADDRESS";
        return template.query(sql, (rs, rowNum) -> {
                Address address = new Address();
                address.setId(rs.getInt("ID"));
                address.setStreetNo(rs.getInt("HOUSE_NUMBER"));
                address.setStreetName(rs.getString("STREET_NAME"));
                address.setCity(rs.getString("CITY_NAME"));
                address.setPostCode(rs.getString("ZIP_CODE"));
                if(rs.getInt("ADDRESS_TYPE")==0){
                    address.setType(AddressTypeEnum.HOME);
                }
                if(rs.getInt("ADDRESS_TYPE")==1){
                address.setType(AddressTypeEnum.OFFICE);
                }
                return address;
        });
    }
}
