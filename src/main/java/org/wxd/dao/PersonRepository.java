package org.wxd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.wxd.domain.Person;

import java.util.List;

/**
 * Created by wxd on 16-9-13.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    public List<Person> findByAddress(String address);
    public Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name = :name and p.address = :address")
    public Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    // 在实体类Person中
    public Person withNameAndAddressNamedQuery(String name, String address);

}
