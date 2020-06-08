package sample.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "transporter", schema = "maindb", catalog = "")
public class TransporterEntity {
    private Integer id;
    private String name;
    private Integer pricePerUnit;
    private String password;

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

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransporterEntity that = (TransporterEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pricePerUnit != null ? !pricePerUnit.equals(that.pricePerUnit) : that.pricePerUnit != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pricePerUnit != null ? pricePerUnit.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "transporter")
    private Set<OrderingEntity> orderings;

    public Set<OrderingEntity> getOrderingsById(){
        return orderings;
    };
    public void setOrderingsById(Set<OrderingEntity>orderings){
        this.orderings=orderings;
    }
}
