package com.sagemcom.msarticle.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


public class RestControllerGeneric <T , ID> {
    @Autowired
    private IServiceGeneric<T, ID> iServiceGeneric;

    @PostMapping
    public T save(@RequestBody T entity){
        return iServiceGeneric.save(entity);
    }
    @GetMapping
    public List<T> getAll(){
        return iServiceGeneric.findAll();
    }
    @GetMapping("/{id}")
    public T getId(@PathVariable ID id){
        return iServiceGeneric.getId(id);
    }
    @PatchMapping("/{id}")
    public T  update(@PathVariable ID id, @RequestBody Map<Object,Object> fields){
        return iServiceGeneric.update(id, fields);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id){
        iServiceGeneric.delete(id);
    }


}
