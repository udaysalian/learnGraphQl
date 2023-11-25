package com.example.graphql.repository;

import com.example.graphql.domain.Actor;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActorRepository {

    public List<Actor> getActorList() {
        return actorList;
    }

    private List<Actor> actorList;
    private MovieRepository movieRepository;
    public ActorRepository(MovieRepository movieRepository ) {
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    private void initializeMockActors(){
        actorList = new ArrayList<>();
        actorList.add(new Actor(1L,"firstActor","02-12-1966", List.of(movieRepository.getById(1L), movieRepository.getById(2L)) ));
        actorList.add(new Actor(2L,"SecondActor","10-12-1966", List.of(movieRepository.getById(3L), movieRepository.getById(4L)) ));

    }

    public Actor getById(Long Id) {
        Actor actor1 = actorList.stream().filter(actor -> actor.id().equals(Id)).findFirst().orElse(null);
        return actor1;
    }


}
