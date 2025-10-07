package com.example.hotelbooking.repository;

import java.util.*;

public class BaseRepository<T> {
    private final Map<String, T> store = new HashMap<>();

    public T save(String id, T entity) {
        store.put(id, entity);
        return entity;
    }

    public Optional<T> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    public void deleteById(String id) {
        store.remove(id);
    }
}
