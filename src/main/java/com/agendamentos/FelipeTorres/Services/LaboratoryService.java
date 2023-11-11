package com.agendamentos.FelipeTorres.Services;

import com.agendamentos.FelipeTorres.Models.Laboratory;
import com.agendamentos.FelipeTorres.Repositories.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    /**
     * Method for save or update Laboratory.
     */
    public void saveLaboratory(Laboratory laboratory)
    {
        laboratoryRepository.save(laboratory);
    }

    /**
     * Method to list all laboratory records.
     *
     * @return List<Laboratory>
     */
    public List<Laboratory> listAll()
    {
        return laboratoryRepository.findAll();
    }

    /**
     * Method to get a laboratory record.
     *
     * @return Laboratory
     */
    public Laboratory getLaboratory(int id)
    {
        return laboratoryRepository.findById(id).get();
    }

    /**
     * Method for delete a laboratory record.
     */
    public void deleteLaboratory(Laboratory laboratory)
    {
        laboratoryRepository.delete(laboratory);
    }
}

