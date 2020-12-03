package br.com.harisson.devdojotest.endpoint.service;

import br.com.harisson.devdojotest.endpoint.repository.ApplicationUserRepository;
import br.com.harisson.devdojotest.model.ApplicationUser;
import br.com.harisson.devdojotest.util.ApplicationUserCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
class ApplicationUserServiceTest {
    @InjectMocks
    private ApplicationUserService applicationUserService;

    @Mock
    private ApplicationUserRepository applicationUserRepositoryMock;

    @BeforeEach
    public void setUp(){
        BDDMockito.when(applicationUserRepositoryMock.findByUsername(anyString()))
                .thenReturn(ApplicationUserCreator.createValidApplicationUser());

        BDDMockito.when(applicationUserRepositoryMock.findAll())
                .thenReturn(ApplicationUserCreator.createValidListApplicationUser());
    }

    @Test
    @DisplayName("saveList returns void when successful")
    void saveList_ReturnsVoid_WhenSuccessful() {
        List<ApplicationUser> list = ApplicationUserCreator.createValidListApplicationUser();

        Assertions.assertThatCode(() -> applicationUserService.saveApplicationUserList(list))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("listAllApplicationUsers returns list of application users when successful")
    void listAllApplicationUsers_ReturnsListOfApplicationsUsers_WhenSuccessful(){
        Long expectedAccountId = ApplicationUserCreator.createValidApplicationUser().getAccountId();

        List<ApplicationUser> applicationUserList = applicationUserService.listAllApplicationUsers();

        Assertions.assertThat(applicationUserList).isNotEmpty();

        Assertions.assertThat(applicationUserList.get(0).getAccountId()).isEqualTo(expectedAccountId);
    }

    @Test
    @DisplayName("findByUsername returns application user when successful")
    void findByUsername_ReturnsApplicationUser_WhenSuccessful(){
        String expectedUsername = ApplicationUserCreator.createValidApplicationUser().getUsername();

        ApplicationUser applicationUser = (ApplicationUser) applicationUserService.loadUserByUsername(expectedUsername);

        Assertions.assertThat(applicationUser).isNotNull();

        Assertions.assertThat(applicationUser.getUsername()).isEqualTo(expectedUsername);

    }
}
