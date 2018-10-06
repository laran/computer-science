/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.dynamic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Hanoi")
public class HanoiTest {

	@Test
	public void shouldCalculateAuxTowerIndexProperly() {
		Hanoi hanoi = new Hanoi();
		assertThat(hanoi.getAuxTowerIndex(0, 1), is(equalTo(2)));
		assertThat(hanoi.getAuxTowerIndex(0, 2), is(equalTo(1)));
		assertThat(hanoi.getAuxTowerIndex(1, 2), is(equalTo(0)));
	}


}
