package com.example.graphql.web;

import com.example.graphql.domain.Actor;
import com.example.graphql.repository.ActorRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ActorController {

    private ActorRepository actorRepository;

    @QueryMapping(name = "actors")
    public List<Actor> getAllActors(){
        return actorRepository.getActorList();
    }
    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    @QueryMapping(name = "actorById")
    public Actor getActorById(@Argument Long Id) {
        return actorRepository.getById(Id);
    }
}
