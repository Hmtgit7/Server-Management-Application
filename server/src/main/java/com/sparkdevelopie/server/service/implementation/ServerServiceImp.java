package com.sparkdevelopie.server.service.implementation;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sparkdevelopie.server.Model.Server;
import com.sparkdevelopie.server.enumeration.Status;
import com.sparkdevelopie.server.repo.ServerRepo;
import com.sparkdevelopie.server.service.ServerService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImp implements ServerService{
    private final ServerRepo serverRepo;

    @Override
    public Server create(Server server){
        log.info("Saving New Server: {}", server.getName() );
        server.setImageUrl(setServerImageUrl());
        return serverRepo.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException{
        log.info("Pinging Server IP: {}",ipAddress);
        Server server=serverRepo.findByIpAddress(ipAddress);
        InetAddress address=InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(100000)?Status.SERVER_UP:Status.SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit){
        log.info("Fetching All Servers");
        return serverRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server get(Long id){
        log.info("Fetching Server By Id: {}",id);
        return serverRepo.findById(id).get();
    }

    @Override
    public Server update(Server server){
        log.info("Updating Server: {}", server.getName());
        return serverRepo.save(server);
    }

    @Override
    public Boolean delete(Long id){
        log.info("Deleting Server By Id: {}",id);
        serverRepo.deleteById(id);
        return true;
    }

    private String setServerImageUrl(){
        String[] imageNames={"server1.png","server2.png","server3.png","server4.png","server5.png"};
        
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}