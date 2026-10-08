package com.web.model;

import java.util.UUID;

public record GameResponse(UUID id,
                           int[][] field) {
}
