package com.universita.corsica.nomadaccomodationfinder.repository;

import java.util.List;

public interface CRUD<K,V> {

    List<V> findAll();

    V findById(K id);

    V saveOrUpdate(V entity);

    V deleteById(K entity);

}
