package com.esc.message;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TextMessageRepository extends CrudRepository<TextMessage, Long> {
    @Query("select t from TextMessage t WHERE t.date = :currentDate")
    List<TextMessage> findAllWithCurrentDate(
            @Param("currentDate") Date currentDate);
}
