package com.sagemcom.msarticle.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class ServiceGeneric <T,ID> implements IServiceGeneric <T,ID>{
    @Autowired
    private JpaRepository<T,ID> jpaRepository;
    @Override
    public T save(T entity) {return jpaRepository.save(entity); }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public T getId(ID id) {
        return jpaRepository.findById(id).orElse(null);
    }

    @Override
    public T update(ID id, Map<Object, Object> fields) {
        T entity= jpaRepository.findById(id).orElse(null);
        Assert.notNull(entity, "object not found with this ID :"+id);

        fields.forEach((key, value) ->{
            Field field= ReflectionUtils.findField((Class<T>) entity.getClass(), (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,entity,value);
        });
        return jpaRepository.save(entity);
    }


    @Override
    public void delete(ID id) {
        jpaRepository.deleteById(id);
    }


}
