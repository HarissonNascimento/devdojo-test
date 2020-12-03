package br.com.harisson.devdojotest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @NotNull(message = "The field 'username' is mandatory")
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull(message = "The field 'password' is mandatory")
    @Column(nullable = false)
    @ToString.Exclude
    private String password;

    @NotNull(message = "The field 'role' is mandatory")
    @Column(nullable = false)
    @Builder.Default
    private String role = "USER";

    @NotNull(message = "The field 'userKey' is mandatory")
    @Column(nullable = false)
    private String userKey;

    public ApplicationUser(@NotNull ApplicationUser applicationUser) {
        this.accountId = applicationUser.getAccountId();
        this.username = applicationUser.getUsername();
        this.password = applicationUser.getPassword();
        this.role = applicationUser.getRole();
        this.userKey = applicationUser.getUserKey();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return commaSeparatedStringToAuthorityList("ROLE_" + this.getRole());
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
