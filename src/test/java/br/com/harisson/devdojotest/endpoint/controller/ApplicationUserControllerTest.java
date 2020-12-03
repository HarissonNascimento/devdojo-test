package br.com.harisson.devdojotest.endpoint.controller;

import br.com.harisson.devdojotest.endpoint.service.ApplicationUserService;
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

@ExtendWith(SpringExtension.class)
class ApplicationUserControllerTest {
    @InjectMocks
    private ApplicationUserController applicationUserController;

    @Mock
    private ApplicationUserService applicationUserServiceMock;

    @BeforeEach
    public void setUp(){
        BDDMockito.when(applicationUserServiceMock.listAllApplicationUsers())
                .thenReturn(ApplicationUserCreator.createValidListApplicationUser());
    }

    @Test
    @DisplayName("listAllApplicationUsers returns list of application users when successful")
    void listAllAplicationUsers_ReturnsListOfApplicationUser_WhenSuccessful(){
        Long expectedAccountId = ApplicationUserCreator.createValidApplicationUser().getAccountId();

        List<ApplicationUser> applicationUserList = applicationUserController.listAllAplicationUsers().getBody();

        Assertions.assertThat(applicationUserList).isNotEmpty();

        Assertions.assertThat(applicationUserList.get(0).getAccountId()).isEqualTo(expectedAccountId);

    }
}
