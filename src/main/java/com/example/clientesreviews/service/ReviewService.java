package com.example.clientesreviews.service;

import com.example.clientesreviews.model.Review;
import com.example.clientesreviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    public List<Review> listarTodas() {
        return repository.findAll();
    }

    public Review guardar(Review review) {
        return repository.save(review);
    }
    
    public Optional<Review> obtenerPorId(Long id) {
        return repository.findById(id);
    }
}