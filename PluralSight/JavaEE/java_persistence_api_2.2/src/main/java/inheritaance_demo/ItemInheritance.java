package inheritaance_demo;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemInheritance {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length= 100)
    protected String title;

    @Column(length = 3000)
    protected String description;

    @Column(name = "unit_cost")
    protected Float unitCost;

    public ItemInheritance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }
}
