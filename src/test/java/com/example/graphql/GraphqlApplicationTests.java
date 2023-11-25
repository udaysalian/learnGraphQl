package com.example.graphql;

import com.example.graphql.domain.Actor;
import com.example.graphql.web.ActorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GraphqlApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private ActorController actorController;

	@Test
	void queryActorById() {
		Actor actor = actorController.getActorById(1L);
		assert actor.name().equals("firstActor");
	}
}
