package br.com.harisson.devdojotest.endpoint.repository;

import br.com.harisson.devdojotest.model.ApplicationUser;
import br.com.harisson.devdojotest.util.ApplicationUserCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("Transaction Repository Tests")
class ApplicationUserRepositoryTest {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Test
    @DisplayName("findByUsername returns application user when successful")
    void findByUsername_ReturnsApplicationUser_WhenSuccessful(){
        String expectedUsername = ApplicationUserCreator.createValidApplicationUser().getUsername();

        ApplicationUser applicationUser = applicationUserRepository.findByUsername(expectedUsername);

        Assertions.assertThat(applicationUser).isNotNull();

        Assertions.assertThat(applicationUser.getUsername()).isEqualTo(expectedUsername);
    }
}
