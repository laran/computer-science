/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs.algorithms;

import com.laranevans.cs.structures.graphs.Graph;
import com.laranevans.cs.structures.graphs.GraphNode;
import com.laranevans.cs.structures.graphs.GraphPrinter;
import com.laranevans.cs.structures.graphs.SampleGraphs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.laranevans.cs.Letters.*;
import static com.laranevans.cs.structures.graphs.algorithms.Prims.DISTANCE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("Prims")
public class PrimsTest {

	@Test
	public void shouldFindMSTOnLetters() {
		Graph mst = Prims.of(SampleGraphs.letters());
		GraphPrinter.print(mst);

		GraphNode a = mst.getNode(A);
		assertThat(a.getEdges().get(B), notNullValue());
		assertThat(a.getEdges().get(B).getProperties().get(DISTANCE), is(equalTo("5")));
		assertThat(a.getEdges().get(C), notNullValue());
		assertThat(a.getEdges().get(C).getProperties().get(DISTANCE), is(equalTo("1")));

		GraphNode b = mst.getNode(B);
		assertThat(b.getEdges().get(A), notNullValue());
		assertThat(b.getEdges().get(A).getProperties().get(DISTANCE), is(equalTo("5")));
		assertThat(b.getEdges().get(F), notNullValue());
		assertThat(b.getEdges().get(F).getProperties().get(DISTANCE), is(equalTo("6")));

		GraphNode c = mst.getNode(C);
		assertThat(c.getEdges().get(A), notNullValue());
		assertThat(c.getEdges().get(A).getProperties().get(DISTANCE), is(equalTo("1")));
		assertThat(c.getEdges().get(D), notNullValue());
		assertThat(c.getEdges().get(D).getProperties().get(DISTANCE), is(equalTo("3")));
		assertThat(c.getEdges().get(E), notNullValue());
		assertThat(c.getEdges().get(E).getProperties().get(DISTANCE), is(equalTo("2")));

		GraphNode d = mst.getNode(D);
		assertThat(d.getEdges().get(C), notNullValue());
		assertThat(d.getEdges().get(C).getProperties().get(DISTANCE), is(equalTo("3")));

		GraphNode e = mst.getNode(E);
		assertThat(e.getEdges().get(C), notNullValue());
		assertThat(e.getEdges().get(C).getProperties().get(DISTANCE), is(equalTo("2")));
		assertThat(e.getEdges().get(G), notNullValue());
		assertThat(e.getEdges().get(G).getProperties().get(DISTANCE), is(equalTo("9")));

		GraphNode f = mst.getNode(F);
		assertThat(f.getEdges().get(B), notNullValue());
		assertThat(f.getEdges().get(B).getProperties().get(DISTANCE), is(equalTo("6")));

		GraphNode g = mst.getNode(G);
		assertThat(g.getEdges().get(E), notNullValue());
		assertThat(g.getEdges().get(E).getProperties().get(DISTANCE), is(equalTo("9")));
	}

}
