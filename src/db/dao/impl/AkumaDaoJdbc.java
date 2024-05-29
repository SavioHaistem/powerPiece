package db.dao.impl;

import db.dao.AkumaDao;
import entities.akumanomis.*;
import enums.AkumasType;
import exceptions.DbException;

import java.sql.Connection;
import java.util.List;

public class AkumaDaoJdbc implements AkumaDao {
    Connection connection = null;
    public AkumaDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(AkumaNoMi akumaNoMi) {

    }

    @Override
    public void remove(AkumaNoMi akumaNoMi) {

    }

    @Override
    public AkumaNoMi findById(Integer id) {
        return null;
    }

    @Override
    public List<AkumaNoMi> findAll() {
        return List.of();
    }

    @Override
    public List<AkumaNoMi> findByType(AkumasType type) {
        return List.of();
    }

    public AkumaNoMi instantiateAkuma(AkumaNoMi akuma) {
        return switch (akuma.getType()) {
            case PARAMECIA -> new Paramecia(akuma.getName(), akuma.getId());
            case ZOAN -> new Zoan(akuma.getName(), akuma.getId());
            case LOGIA -> new Logia(akuma.getName(), akuma.getId());
            case SMILE -> new Smile(akuma.getName(), akuma.getId());
            case null, default -> throw new DbException("No valid AkumaNoMi type in instantiateAkuma");
        };
    }
}
