package no.hvl.dat108;

import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.openjpa.jdbc.sql.Select;

@Stateless
public class DeltagerEAO {

	@PersistenceContext(name = "DeltagerPU")
	private EntityManager em;

	public DeltagerEAO() {

	}

	public void leggTil(Deltager d) {
		em.persist(d);
	}

	@SuppressWarnings("unchecked")
	public List<Deltager> hentUtAlleDeltagerene() {
		return em.createQuery("SELECT d FROM Deltager d", Deltager.class).getResultList();
	}

	public Deltager finnDeltagerMedID(String mobil) {
		Deltager deltager;
		deltager = em.find(Deltager.class, mobil);
		return deltager;
	}

	public boolean eksisterendeMobil(String mobil) {

		Deltager d;
		d = em.find(Deltager.class, mobil);
		return d != null;
	}

}
