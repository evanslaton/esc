package com.esc.message;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Component("textMessageRepo")
public interface TextMessageRepository extends CrudRepository<TextMessage, Long> {
    // good idea here! wish it had worked!
//    @Query("select t from TextMessage t WHERE t.date = :todaysDate")
//    public List<TextMessage> findAllWithCurrentDate(@Param("todaysDate") Date todaysDate);
}
