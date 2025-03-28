package org.example.premierleaguequiz.model.dto;

public record Player(
        long id,
        String name,
        String team,
        String position,
        String nationality,
        String imageUrl
) {}