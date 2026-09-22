package org.example.reviewservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    Optional<List<ReviewEntity>> findByCustomerId(Long customerId);
    Optional<List<ReviewEntity>> findByRoomId(Long roomId);
}
