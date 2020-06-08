package sample.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product", schema = "maindb", catalog = "")
public class ProductEntity {
    private Integer id;
    private String name;
    private Integer pricePerUnit;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pricePerUnit != null ? !pricePerUnit.equals(that.pricePerUnit) : that.pricePerUnit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pricePerUnit != null ? pricePerUnit.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<FactoryEntity>factories;

    public Set<FactoryEntity> getFactoriesById(){
        return factories;
    };
     public void setFactoriesById(Set<FactoryEntity>factories){
         this.factories=factories;
     }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<OrderingEntity> orderings;

    public Set<OrderingEntity> getOrderingsById(){
        return orderings;
    };
    public void setOrderingsById(Set<OrderingEntity>orderings){
        this.orderings=orderings;
    }
}
