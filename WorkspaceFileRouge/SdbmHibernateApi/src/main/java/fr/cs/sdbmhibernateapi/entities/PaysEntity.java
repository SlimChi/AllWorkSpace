package fr.cs.sdbmhibernateapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "pays.getAll",
        query = "SELECT p FROM PaysEntity p ORDER BY p.idPays")
@Table(name = "PAYS", schema = "dbo", catalog = "SDBM")
public class PaysEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PAYS")
    private int idPays;
    @Basic
    @Column(name = "NOM_PAYS")
    private String nomPays;

    @ManyToOne
    @JoinColumn(name = "ID_CONTINENT")
    private ContinentEntity continent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaysEntity that = (PaysEntity) o;

        if (idPays != that.idPays) return false;
        if (nomPays != null ? !nomPays.equals(that.nomPays) : that.nomPays != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPays;
        result = 31 * result + (nomPays != null ? nomPays.hashCode() : 0);
        return result;
    }
}
