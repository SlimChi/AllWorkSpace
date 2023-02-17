package fr.cs.sdbmhibernateapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NamedQuery(name = "continent.getAll",
        query = "SELECT c FROM ContinentEntity c ORDER BY c.idContinent")
@Table(name = "CONTINENT", schema = "dbo", catalog = "SDBM")
public class ContinentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CONTINENT")
    private int idContinent;
    @Basic
    @Column(name = "NOM_CONTINENT")
    private String nomContinent;

    @OneToMany(fetch =FetchType.LAZY)
    @JoinColumn(name = "ID_CONTINENT")
    private List<PaysEntity> countries;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentEntity that = (ContinentEntity) o;

        if (idContinent != that.idContinent) return false;
        if (nomContinent != null ? !nomContinent.equals(that.nomContinent) : that.nomContinent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idContinent;
        result = 31 * result + (nomContinent != null ? nomContinent.hashCode() : 0);
        return result;
    }
}
