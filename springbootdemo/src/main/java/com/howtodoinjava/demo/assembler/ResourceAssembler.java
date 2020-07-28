package com.howtodoinjava.demo.assembler;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.howtodoinjava.demo.dao.entity.BaseEntity;

public abstract class ResourceAssembler<E,R> {
	
	/*@SuppressWarnings("WeakerAccess")
    protected static Audit getAudit(BaseEntity entity) {
        Audit audit = new Audit();

        // Set the Audit Timestamps.
        if (entity.getCreatedDate() != null) {
            audit.setCreationTimestamp(entity.getCreatedDate().getTime());
        }
        if (entity.getUpdatedDate() != null) {
            audit.setLastUpdateTimestamp(entity.getUpdatedDate().getTime());
        }

        // Set the Users
        audit.setCreationUser(entity.getCreatedBy());
        audit.setLastUpdateUser(entity.getUpdatedBy());

        // Return the Audit
        return audit;
    }
*/
   /* *//**
     * Utility method to retrieve the {@link Security} from a {@link BaseEntity}.
     *
     * @param baseEntity The {@link BaseEntity} for which the {@link Security} is to be retrieved.
     * @return The {@link Security} for the {@link BaseEntity}.
     *//*
    @SuppressWarnings("WeakerAccess")
    protected static Security getSecurity(BaseEntity baseEntity) {
        Security security = new Security();
        security.setEncryptAtRest(baseEntity.isEncryptAtRest());
        security.setEncryptInTransit(baseEntity.isEncryptInTransit());
        security.setDigitalSignature(baseEntity.isDigitalSignature());
        return security;
    }

    *//**
     * To be implemented by the actual assembler to convert the entity to it's resource representation.
     *
     * @param entity Entity to be translated.
     * @return The Resource representation of the entity.
     */
    public abstract R toResource(E entity);

    /**
     * Converts a List of Entities into their respective Resource representation.
     *
     * @param entities The Entities to be assembled.
     * @return The Resource representation of the entities.
     */
    public List<R> toResources(List<E> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        } else {
            return entities.stream()
                    .filter(Objects::nonNull)
                    .map(this::toResource)
                    .collect(Collectors.toList());
        }
    }

}
