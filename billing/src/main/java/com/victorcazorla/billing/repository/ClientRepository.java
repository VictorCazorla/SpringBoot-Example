package com.victorcazorla.billing.repository;

import com.victorcazorla.billing.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
