package com.example.graphql.domain;

import java.util.List;

public record Actor(Long id, String name, String birthDate, List<Movie> movies) {

}