package com.howtodoinjava.demo.dao.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * {@link MappedSuperclass} for Plan Management.
 */
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity implements Serializable {

    public BaseEntity() {
		super();
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean isEncryptInTransit() {
		return encryptInTransit;
	}

	public void setEncryptInTransit(boolean encryptInTransit) {
		this.encryptInTransit = encryptInTransit;
	}

	public boolean isEncryptAtRest() {
		return encryptAtRest;
	}

	public void setEncryptAtRest(boolean encryptAtRest) {
		this.encryptAtRest = encryptAtRest;
	}

	public boolean isDigitalSignature() {
		return digitalSignature;
	}

	public void setDigitalSignature(boolean digitalSignature) {
		this.digitalSignature = digitalSignature;
	}

	/**
     * The Created Date for the Entity.
     */
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;

    /**
     * The User who created the Entity.
     */
    @CreatedBy
    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    /**
     * The Last Modified Date for the Entity.
     */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE", nullable = false)
    private Date updatedDate;

    /**
     * The User who last updated the Entity.
     */
    @LastModifiedBy
    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    /**
     * Flag to indicate if the Entity should be Encrypted in Transit.
     */
    @Column(name = "ENCRYPT_IN_TRANSIT", nullable = false)
    private boolean encryptInTransit;

    /**
     * Flag to indicate if the Entity should be Encrypted at Rest.
     */
    @Column(name = "ENCRYPT_AT_REST", nullable = false)
    private boolean encryptAtRest;

    /**
     * The Digital Signature for the Entity.
     */
    @Column(name = "DIGITAL_SIGNATURE", nullable = false)
    private boolean digitalSignature;
}

