package org.example.reviewservice;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewResponseDTO {
    @NotNull
    private Long id;

    @NotNull
    private long customerId;

    @NotNull
    private long roomId;

    @NotNull
    private String reviewText;

    @NotNull
    private LocalDate reviewDate;
}
