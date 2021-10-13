package com.service.core.model.dao;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {

    /**
     * Realiza el registro de un Entity
     *
     * @param entity Objecto Entity, debe enviarse como Entity.class
     */
    void persist(Object entity);

    /**
     * Realiza el registro de un array de objetos en la base de datos
     *
     * @param entities Array de objetos a registrar
     */
    void persist(Object[] entities);

    /**
     * Actualiza el Entity
     *
     * @param entity Objecto Entity, debe enviarse como Entity.class
     */
    void update(Object entity);

    /**
     * Elimina el registro del entity enviado
     *
     * @param entity Objecto Entity, debe enviarse como Entity.class
     */
    void delete(Object entity);

    /**
     * Elimina el registro del entity que coincida con el ID enviado
     *
     * @param entityClass debe enviarse como Entity.class
     * @param id          ID del registro a eliminar
     */
    void delete(Class entityClass, Serializable id);

    /**
     * Obtiene la lista de todos los registros para el entity enviado
     *
     * @param entityClass debe enviarse como Entity.class
     * @return Lista con los resultados del entity solicitado
     */
    List findAll(Class entityClass);

    /**
     * Obtiene el registro del Entity que coincida con el ID enviado
     *
     * @param entityClass debe enviarse como Entity.class
     * @param id          ID de registro que se quiere obtener
     * @return Objecto del Entity encontrado
     */
    Object get(Class entityClass, Serializable id);

    @Transactional(readOnly = true)
    List executeQueryListMapResult(String SQL);

    Object executeSigleResult(String SQL);

}