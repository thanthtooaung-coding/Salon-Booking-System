package com.org.salonBooking.common.service.impl;

import com.org.salonBooking.common.exception.EntityDeletionException;
import com.org.salonBooking.common.exception.ResourceNotFoundException;
import com.org.salonBooking.common.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.function.Predicate;

/**
 * Abstract base service implementation providing common CRUD operations.
 *
 * @param <T>  the entity type
 * @param <ID> the type of the entity's identifier
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    /**
     * Gets the JPA repository for the specific entity.
     *
     * @return the JPA repository
     */
    protected abstract JpaRepository<T, ID> getRepository();

    /**
     * Gets the entity name for use in exception messages.
     *
     * @return the entity name
     */
    protected abstract String getEntityName();

    /**
     * Finds an entity by its ID.
     *
     * @param id the ID of the entity to find
     * @return the found entity
     * @throws ResourceNotFoundException if no entity with the given ID is found
     */
    @Override
    public T findById(ID id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getEntityName(), "id", id));
    }

    /**
     * Finds all entities with pagination support.
     *
     * @param pageable the pagination information
     * @return a paginated list of all entities
     */
    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    /**
     * Creates a new entity in the repository.
     *
     * @param entity the entity to create
     * @return the created entity
     */
    @Override
    public T create(T entity) {
        return getRepository().save(entity);
    }

    /**
     * Updates an existing entity with the specified ID.
     *
     * @param id     the ID of the entity to update
     * @param entity the entity with updated information
     * @return the updated entity
     * @throws ResourceNotFoundException if no entity with the given ID is found
     */
    @Override
    public T update(ID id, T entity) {
        ensureResourceExists(id);
        return null;
    }

    /**
     * Deletes an entity by its ID.
     *
     * @param id the ID of the entity to delete
     * @throws ResourceNotFoundException if no entity with the given ID is found
     */
    @Override
    public void delete(ID id) {
        ensureResourceExists(id);
        getRepository().deleteById(id);
    }

    /**
     * Ensures that a resource with the specified ID exists in the repository.
     *
     * @param id the ID of the resource to check
     * @throws ResourceNotFoundException if no resource with the given ID is found
     */
    private void ensureResourceExists(ID id) {
        if (!getRepository().existsById(id)) {
            throw new ResourceNotFoundException(getEntityName(), "id", id);
        }
    }

    /**
     * Deletes an entity with a related records check. If related records exist, deletion is prevented.
     *
     * @param id                the ID of the entity to delete
     * @param hasRelatedRecords a predicate to check if the entity has related records
     * @throws EntityDeletionException if related records are found and deletion is not allowed
     */
    protected void deleteEntityWithCheck(ID id, Predicate<T> hasRelatedRecords) {
        T entity = findById(id);
        if (hasRelatedRecords.test(entity)) {
            throw new EntityDeletionException(getEntityName(), "related records");
        }
        delete(id);
    }
}
