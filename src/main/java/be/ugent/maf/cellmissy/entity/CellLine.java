/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author Paola
 */
@Entity
@Table(name = "cell_line")
@XmlType(namespace = "http://maf.ugent.be/beans/cellmissy")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "CellLine.findAll", query = "SELECT c FROM CellLine c"),
    @NamedQuery(name = "CellLine.findByCellLineid", query = "SELECT c FROM CellLine c WHERE c.cellLineid = :cellLineid"),
    @NamedQuery(name = "CellLine.findByGrowthMedium", query = "SELECT c FROM CellLine c WHERE c.growthMedium = :growthMedium"),
    @NamedQuery(name = "CellLine.findBySeedingTime", query = "SELECT c FROM CellLine c WHERE c.seedingTime = :seedingTime"),
    @NamedQuery(name = "CellLine.findBySeedingDensity", query = "SELECT c FROM CellLine c WHERE c.seedingDensity = :seedingDensity"),
    @NamedQuery(name = "CellLine.findAllGrowthMedia", query = "SELECT distinct c.growthMedium FROM CellLine c"),
    @NamedQuery(name = "CellLine.findAllSera", query = "SELECT distinct c.serum FROM CellLine c")})
public class CellLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cell_lineid")
    @XmlTransient
    private Long cellLineid;
    @Column(name = "seeding_time")
    @XmlAttribute
    private String seedingTime;
    @Column(name = "seeding_density")
    @Range(min = 3000, max = 90000, message = "Seeding density must be between 30000 and 90000")
    @XmlAttribute
    private Integer seedingDensity;
    @Column(name = "growth_medium")
    @XmlAttribute
    private String growthMedium;
    @Column(name = "serum")
    @XmlAttribute
    private String serum;
    @Column(name = "serum_concentration")
    @XmlAttribute
    private Double serumConcentration;
    @OneToOne(mappedBy = "cellLine")
    @XmlTransient
    private PlateCondition plateCondition;
    @JoinColumn(name = "l_cell_line_typeid", referencedColumnName = "cell_line_typeid")
    @ManyToOne(optional = false)
    @XmlElement(required = true)
    private CellLineType cellLineType;

    public CellLine() {
    }

    public CellLine(Long cellLineid) {
        this.cellLineid = cellLineid;
    }

    public CellLine(String seedingTime, Integer seedingDensity, String growthMedium, Double serumConcentration, CellLineType cellLineType, String serum) {
        this.seedingTime = seedingTime;
        this.seedingDensity = seedingDensity;
        this.growthMedium = growthMedium;
        this.serumConcentration = serumConcentration;
        this.cellLineType = cellLineType;
        this.serum = serum;
    }

    public Long getCellLineid() {
        return cellLineid;
    }

    public void setCellLineid(Long cellLineid) {
        this.cellLineid = cellLineid;
    }

    public String getGrowthMedium() {
        return growthMedium;
    }

    public void setGrowthMedium(String growthMedium) {
        this.growthMedium = growthMedium;
    }

    public String getSerum() {
        return serum;
    }

    public void setSerum(String serum) {
        this.serum = serum;
    }

    public Double getSerumConcentration() {
        return serumConcentration;
    }

    public void setSerumConcentration(Double serumConcentration) {
        this.serumConcentration = serumConcentration;
    }

    public String getSeedingTime() {
        return seedingTime;
    }

    public void setSeedingTime(String seedingTime) {
        this.seedingTime = seedingTime;
    }

    public Integer getSeedingDensity() {
        return seedingDensity;
    }

    public void setSeedingDensity(Integer seedingDensity) {
        this.seedingDensity = seedingDensity;
    }

    public CellLineType getCellLineType() {
        return cellLineType;
    }

    public void setCellLineType(CellLineType cellLineType) {
        this.cellLineType = cellLineType;
    }

    public PlateCondition getPlateCondition() {
        return plateCondition;
    }

    public void setPlateCondition(PlateCondition plateCondition) {
        this.plateCondition = plateCondition;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CellLine other = (CellLine) obj;
        return Objects.equals(this.seedingTime, other.seedingTime) && Objects.equals(this.seedingDensity, other.seedingDensity);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.seedingTime);
        hash = 97 * hash + Objects.hashCode(this.seedingDensity);
        hash = 97 * hash + Objects.hashCode(this.growthMedium);
        return hash;
    }

    @Override
    public String toString() {
        return cellLineType + ", " + seedingDensity + ", " + seedingTime + ", " + growthMedium + ", " + serumConcentration + "% " + serum;
    }
}
