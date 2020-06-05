package sample.entities;

import javax.persistence.*;

@Entity
@Table(name = "auction", schema = "maindb", catalog = "")
public class AuctionEntity {
    private int id;
    private Integer idOrder;
    private Integer offeredPrice;
    private Integer idTransporter;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_order", nullable = true)
    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "offered_price", nullable = true)
    public Integer getOfferedPrice() {
        return offeredPrice;
    }

    public void setOfferedPrice(Integer offeredPrice) {
        this.offeredPrice = offeredPrice;
    }

    @Basic
    @Column(name = "id_transporter", nullable = true)
    public Integer getIdTransporter() {
        return idTransporter;
    }

    public void setIdTransporter(Integer idTransporter) {
        this.idTransporter = idTransporter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuctionEntity that = (AuctionEntity) o;

        if (id != that.id) return false;
        if (idOrder != null ? !idOrder.equals(that.idOrder) : that.idOrder != null) return false;
        if (offeredPrice != null ? !offeredPrice.equals(that.offeredPrice) : that.offeredPrice != null) return false;
        if (idTransporter != null ? !idTransporter.equals(that.idTransporter) : that.idTransporter != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idOrder != null ? idOrder.hashCode() : 0);
        result = 31 * result + (offeredPrice != null ? offeredPrice.hashCode() : 0);
        result = 31 * result + (idTransporter != null ? idTransporter.hashCode() : 0);
        return result;
    }
}
