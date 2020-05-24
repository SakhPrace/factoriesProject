package sample.entities;

import javax.persistence.*;

@Entity
@Table(name = "factory", schema = "public", catalog = "postgres")
public class FactoryEntity {
    private int id;
    private String name;
    private Integer exportid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "exportid", nullable = true)
    public Integer getExportid() {
        return exportid;
    }

    public void setExportid(Integer exportid) {
        this.exportid = exportid;
    }

    public FactoryEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FactoryEntity that = (FactoryEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (exportid != null ? !exportid.equals(that.exportid) : that.exportid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (exportid != null ? exportid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
