package com.KarmaticNeutral.persistence.entities

import java.sql.Timestamp

abstract class AuditableTimestampEntity(createdBy: Long, createdOn: Timestamp, updatedBy: Long, updatedOn: Timestamp, isDeleted: Boolean, deletedBy: Long?, deletedOn: Timestamp?) {
	private var _createdBy: Long = createdBy //TODO Foreign Key?
	var CreatedBy: Long
		get() = _createdBy
		set(value) { _createdBy = value }

	private var _createdOn: Timestamp = createdOn
	var CreatedOn: Timestamp
		get() = _createdOn
		set(value) { _createdOn = value }

	private var _updatedBy: Long = updatedBy //TODO Foreign Key?
	var UpdatedBy: Long
		get() = _updatedBy
		set(value) { _updatedBy = value }

	private var _updatedOn: Timestamp = updatedOn
	var UpdatedOn: Timestamp
		get() = _updatedOn
		set(value) { _updatedOn = value }

	private var _isDeleted: Boolean = isDeleted
	var IsDeleted: Boolean
		get() = _isDeleted
		set(value) { _isDeleted = value }

	private var _deletedBy: Long? = deletedBy //TODO Foreign Key?
	var DeletedBy: Long?
		get() = _deletedBy
		set(value) { _deletedBy = value }

	private var _deletedOn: Timestamp? = deletedOn
	var DeletedOn: Timestamp?
		get() = _deletedOn
		set(value) { _deletedOn = value }
}
