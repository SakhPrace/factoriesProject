package sample.entities;

import javax.persistence.*;

@Entity
@Table(name = "factory_product", schema = "maindb", catalog = "")
public class FactoryProductEntity {
    private int factoryId;
    private FactoryEntity factoryByFactoryId;
    private ProductEntity productByProductId;

    @Id
    @Column(name = "factory_id", nullable = false)
    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FactoryProductEntity that = (FactoryProductEntity) o;

        if (factoryId != that.factoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return factoryId;
    }

    @OneToOne
    @JoinColumn(name = "factory_id", referencedColumnName = "id", nullable = false)
    public FactoryEntity getFactoryByFactoryId() {
        return factoryByFactoryId;
    }

    public void setFactoryByFactoryId(FactoryEntity factoryByFactoryId) {
        this.factoryByFactoryId = factoryByFactoryId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }
}
