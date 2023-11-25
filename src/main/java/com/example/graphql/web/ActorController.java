package com.example.graphql.web;

import com.example.graphql.domain.Actor;
import com.example.graphql.repository.ActorRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ActorController {

    private ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    @QueryMapping(name = "actorById")
    public Actor getActorById(@Argument Long Id) {
        return actorRepository.getById(Id);
    }
}
