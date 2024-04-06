package org.example.main.repository;

import org.example.main.entity.BaseEntity;
import org.example.main.exception.IdNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class AbstractRepository <T extends BaseEntity>{
    protected List<T> objects = new ArrayList<>();

    public T findById(long id)
    {
        return objects.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IdNotFoundException(id));
    }

    public List<T> findAll()
    {
        return objects;
    }

    public void save(T object){
        if(findObjectIndex(object)!= -1 && !objects.isEmpty())
        {
            objects.set(findObjectIndex(object),object);
        }
        else
        {
            if(objects.isEmpty())
                object.setId(1);
            else
                object.setId(objects.get(objects.size()-1).getId()+1);
        }
        objects.add(object);

    }

    private int findObjectIndex(T object)
    {
        for(int i = 0;i < objects.size();i++)
        {
            if(object.getId() == objects.get(i).getId()){
                return i;
            }

        }
        return -1;
    }
    public void deleteById(long id)
    {
        objects.remove(findById(id));
    }
}
