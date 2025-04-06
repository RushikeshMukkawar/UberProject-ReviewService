package com.example.UberReviewService.services;

import com.example.UberReviewService.Repositories.ReviewRepository;
import com.example.UberReviewService.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("************************************");
        Review r = Review.builder().content("XYZ").rating(5.0).build();
        Review r2 = Review.builder().content("XYZ").rating(5.0).build();
        reviewRepository.save(r);
        reviewRepository.save(r2);

        List<Review> reviews = reviewRepository.findAll();
        System.out.println("Below is the content of DB : ");
        for(Review review : reviews){
            System.out.println(review.getContent());
        }

        System.out.println("Deleting 1st id record : ");
        reviewRepository.deleteById(1L);
    }
}


