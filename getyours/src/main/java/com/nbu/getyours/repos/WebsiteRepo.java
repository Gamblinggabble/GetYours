package com.nbu.getyours.repos;

import com.nbu.getyours.models.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WebsiteRepo extends JpaRepository<Website, String> {
    Optional<Website> findByName(String name);
}
