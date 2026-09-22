package org.example.reviewservice;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponseDTO>> getReviews() {
        return ResponseEntity.ok(reviewService.findAll());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByCustomerId(@PathVariable long customerId) {
        return ResponseEntity.ok(reviewService.findByCustomerId(customerId));
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByRoomId(@PathVariable long roomId) {
        return ResponseEntity.ok(reviewService.findByRoomId(roomId));
    }

    @PostMapping()
    public ResponseEntity<ReviewResponseDTO> createReview(@Valid @RequestBody ReviewCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.create(dto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ReviewResponseDTO> updateReview(@PathVariable long id, @Valid @RequestBody ReviewCreateDTO dto) {
        return ResponseEntity.ok().body(reviewService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable long id) {
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
