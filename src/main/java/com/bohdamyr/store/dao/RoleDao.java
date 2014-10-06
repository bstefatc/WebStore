package com.bohdamyr.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bohdamyr.store.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}

