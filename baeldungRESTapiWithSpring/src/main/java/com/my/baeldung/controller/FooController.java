package com.my.baeldung.controller;

import com.my.baeldung.entity.Foo;
import com.my.baeldung.exception.NullableRequest;
import com.my.baeldung.exception.SourceNotFoundException;
import com.my.baeldung.precondition.Preconditions;
import com.my.baeldung.precondition.RestPreconditions;
import com.my.baeldung.service.FooService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/foo")
public class FooController {
    private FooService fooService;

    @GetMapping
    public List<Foo> findAll() {
        return fooService.findAll();
    }
    @GetMapping(value = "/{id}")
    public Foo findById(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(fooService.findById(id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Foo resource) {
        Preconditions.checkNotNull(resource);
        return fooService.create(resource);
    }
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody Foo resource) {
        Preconditions.checkNotNull(resource);
        RestPreconditions.checkNotNull(id);
        fooService.update(resource);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        fooService.deleteById(id);
    }
//
//    @ExceptionHandler({NullableRequest.class, SourceNotFoundException.class})
//    public List<Foo> handleException(){
//        return this.findAll();
//    }
}
