package sample.entities;

import javax.persistence.*;

@Entity
@Table(name = "ordering", schema = "maindb", catalog = "")
public class OrderingEntity {
    private Integer id;
    private Integer price;
    private Byte accepted;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "accepted", nullable = true)
    public Byte getAccepted() {
        return accepted;
    }

    public void setAccepted(Byte accepted) {
        this.accepted = accepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderingEntity that = (OrderingEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (accepted != null ? !accepted.equals(that.accepted) : that.accepted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (accepted != null ? accepted.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_factory", referencedColumnName = "id")
    private FactoryEntity factoryByIdFactory;
    public FactoryEntity getFactoryByIdFactory() {
        return factoryByIdFactory;
    }

    public void setFactoryByIdFactory(FactoryEntity factoryByIdFactory) {
        this.factoryByIdFactory = factoryByIdFactory;
    }

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_product", nullable=false)
    private ProductEntity product;

    public ProductEntity getProductById() {
        return product;
    }

    public void setProductById(ProductEntity product) {
        this.product = product;
    }

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_transporter", nullable=true)
    private TransporterEntity transporter;

    public TransporterEntity getTransporterById() {
        return transporter;
    }

    public void setTransporterById(TransporterEntity transporter) {
        this.transporter = transporter;
    }
}
        }