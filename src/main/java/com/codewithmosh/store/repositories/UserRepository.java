package com.codewithmosh.store.repositories;

import com.codewithmosh.store.dtos.UserSummary;
import com.codewithmosh.store.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    @EntityGraph(attributePaths = {"tags", "addresses"})
//    Optional<User> findByEmail(String email);
//
//    @EntityGraph(attributePaths = "addresses")
//    @Query("select u from User u")
//    List<User> findAllWithTags();
//
//    @Query("select u.id as id, u.email as email from User u where u.profile.loyaltyPoints > :loyaltyPoints order by u.email")
//    List<UserSummary> findLoyalUsers(@Param("loyaltyPoints") int loyaltyPoints);
}
