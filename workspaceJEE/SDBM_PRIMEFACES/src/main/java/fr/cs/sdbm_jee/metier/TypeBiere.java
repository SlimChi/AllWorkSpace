package fr.cs.sdbm_jee.metier;

import java.util.Objects;

public class TypeBiere
{
    private int id;
    private String libelle;
    
    public TypeBiere(int id, String libelle)
    {
	this.id = id;
	this.libelle = libelle;
    }
    public TypeBiere()
	{
		
	}
	public Integer getId()
    {
	return id;
    }
    @Override
    public String toString()
    {
	return libelle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeBiere typeBiere = (TypeBiere) o;
        return id == typeBiere.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}