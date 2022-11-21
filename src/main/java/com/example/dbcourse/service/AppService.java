package com.example.dbcourse.service;

import com.example.dbcourse.dao.*;
import com.example.dbcourse.model.*;
import com.example.dbcourse.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppService {

    @Autowired
    CountryDao countryDao;
    @Autowired
    UserDao userDao;
    @Autowired
    DoctorDao doctorDao;
    @Autowired
    PublicServantDao publicServantDao;
    @Autowired
    DiseaseTypeDao diseaseTypeDao;
    @Autowired
    DiseaseDao diseaseDao;
    @Autowired
    RecordDao recordDao;

    @Transactional
    public void saveUser(User user) {
        Country country = countryDao.getWithName(user.getCountry().getCname());
        user.setCountry(country);
        userDao.save(user);
    }

    @Transactional
    public void saveDoctor(Doctor doctor) {
        Country country = countryDao.getWithName(doctor.getUser().getCountry().getCname());
        doctor.getUser().setCountry(country);
        doctor.getUser().setEmail(doctor.getEmail());
        doctorDao.save(doctor);
    }

    @Transactional
    public void savePublicServant(PublicServant publicServant) {
        Country country = countryDao.getWithName(publicServant.getUser().getCountry().getCname());
        publicServant.getUser().setCountry(country);
        publicServant.getUser().setEmail(publicServant.getEmail());
        publicServantDao.save(publicServant);
    }

    @Transactional
    public void saveDisease(Disease disease) {
        DiseaseType diseaseType = diseaseTypeDao.getWithDescription(disease.getType().getDescription());
        disease.setType(diseaseType);
        diseaseDao.save(disease);
    }

    @Transactional
    public void saveRecord(Record record) {
        User user = userDao.getWithEmail(record.getRecordId().getUser().getEmail());
        Country country = countryDao.getWithName(record.getRecordId().getCountry().getCname());
        Disease disease = diseaseDao.getWithCode(record.getRecordId().getDisease().getCode());
        record.getRecordId().setUser(user);
        record.getRecordId().setCountry(country);
        record.getRecordId().setDisease(disease);
        recordDao.save(record);
    }
}
