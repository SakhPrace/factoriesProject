package sample.entities;

import javax.persistence.*;

@Entity
@Table(name = "order", schema = "public", catalog = "postgres")
public class OrderingEntity {
    private int id;
    private int idFactory;
    private int idProduct;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_factory", nullable = false)
    public int getIdFactory() {
        return idFactory;
    }

    public void setIdFactory(int idFactory) {
        this.idFactory = idFactory;
    }

    @Basic
    @Column(name = "id_product", nullable = false)
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderingEntity that = (OrderingEntity) o;

        if (id != that.id) return false;
        if (idFactory != that.idFactory) return false;
        if (idProduct != that.idProduct) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idFactory;
        result = 31 * result + idProduct;
        return result;
    }
}
