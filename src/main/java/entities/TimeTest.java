package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "TimeTest")
@Table(name = "TIME_TEST")
public class TimeTest {

	@Id
	@GeneratedValue
	@Column(name = "TIME_TEST_ID")
	private long timeTestId;

	@Column(name = "DATETIME_COLUMN")
	private Date datetimeColumn;

	@Column(name = "TIMESTAMP_COLUMN")
	private Date timestampColumn;

	@Column(name = "DATE_COLUMN")
	private java.sql.Date dateColumn;

	@Column(name = "TIME_COLUMN")
	private java.sql.Time timeColumn;

	@Column(name = "SQL_DATETIME_COLUMN")
	private java.sql.Timestamp sqlDatatimeColumn;

	@Column(name = "SQL_TIMESTAMP_COLUMN")
	private java.sql.Timestamp sqlTimestampColumn;

	@Column(name = "SQL_DATE_COLUMN")
	private java.sql.Date sqlDateColumn;

	@Column(name = "SQL_TIME_COLUMN")
	private java.sql.Time sqlTimeColumn;

	public TimeTest() {

	}

	public TimeTest(Date date) {
		datetimeColumn = date;
		timestampColumn = date;
		timeColumn = new java.sql.Time(date.getTime());
		dateColumn = new java.sql.Date(date.getTime());

		sqlDatatimeColumn = new java.sql.Timestamp(date.getTime());
		sqlTimestampColumn = new java.sql.Timestamp(date.getTime());
		sqlDateColumn = new java.sql.Date(date.getTime());
		sqlTimeColumn = new java.sql.Time(date.getTime());
	}

	public long getTimeTestId() {
		return timeTestId;
	}

	public void setTimeTestId(long timeTestId) {
		this.timeTestId = timeTestId;
	}

	public Date getDatetimeColumn() {
		return datetimeColumn;
	}

	public void setDatetimeColumn(Date datetimeColumn) {
		this.datetimeColumn = datetimeColumn;
	}

	public Date getTimestampColumn() {
		return timestampColumn;
	}

	public void setTimestampColumn(Date timestampColumn) {
		this.timestampColumn = timestampColumn;
	}

	public Date getDateColumn() {
		return dateColumn;
	}

	public void setDateColumn(java.sql.Date dateColumn) {
		this.dateColumn = dateColumn;
	}

	public Date getTimeColumn() {
		return timeColumn;
	}

	public void setTimeColumn(java.sql.Time timeColumn) {
		this.timeColumn = timeColumn;
	}

	public java.sql.Timestamp getSqlDatatimeColumn() {
		return sqlDatatimeColumn;
	}

	public void setSqlDatatimeColumn(java.sql.Timestamp sqlDatatimeColumn) {
		this.sqlDatatimeColumn = sqlDatatimeColumn;
	}

	public java.sql.Timestamp getSqlTimestampColumn() {
		return sqlTimestampColumn;
	}

	public void setSqlTimestampColumn(java.sql.Timestamp sqlTimestampColumn) {
		this.sqlTimestampColumn = sqlTimestampColumn;
	}

	public java.sql.Date getSqlDateColumn() {
		return sqlDateColumn;
	}

	public void setSqlDateColumn(java.sql.Date sqlDateColumn) {
		this.sqlDateColumn = sqlDateColumn;
	}

	public java.sql.Time getSqlTimeColumn() {
		return sqlTimeColumn;
	}

	public void setSqlTimeColumn(java.sql.Time sqlTimeColumn) {
		this.sqlTimeColumn = sqlTimeColumn;
	}

	@Override
	public String toString() {
		return "TimeTest [timeTestId=" + timeTestId + ", datetimeColumn=" + datetimeColumn + ", timestampColumn="
				+ timestampColumn + ", dateColumn=" + dateColumn + ", timeColumn=" + timeColumn + ", sqlDatatimeColumn="
				+ sqlDatatimeColumn + ", sqlTimestampColumn=" + sqlTimestampColumn + ", sqlDateColumn=" + sqlDateColumn
				+ ", sqlTimeColumn=" + sqlTimeColumn + "]";
	}

}
