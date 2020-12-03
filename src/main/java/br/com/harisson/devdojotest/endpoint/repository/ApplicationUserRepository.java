package br.com.harisson.devdojotest.endpoint.repository;

import br.com.harisson.devdojotest.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{
    ApplicationUser findByUsername(String username);
}
