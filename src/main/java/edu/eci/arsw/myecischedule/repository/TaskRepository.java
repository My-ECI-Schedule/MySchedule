package edu.eci.arsw.myecischedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.myecischedule.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
    
}