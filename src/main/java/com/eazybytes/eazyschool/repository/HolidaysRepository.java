package com.eazybytes.eazyschool.repository;

import com.eazybytes.eazyschool.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface HolidaysRepository extends ListCrudRepository<Holiday,String> {
    /*
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public HolidaysRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Holiday> getHolidayList(){

        String query = "SELECT * FROM holidays";

        var rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);

        return jdbcTemplate.query(query,rowMapper);

    }
     */
}
