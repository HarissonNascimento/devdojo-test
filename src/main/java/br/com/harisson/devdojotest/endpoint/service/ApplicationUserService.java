package br.com.harisson.devdojotest.endpoint.service;

import br.com.harisson.devdojotest.endpoint.repository.ApplicationUserRepository;
import br.com.harisson.devdojotest.model.ApplicationUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;

    public void saveApplicationUserList(List<ApplicationUser> applicationUsers) {
        applicationUserRepository.saveAll(applicationUsers);
    }

    public List<ApplicationUser> listAllApplicationUsers(){
        return applicationUserRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(applicationUserRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Application user '%s' not found", username)));
    }
}
