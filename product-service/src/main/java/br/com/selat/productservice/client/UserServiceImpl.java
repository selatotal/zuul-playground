package br.com.selat.productservice.client;

import br.com.selat.productservice.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "defaultUser")
    public User findById(Long id) {
        return restTemplate.getForObject("http://USER-SERVICE/user/{id}", User.class, id);
    }

    private User defaultUser(Long id){
        return new User();
    }
}
