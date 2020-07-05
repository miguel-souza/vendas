package io.github.yasminsouza.repository;

import io.github.yasminsouza.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = " select * from client c where c.name like '%:name%' ", nativeQuery = true)
    List<Client> findByName(@Param("name") String name);

    @Query(" delete from Client c where c.name =:name ")
    @Modifying
    void deleteByName(@Param("name") String name);

    boolean existsByName(String nome);

    @Query(" select c from Client c left join fetch c.requests where c.id = :id  ")
    Client findClientFetchRequests(@Param("id") Integer id);
}
