package com.gft.repositories;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class InMemoryRepository<T extends Entity> implements IRepository<T> {
    private List<T> items = new ArrayList<>();

    @Override
    public Iterable<T> Items() {
        return items;
    }

    @Override
    public void Add(T instance)
    {
        instance.setId(items.size()+1);
        items.add(instance);
    }

    @Override
    public T GetById(long id)
    {
        T toReturn = null;
        for (T c : items) {
            if (c.getId() == id)
                toReturn = c;
        }
        return toReturn;
    }

}
