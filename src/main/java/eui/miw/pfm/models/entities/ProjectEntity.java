package eui.miw.pfm.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "projects")
public class ProjectEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; //NOPMD
    
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    public String name;

    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    public Date startDate; 

    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    public Date endDate;
    
    @Column(name = "week_num_iteration")
    private int weekNumIteration;

    @Column(name = "estimated_num_iteration")
    private float estimatedNumIteration;  //NOPMD

    @Column(name = "chosen_num_iteration")
    private int chosenNumIteration; //NOPMD 
    
    @Column(name = "description")
    private String description; //NOPMD 
 
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id")
    // NOTA: mediante el joinColumn explicitamos que el nombre de la FK de esta tabla
    //         (ProjetEntity) se llamara user_id y la PK de la tabla UserEntity a
    //         la cual hara referencia esta FK se llama id (segun el @column de UserEntity)           
    private UserEntity owner;
    
    public ProjectEntity() {
        super();
    }

    public ProjectEntity(final Integer id) {  //NOPMD
        this.id = id;
    }

    public ProjectEntity(final Integer id, final String name, final Date startDate, final Date endDate, final int weekNumIteration, final int estimatedNumIteration, final int chosenNumIteration, final String description, final UserEntity owner) {  //NOPMD
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.weekNumIteration = weekNumIteration;
        this.estimatedNumIteration = estimatedNumIteration;
        this.chosenNumIteration = chosenNumIteration;
        this.description = description;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {  //NOPMD
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }

    public int getWeekNumIteration() {
        return weekNumIteration;
    }

    public void setWeekNumIteration(final int weekNumIteration) {
        this.weekNumIteration = weekNumIteration;
    }

    public float getEstimatedNumIteration() {
        return estimatedNumIteration;
    }

    public void setEstimatedNumIteration(final int estimatedNumIteration) { //NOPMD
        this.estimatedNumIteration = estimatedNumIteration;
    }

    public int getChosenNumIteration() {
        return chosenNumIteration;
    }

    public void setChosenNumIteration(final int chosenNumIteration) { //NOPMD
        this.chosenNumIteration = chosenNumIteration;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }    

   public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(final UserEntity owner) {
        this.owner = owner;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProjectEntity other = (ProjectEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjectEntity{" + "id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", weekNumIteration=" + weekNumIteration + ", estimatedNumIteration=" + estimatedNumIteration + ", chosenNumIteration=" + chosenNumIteration + ", description=" + description + ", owner=" + owner + '}';
    }
}
