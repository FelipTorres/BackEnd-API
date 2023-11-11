package com.agendamentos.FelipeTorres.Repositories;

import com.agendamentos.FelipeTorres.Models.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer> {

    //
}
