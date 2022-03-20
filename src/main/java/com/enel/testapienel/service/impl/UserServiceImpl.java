package com.enel.testapienel.service.impl;

import com.enel.testapienel.model.Useru;
import com.enel.testapienel.repo.IGenericRepo;
import com.enel.testapienel.repo.IUserRepo;
import com.enel.testapienel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CRUDImpl<Useru, Integer> implements IUserService {

    @Autowired
    private IUserRepo repo;

    @Override
    protected IGenericRepo<Useru, Integer> getRepo() {
        return repo;
    }

}
