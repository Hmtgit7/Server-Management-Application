package com.sparkdevelopie.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparkdevelopie.server.Model.Server;

public interface ServerRepo extends JpaRepository<Server,Long> {
    Server findByIpAddress(String ipAddress);  
}
