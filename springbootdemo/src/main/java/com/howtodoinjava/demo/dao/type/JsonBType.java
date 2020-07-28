package com.howtodoinjava.demo.dao.type;

import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

/**
 * Base {@link UserType} for JSONB in Postgres.
 */
abstract class JsonBType implements UserType {

    /**
     * Array of {@link java.sql.Types} to be returned for the {@link #sqlTypes()} method.
     */
    private static final int[] SQL_TYPES = new int[]{Types.JAVA_OBJECT};

    /**
     * The {@link ObjectMapper} to be used to serialize and deserialize the Objects.
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Configure the {@code {@link #OBJECT_MAPPER} to not fail on Unknown Properties.
     */
    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x == y || !((x == null) || (y == null)) && x.equals(y);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
            throws HibernateException, SQLException {
        String value = rs.getString(names[0]);
        if (value == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(value, returnedClass());
        } catch (IOException e) {
            throw new HibernateException(e);
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
            throws HibernateException, SQLException {
       /* if (value == null) {
            st.setNull(index, Types.OTHER);
        } else {
            try {
                MySQLobject object = new PGobject();
                object.setType("jsonb");
                object.setValue(OBJECT_MAPPER.writeValueAsString(value));
               // st.setObject(index, object);
           // } catch (JsonProcessingException e) {
            //    throw new HibernateException(e);
           // }
       // }
*/    }

    /**
     * {@inheritDoc}.
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object deepCopy(Object value) throws HibernateException {
        try {
            String json = OBJECT_MAPPER.writeValueAsString(value);
            return OBJECT_MAPPER.readValue(json, returnedClass());
        } catch (IOException e) {
            throw new HibernateException(e);
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean isMutable() {
        return true;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) deepCopy(value);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return deepCopy(cached);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return deepCopy(original);
    }
}

