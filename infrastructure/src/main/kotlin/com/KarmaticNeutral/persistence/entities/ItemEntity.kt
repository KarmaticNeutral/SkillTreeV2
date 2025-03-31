package com.KarmaticNeutral.persistence.entities

import java.sql.Timestamp

class ItemEntity(id: Long, name: String, weight: Float, value: Float, rarity: String,
				 createdBy: Long, createdAt: Timestamp, updatedBy: Long, updatedAt: Timestamp, isDeleted: Boolean, deletedBy: Long?, deletedAt: Timestamp?)
	: AuditableTimestampEntity(createdBy, createdAt, updatedBy, updatedAt, isDeleted, deletedBy, deletedAt) {
	private var _id: Long = id
	var Id: Long
		get() = _id
		set(value) { _id = value }

	private var _name: String = name
	var Name: String
		get() = _name
		set(value) { _name = value }

	private var _weight: Float = weight
	var Weight: Float
		get() = _weight
		set(value) { _weight = value }

	private var _value: Float = value
	var Value: Float
		get() = _value
		set(value) { _value = value }

	private var _rarity: String = rarity
	var Rarity: String
		get() = _rarity
		set(value) { _rarity = value }
}
