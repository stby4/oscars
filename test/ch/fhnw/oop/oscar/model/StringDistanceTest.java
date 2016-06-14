package ch.fhnw.oop.oscar.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * String Distance Test
 * Created by hinri on 14.06.2016.
 */
public class StringDistanceTest {
    @Test
    public void distance() throws Exception {
        assertEquals(8., StringDistance.distance("Hinrich", "Kaestner"), 0);
        assertEquals(0., StringDistance.distance("Hinrich", "Hinrich"), 0);
    }

    @Test
    public void similarity() throws Exception {
        assertEquals(0., StringDistance.similarity("Hinrich", "Kaestner"), 0);
        assertEquals(1., StringDistance.similarity("Kaestner", "kaestner"), 0);
    }

}