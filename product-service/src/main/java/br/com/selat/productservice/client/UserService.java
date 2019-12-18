package br.com.selat.productservice.client;

import br.com.selat.productservice.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);

}
