package com.fmdemo.friendssuggestion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FriendsSuggestionApplicationTests {

	@Test
	void contextLoads() {
		assertEquals(10, Math.subtractExact(20, 10));
	}

}
