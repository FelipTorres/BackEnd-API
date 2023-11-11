package com.agendamentos.FelipeTorres.Repositories;

import com.agendamentos.FelipeTorres.Models.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Integer> {

    //
}
