package com.esc.message;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface TextMessageRepository extends CrudRepository<TextMessage, Long> {
//    @Query("select t from TextMessage t WHERE t.date = :todaysDate")
//    public List<TextMessage> findAllWithCurrentDate(@Param("todaysDate") Date todaysDate);
}
