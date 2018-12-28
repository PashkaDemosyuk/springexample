package models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Project")
public class
Project {

    public Project(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "begin_date", nullable = false)
    private Date beginDate;

    @Column(name = "customer", nullable = false)
    private String customer;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectmanager_id")
    private ProjectManager projectManager;

    @Autowired
    public Project(long id,Date beginDate, Date endDate, ProjectManager projectManager, String customer) {
        if (this.endDate != null && this.endDate.after(this.beginDate)) {
            this.id = id;
            this.beginDate = beginDate;
            this.endDate = endDate;
            this.projectManager = projectManager;
            this.customer = customer;
        }
    }

    public void init(){
        System.out.println("Init Project, id: " + this.id);
    }

    public void destroy(){
        System.out.println("Destroy Project, id: " + this.id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public AbstractUser getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }
}
