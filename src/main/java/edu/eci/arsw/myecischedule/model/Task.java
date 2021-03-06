package edu.eci.arsw.myecischedule.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tasks")
public class Task implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "IdKanbanColumn", nullable = false)
    private KanbanColumn idKanbanColumn;
    @ManyToOne
    @JoinColumn(name = "IdCustomer", nullable = false)
    private Customer idCustomer;
    @Column(name = "isPublic", nullable = false)
    private boolean isPublic;
    @Column(name = "Description", nullable = false)
    private String description;

    

    public Task(KanbanColumn idKanbanColumn, Customer idCustomer, boolean isPublic, String description) {
        this.idKanbanColumn = idKanbanColumn;
        this.idCustomer = idCustomer;
        this.isPublic = isPublic;
        this.description = description;
    }

    public Task(Long id, KanbanColumn idKanbanColumn, Customer idCustomer, boolean isPublic,
            String description) {
        this.id = id;
        this.idKanbanColumn = idKanbanColumn;
        this.idCustomer = idCustomer;
        this.isPublic = isPublic;
        this.description = description;
    }

    public Task() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KanbanColumn getIdKanbanColumn() {
        return idKanbanColumn;
    }

    public void setIdKanbanColumn(KanbanColumn idKanbanColumn) {
        this.idKanbanColumn = idKanbanColumn;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "{id:"+id+",idKanbanColumn:"+(idKanbanColumn!=null?idKanbanColumn.toString():"null")+",idCustomer:"+(idCustomer!=null?idCustomer.toString():"null")+", isPublic:"+isPublic+",description:"+description+"}";
    }
    
}
