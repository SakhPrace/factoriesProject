package sample.entities;

import javax.persistence.*;

@Embeddable
//@Entity
@Table(name = "factory_product", schema = "maindb", catalog = "")
public class FactoryProductEntity {
    private FactoryEntity factoryByFactoryId;

    @ManyToOne
    @JoinColumn(name = "factory_id", referencedColumnName = "id", nullable = false)
    public FactoryEntity getFactoryByFactoryId() {
        return factoryByFactoryId;
    }

    public void setFactoryByFactoryId(FactoryEntity factoryByFactoryId) {
        this.factoryByFactoryId = factoryByFactoryId;
    }
}
