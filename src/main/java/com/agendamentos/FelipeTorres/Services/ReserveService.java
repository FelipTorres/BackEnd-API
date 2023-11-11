package com.agendamentos.FelipeTorres.Services;

import com.agendamentos.FelipeTorres.Models.Reserve;
import com.agendamentos.FelipeTorres.Repositories.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository reserveRepository;

    /**
     * Method for save or update Reserve.
     */
    public void saveReserve(Reserve reserve)
    {
        reserveRepository.save(reserve);
    }

    /**
     * Method to list all reservation records.
     *
     * @return List<Reserve>
     */
    public List<Reserve> listAll()
    {
        return reserveRepository.findAll();
    }

    /**
     * Method to get a reservation record.
     *
     * @return Reserve
     */
    public Reserve getReserve(int id)
    {
        return reserveRepository.findById(id).get();
    }

    /**
     * Method for delete a reservation record.
     */
    public void deleteReserve(Reserve reserve)
    {
        reserveRepository.delete(reserve);
    }
}