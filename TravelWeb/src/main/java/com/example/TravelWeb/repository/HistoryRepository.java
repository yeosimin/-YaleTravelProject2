package com.example.TravelWeb.repository;

import com.example.TravelWeb.entity.History;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoryRepository extends JpaRepository<History,Long> {

    Optional<List<History>> findAllByUserId(Long userId);

}
