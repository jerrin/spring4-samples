package uk.co.musetech.spring4.samples.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MyMonadTest {
    @Test
    public void testMap() throws Exception {
        String input = "first my monad";
        MyMonad<String> monad = new MyMonad<>(input);
        MyMonad<Integer> output = monad.map(s -> s.length());
        assertThat(output.get(), is(input.length()));
    }

    @Test
    public void testFlatMap() throws Exception {
        String input = "second my monad";
        MyMonad<String> monad = new MyMonad<>(input);
        MyMonad<Integer> output = monad.flatMap(s -> new MyMonad<>(s.length()));
        assertThat(output.get(), is(input.length()));
    }

}