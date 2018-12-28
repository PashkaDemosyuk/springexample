package models;


import javax.persistence.*;

@Entity
@Table(name = "project_developers_positions")
public class ProjectDeveloperPositions {

    public ProjectDeveloperPositions(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "developer_position_id")
    private DevelopersPositions devPos;

    public ProjectDeveloperPositions(long id, Project projectManager, DevelopersPositions devPos) {
        this.project = projectManager;
        this.devPos = devPos;
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public DevelopersPositions getDevPos() {
        return devPos;
    }

    public void setDevPos(DevelopersPositions devPos) {
        this.devPos = devPos;
    }
}
