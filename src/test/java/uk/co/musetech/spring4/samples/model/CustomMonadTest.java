package uk.co.musetech.spring4.samples.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomMonadTest {

    @Test
    public void testMap() throws Exception {
        String input = "first custom monad";
        CustomMonad<String> monad = new CustomMonad<>(input);
        CustomMonad<Integer> output = monad.map(s -> s.length());
        assertThat(output.get(), is(input.length()));
    }

    @Test
    public void testFlatMap() throws Exception {
        String input = "second custom monad";
        CustomMonad<String> monad = new CustomMonad<>(input);
        CustomMonad<Integer> output = monad.flatMap(s -> new CustomMonad<>(s.length()));
        assertThat(output.get(), is(input.length()));
    }
}