package com.utn.progav2.persistence;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by pablo on 12/09/16.
 */
public abstract class AbstractDao<K> {

  protected SessionFactory sessionFactory;

  public AbstractDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  abstract List<K> getAll();
  abstract K getById(int id);
  abstract void save(K value);



}
