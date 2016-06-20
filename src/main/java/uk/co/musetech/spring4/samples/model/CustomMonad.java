package uk.co.musetech.spring4.samples.model;

import java.util.function.Function;

public class CustomMonad<T> {

    private T object;

    public CustomMonad(T object) {
        this.object = object;
    }

    public T get() {
        return object;
    }

    public<U> CustomMonad<U> map(Function<T, ? extends U> f) {
        //return new CustomMonad(f.apply(get()));
        return flatMap(x -> new CustomMonad(f.apply(x)));
    }

    public<K> CustomMonad<K> flatMap(Function<T, CustomMonad<K>> f) {
        return f.apply(doSomething(get()));
    }

    private T doSomething(T t){
        System.out.println(String.format("Hello %s", t.toString()));
        return t;
    }
}
