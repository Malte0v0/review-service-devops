package org.example.reviewservice.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Service
public class BookingClient {
    private final RestClient restClient;

    public BookingClient(@Value("${booking.service.url}") String apiURL) {
        this.restClient = RestClient.builder().baseUrl(apiURL).build();
    }

    public boolean bookingExists(long id) {
        try {
            this.restClient.get().uri("/api/bookings/{id}", id).retrieve().toBodilessEntity();
            return true;
        } catch (HttpClientErrorException.NotFound exception) {
            return false;
        }
    }

    public boolean roomExists(long id) {
        try {
            this.restClient.get().uri("/api/rooms/{id}", id).retrieve().toBodilessEntity();
            return true;
        } catch (HttpClientErrorException.NotFound exception) {
            return false;
        }
    }
}