package com.eazybytes.eazyschool.repository;
import com.eazybytes.eazyschool.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer> {


    List<Contact> findByStatus(String status);


    /*
       first I need a JDBCTemplate instance to help me to do operations on my DB
       data source
       then use that to create a new JDBC instance
       with spring we don't have to do this
     */
    /*
    JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public int saveContactMsgToDB(Contact contact){
        String query="INSERT INTO CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS,CREATED_AT,CREATED_BY) VALUES(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(query.toLowerCase(),contact.getName(),contact.getMobileNum(),
                contact.getEmail(),contact.getSubject(),contact.getMessage(),
                contact.getStatus(),contact.getCreatedAt(),contact.getCreatedBy());
    }

    public List<Contact> getContactList(String status){
        String query = "SELECT * FROM CONTACT_MSG WHERE STATUS = ?";

        return jdbcTemplate.query(query.toLowerCase(), new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status);
            }
        }, new ContactRowMapper());
    }

    public int updateStatus(int contactId,String status,String updatedBy){

        String query = "UPDATE CONTACT_MSG SET STATUS=? , UPDATED_BY=? , UPDATED_AT=? WHERE CONTACT_ID = ?";

        return jdbcTemplate.update(query.toLowerCase(),new PreparedStatementSetter(){

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status);
                ps.setString(2, updatedBy);
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(4, contactId);
            }
        });

    }
    */

}
