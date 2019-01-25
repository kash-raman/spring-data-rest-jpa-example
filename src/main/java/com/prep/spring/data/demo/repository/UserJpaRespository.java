package com.prep.spring.data.demo.repository;

import com.prep.spring.data.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@Transactional(propagation = REQUIRED,isolation =Isolation.SERIALIZABLE,readOnly = true)
//@RepositoryDefinition(domainClass = Users.class,idClass = Long.class)
public interface UserJpaRespository extends JpaRepository<Users, Long> {//extends CrudRepository<Users,Long> {

    @Query("select u from Users u where u.name like %?1%")
    List<Users> findAllByUserName(String name);

    Users findByName(String name);
    Users findDistinctUserByFirstNameOrAge(String firstName,String age );
    Users getByFirstNameIgnoreCase(String firstName);
    Users readByFirstNameOrderByFirstNameAsc(String firstName);

}
