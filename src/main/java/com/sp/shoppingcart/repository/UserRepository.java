package com.sp.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.shoppingcart.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
