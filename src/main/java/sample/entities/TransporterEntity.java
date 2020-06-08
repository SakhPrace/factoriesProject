package sample.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "transporter", schema = "maindb", catalog = "")
public class TransporterEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price_per_unit", nullable = true)
    private int pricePerUnit;

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;

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
        return id == that.id &&
                pricePerUnit == that.pricePerUnit &&
                name.equals(that.name) &&
                password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pricePerUnit, password);
    }

    /*
    @OneToMany(targetEntity=OrderingEntity.class, fetch = FetchType.EAGER, mappedBy = "transporter")
    private Set<OrderingEntity> orderings;

    public Set<OrderingEntity> getOrderingsById(){
        return orderings;
    };

    public void setOrderingsById(Set<OrderingEntity>orderings){
        this.orderings=orderings;
    }

 */
}
