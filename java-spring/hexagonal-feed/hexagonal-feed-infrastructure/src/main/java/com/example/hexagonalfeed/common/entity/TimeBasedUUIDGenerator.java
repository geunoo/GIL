package com.example.hexagonalfeed.common.entity;

import com.fasterxml.uuid.Generators;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class TimeBasedUUIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return Generators.timeBasedGenerator().generate();
    }
}
