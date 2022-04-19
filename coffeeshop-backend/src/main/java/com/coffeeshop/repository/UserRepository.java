package com.coffeeshop.repository;

import com.coffeeshop.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

//    @Query("MATCH (u:USER)-[r:RATED_BY]->(s:SHOP) RETURN u")
    @Query("MATCH (u:USER) RETURN u")
    Collection<User> getAllUsers();

    //Collection<User> findAll();

    //@Query("MATCH (u:USER)-[r:RATED_BY]->(s:SHOP) WHERE ID(u) = $id RETURN u, collect(r), collect(s)")
    @Query("MATCH (u:USER) WHERE ID(u)=$id RETURN u")
    User findUserById(Long id);

    @Query("MATCH (u:USER) WHERE u.username=$username RETURN u")
    User findUserByUsername(String username);

//    @Query("CREATE (:USER {name: $user.name, surname: $user.surname, username: $user.username, password: $user.password})")
//    void addUser(User user);

    @Query("MATCH (u:USER) WHERE ID(u) = $id DETACH DELETE u")
    void deleteUser(Long id);

    @Query("MATCH (u:USER) WHERE u.username=$username AND u.password=$password RETURN ID(u)")
    long login(String username, String password);

    @Query("MATCH (u:USER) WHERE ID(u) = $id SET u.name = $name, u.surname = $surname")
    void updateUser(Long id, String name, String surname);
}
