package com.gft.repositories;

import java.lang.reflect.Array;

public interface IRepository<T extends Entity> {
    Iterable<T> Items();

    void Add(T instance);

    T GetById(long id);
}
