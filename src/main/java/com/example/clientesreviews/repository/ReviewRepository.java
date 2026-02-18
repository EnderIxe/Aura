package com.example.clientesreviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.clientesreviews.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
