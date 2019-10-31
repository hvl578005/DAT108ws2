package no.hvl.dat108;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3", name = "Deltager")
public class Deltager {

	private String fornavn;
	private String etternavn;

	@Id
	private String mobil;

	private String passordhash;
	private String passordsalt;
	private String kjonn;

	public Deltager(String fornavn, String etternavn, String mobil, String passordhash, String passordsalt,
			String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passordhash = passordhash;
		this.passordsalt = passordsalt;
		this.kjonn = kjonn;
	}

	public Deltager() {

	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPassordhash() {
		return passordhash;
	}

	public void setPassordhash(String passordhash) {
		this.passordhash = passordhash;
	}

	public String getPassordsalt() {
		return passordsalt;
	}

	public void setPassordsalt(String passordsalt) {
		this.passordsalt = passordsalt;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

}
