package com.zjh.tomato.service;

import java.util.List;

/**
 * @author zjh on  2019/10/10
 */
public interface BaseService<T> {
    /**
     *
     * @return
     */
    public List<T> getAll();


    public void add(T t);

    public void update(T t);

    public void delete(Long id);
}
