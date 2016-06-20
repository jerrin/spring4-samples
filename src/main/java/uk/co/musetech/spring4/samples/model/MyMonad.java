package uk.co.musetech.spring4.samples.model;

import java.util.function.Function;

public class MyMonad<T> {

    private T object;

    public MyMonad(T object) {
        this.object = object;
    }

    public T get() {
        return object;
    }

    public<U> MyMonad<U> map(Function<T, ? extends U> f) {
        return new MyMonad(f.apply(doSomething(get())));
    }

    public<S> MyMonad<S> flatMap(Function<T, MyMonad<S>> f) {
        return flatten(map(f));
    }

    private<V> MyMonad<V> flatten(MyMonad<MyMonad<V>> input){
        return input.get();
    }

    private T doSomething(T t){
        System.out.println(String.format("Hello %s", t.toString()));
        return t;
    }
}
