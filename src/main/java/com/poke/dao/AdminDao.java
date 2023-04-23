package com.poke.dao;

import com.poke.domain.Admin;
//import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends CrudRepository<Admin, Long> {


}
