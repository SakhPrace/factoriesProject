package sample.entities;

import javax.persistence.*;

@Entity
@Table(name = "auction", schema = "public", catalog = "postgres")
public class AuctionEntity {
    private int id;
    private int idOrder;
    private int price;
    private int idTransporter;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_order", nullable = false)
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "offered_price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "id_transporter", nullable = false)
    public int getIdTransporter() {
        return idTransporter;
    }

    public void setIdTransporter(int idTransporter) {
        this.idTransporter = idTransporter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuctionEntity that = (AuctionEntity) o;

        if (id != that.id) return false;
        if (idOrder != that.idOrder) return false;
        if (price != that.price) return false;
        if (idTransporter != that.idTransporter) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idOrder;
        result = 31 * result + price;
        result = 31 * result + idTransporter;
        return result;
    }
}
