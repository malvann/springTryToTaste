package com.my.baeldung.service;

import com.my.baeldung.entity.Foo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FooService {
    private final Map<Long, Foo> fooMap = new HashMap<>();

    public List<Foo> findAll() {
        return new ArrayList<>(fooMap.values());
    }

    public Foo findById(Long id) {
        return fooMap.get(id);
    }

    public Long create(Foo resource) {
        long id = resource.getId();
        fooMap.putIfAbsent(id, resource);
        return id;
    }

    public Object getById(Long id) {
        return fooMap.get(id);
    }

    public void update(Foo resource) {
        fooMap.put(resource.getId(), resource);
    }

    public void deleteById(Long id) {
        fooMap.remove(id);
    }
}
