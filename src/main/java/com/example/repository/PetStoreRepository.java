package com.example.repository;

import com.example.model.PetStoreModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PetStoreRepository {
    //use JdbcTemplate to access database

    @Autowired
    JdbcTemplate jdbcTemplate;

    //get data from sql
    abstract class PetRowMapper implements RowMapper<PetStoreModel> {
        //to over write based class method
        @Override
        public PetStoreModel mapRow(ResultSet resultSet, int rowNum) throws SQLException{
            PetStoreModel petStoreModel = new PetStoreModel();
            petStoreModel.setId(resultSet.getString("id"));
            petStoreModel.setPetName(resultSet.getString("pet_name"));
            petStoreModel.setPetAge(resultSet.getInt(3));
            petStoreModel.setPetGender(resultSet.getString("pet_gender"));
            petStoreModel.setPetSpecies(resultSet.getString("pet_species"));
            return petStoreModel;
        }
    }

    //GET
    public List<PetStoreModel> findAll(){
        //Get all data from table. Display according to class PetRowMapper.
        return jdbcTemplate.query("select * from tbl_pet_profile", new PetRowMapper(){});

    }

    //GET (By Id)
    public PetStoreModel getPet(String id) {
        //java exception (try...catch)
        //Try = errors while it is being executed.
        //Catch =  if an error occurs in the try block.
        try {
            return jdbcTemplate.queryForObject("select * from tbl_pet_profile where id = ?", new Object[]{
                    id}, new BeanPropertyRowMapper<>(PetStoreModel.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //DEL
    public void deleteById (String id){
        //Delete data when passing id.
        jdbcTemplate.update("delete from tbl_pet_profile where id=?", new Object[]{
                id
        });
    }

    //jdbcTemplate -> insert/update use same method = update()
    //POST
    public void insert(PetStoreModel pet){
        //Create new data in table with values
        jdbcTemplate.update("insert into tbl_pet_profile (id,pet_name,pet_age,pet_gender,pet_species) values (?,?,?,?,?)",
                new Object[]{ //get value from
                        pet.getId(),pet.getPetName(), pet.getPetAge(), pet.getPetGender(),
                        pet.getPetSpecies()
                });
    }

    //PUT -> it's update all records
    public void update (PetStoreModel pet){
        //Update to tbl_pet_profile according to column name.
        jdbcTemplate.update("update tbl_pet_profile set pet_name = ?, pet_age = ?, pet_gender = ?, pet_species = ?",
                new Object[]{ //get value from
                        pet.getPetName(), pet.getPetAge(), pet.getPetGender(),
                        pet.getPetSpecies()
                });

    }

}