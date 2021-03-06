package edu.eci.arsw.myecischedule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.myecischedule.model.Kanban;
import edu.eci.arsw.myecischedule.model.KanbanColumn;
import edu.eci.arsw.myecischedule.repository.KanbanRepository;

@Service
public class KanbanService {
    
    @Autowired
    private KanbanRepository kanbanRepository;

    public Kanban create (Kanban kanban){
        return kanbanRepository.save(kanban);
    }

    public List<Kanban> getAllKanbans(){
        return kanbanRepository.findAll();
    }

    public void delete(Kanban kanban){
        kanbanRepository.delete(kanban);
    }

    public Optional<Kanban> findById(Long id){
        return kanbanRepository.findById(id);
    }
    public List<KanbanColumn> getKanbanColumns(Long id){
        return kanbanRepository.getKanbanColumns(id);
    }
}
