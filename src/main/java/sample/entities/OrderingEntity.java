package sample.entities;

import javax.persistence.*;

@Entity
@Table(name = "ordering", schema = "maindb", catalog = "")
public class OrderingEntity {
    private int id;
    private Integer price;
    private FactoryEntity factoryByIdFactory;
    private ProductEntity productByIdProduct;
    private TransportOperatorEntity transportOperatorByIdTransport;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderingEntity that = (OrderingEntity) o;

        if (id != that.id) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_factory", referencedColumnName = "id")
    public FactoryEntity getFactoryByIdFactory() {
        return factoryByIdFactory;
    }

    public void setFactoryByIdFactory(FactoryEntity factoryByIdFactory) {
        this.factoryByIdFactory = factoryByIdFactory;
    }

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    public ProductEntity getProductByIdProduct() {
        return productByIdProduct;
    }

    public void setProductByIdProduct(ProductEntity productByIdProduct) {
        this.productByIdProduct = productByIdProduct;
    }

    @ManyToOne
    @JoinColumn(name = "id_transport", referencedColumnName = "id")
    public TransportOperatorEntity getTransportOperatorByIdTransport() {
        return transportOperatorByIdTransport;
    }

    public void setTransportOperatorByIdTransport(TransportOperatorEntity transportOperatorByIdTransport) {
        this.transportOperatorByIdTransport = transportOperatorByIdTransport;
    }
}
