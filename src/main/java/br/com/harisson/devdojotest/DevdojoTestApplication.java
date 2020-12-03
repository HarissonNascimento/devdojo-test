package br.com.harisson.devdojotest;

import br.com.harisson.devdojotest.endpoint.service.ApplicationUserService;
import br.com.harisson.devdojotest.endpoint.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import static br.com.harisson.devdojotest.mapper.util.JsonMapperUtil.saveApplicationUserListWithJsonArchive;
import static br.com.harisson.devdojotest.mapper.util.JsonMapperUtil.saveTransactionListWithJsonArchive;

@SpringBootApplication
@ComponentScan({"br.com.harisson"})
public class DevdojoTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevdojoTestApplication.class, args);
    }

    @Bean
    CommandLineRunner runnerTransaction(TransactionService transactionService) {
        return args -> saveTransactionListWithJsonArchive(transactionService);
    }

    @Bean
    CommandLineRunner runnerApplicationUser(ApplicationUserService applicationUserService) {
        return args -> saveApplicationUserListWithJsonArchive(applicationUserService);
    }

}
