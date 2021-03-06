/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Paola
 */
@Entity
@Table(name = "track")
@XmlType(namespace = "http://maf.ugent.be/beans/cellmissy")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Track.findAll", query = "SELECT t FROM Track t"),
    @NamedQuery(name = "Track.findByTrackid", query = "SELECT t FROM Track t WHERE t.trackid = :trackid"),
    @NamedQuery(name = "Track.findByTrackNumber", query = "SELECT t FROM Track t WHERE t.trackNumber = :trackNumber"),
    @NamedQuery(name = "Track.findByTrackLength", query = "SELECT t FROM Track t WHERE t.trackLength = :trackLength")})
public class Track implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trackid")
    @XmlTransient
    private Long trackid;
    @Basic(optional = false)
    @Column(name = "track_number")
    @XmlAttribute(required = true)
    private int trackNumber;
    @Basic(optional = false)
    @Column(name = "track_length")
    @XmlAttribute(required = true)
    private int trackLength;
    @JoinColumn(name = "l_well_has_imaging_typeid", referencedColumnName = "well_has_imaging_typeid")
    @ManyToOne(optional = false)
    @XmlTransient
    private WellHasImagingType wellHasImagingType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "track", orphanRemoval = true)
    @XmlElementWrapper(name = "trackPoints")
    @XmlElement(name = "trackPoint")
    private List<TrackPoint> trackPointList;

    public Track() {
    }

    public Track(Long trackid) {
        this.trackid = trackid;
    }

    public Track(Long trackid, int trackNumber) {
        this.trackid = trackid;
        this.trackNumber = trackNumber;
    }

    public Track(Long trackid, int trackNumber, int trackLength) {
        this.trackid = trackid;
        this.trackNumber = trackNumber;
        this.trackLength = trackLength;
    }

    public Long getTrackid() {
        return trackid;
    }

    public void setTrackid(Long trackid) {
        this.trackid = trackid;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    public WellHasImagingType getWellHasImagingType() {
        return wellHasImagingType;
    }

    public void setWellHasImagingType(WellHasImagingType wellHasImagingType) {
        this.wellHasImagingType = wellHasImagingType;
    }

    public List<TrackPoint> getTrackPointList() {
        return trackPointList;
    }

    public void setTrackPointList(List<TrackPoint> trackPointList) {
        this.trackPointList = trackPointList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackid != null ? trackid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Track)) {
            return false;
        }
        Track other = (Track) object;
        return !((this.trackid == null && other.trackid != null) || (this.trackid != null && !this.trackid.equals(other.trackid)));
    }

    @Override
    public String toString() {
        return "" + trackNumber;
    }
}
