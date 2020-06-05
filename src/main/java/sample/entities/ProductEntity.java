package sample.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "product", schema = "maindb", catalog = "")
public class ProductEntity {
    private int id;
    private String name;
    private Integer pricePerUnit;
    private Collection<FactoryProductEntity> factoryProductsById;
    private Collection<OrderingEntity> orderingsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price_per_unit", nullable = true)
    public Integer getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Integer pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pricePerUnit != null ? !pricePerUnit.equals(that.pricePerUnit) : that.pricePerUnit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pricePerUnit != null ? pricePerUnit.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<FactoryProductEntity> getFactoryProductsById() {
        return factoryProductsById;
    }

    public void setFactoryProductsById(Collection<FactoryProductEntity> factoryProductsById) {
        this.factoryProductsById = factoryProductsById;
    }

    @OneToMany(mappedBy = "productByIdProduct")
    public Collection<OrderingEntity> getOrderingsById() {
        return orderingsById;
    }

    public void setOrderingsById(Collection<OrderingEntity> orderingsById) {
        this.orderingsById = orderingsById;
    }
}
