package com.infosys.infytel.calldetails.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.infosys.infytel.calldetails.dto.CallDetailsDTO;
import com.infosys.infytel.calldetails.dto.CallDetailsDTOO;

@Entity
@Table(name = "tb")
@SqlResultSetMapping(
		name="onecolumn",
		columns = {@ColumnResult(name="no",type=Long.class)}
		)
@SqlResultSetMapping(
		name="twocolumn",
		classes= {
				@ConstructorResult(
						targetClass=CallDetailsDTO.class,
						columns= {
								@ColumnResult(name="no",type=Long.class),
								@ColumnResult(name="duration",type=Integer.class)
						}
						)
		}
		)

	
//@SqlResultSetMapping(
//		name="count",
//		columns = {@ColumnResult(name="count(*)",type=Integer.class)}
//		)	



@SqlResultSetMapping(
		name="diffselect",
		classes= {
				@ConstructorResult(
						targetClass=CallDetailsDTO.class,
						columns= {
								@ColumnResult(name="no",type=Long.class),
								@ColumnResult(name="duration",type=Integer.class)
						}
						),
				@ConstructorResult(
						targetClass = CallDetailsDTOO.class,
				        columns= {
						@ColumnResult(name="called_by",type=Long.class),
						@ColumnResult(name="called_to",type=Long.class)
				        }
				)
				
				
		}
		)


@SqlResultSetMapping(
		name="diffselecttwo",
		classes= {
				
				@ConstructorResult(
						targetClass = CallDetails.class, 
						columns = { 
								@ColumnResult(name="no",type=Long.class),
								@ColumnResult(name="called_by",type=Long.class),
								@ColumnResult(name="called_on",type=Date.class),
								@ColumnResult(name="called_to",type=Long.class),
								@ColumnResult(name="duration",type=Integer.class)
								}
						),
				@ConstructorResult(
						targetClass = CallDetailsDTO.class, 
						columns = { 
								@ColumnResult(name="no",type=Long.class),
								@ColumnResult(name="duration",type=Integer.class)
								}
						)
				
				
		}
		)
		










@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery(name="getAll",procedureName = "spGetAll",resultClasses = {CallDetails.class}),
			@NamedStoredProcedureQuery(name = "getAllById",procedureName = "spGetAllById",
			        parameters= {
			        		@StoredProcedureParameter(mode =ParameterMode.IN ,name="i",type=Integer.class)
			        },
			        resultClasses = CallDetails.class
			),
			@NamedStoredProcedureQuery(name="getCount",procedureName = "spGetCount",
					  parameters= {
				        		@StoredProcedureParameter(mode =ParameterMode.OUT ,name="i",type=Integer.class)
				        }),
			@NamedStoredProcedureQuery(name="getTwoSelect",procedureName="spGetTwoSelect",resultClasses = CallDetails.class),
			@NamedStoredProcedureQuery(name="getOneColumn",procedureName = "spGetOneColumn",resultSetMappings={"onecolumn"}),
			@NamedStoredProcedureQuery(name="getTwoColumn",procedureName = "spGetTwoColumn",resultSetMappings ="twocolumn"),
//			@NamedStoredProcedureQuery(name="getSelectCount",procedureName="spGetSelectCount",resultSetMappings="count"),
			@NamedStoredProcedureQuery(name="getInOut",procedureName = "spGetInOut",parameters= {
					@StoredProcedureParameter(mode=ParameterMode.INOUT,name="count",type=Long.class)
			}),
			@NamedStoredProcedureQuery(name="getDiffSelect",procedureName = "spGetDiffSelect",resultSetMappings={"diffselect"}),
			@NamedStoredProcedureQuery(name="getDiffSelectTwo",procedureName = "spGetDiffSelectTwo",resultSetMappings={"diffselecttwo"})
			
		}
		)
public class CallDetails {

	@Id
	@GeneratedValue
	@Column(name = "no")
	long id;
	@Column(nullable = false)
	long calledBy;
	@Column(nullable = false)
	Date calledOn;
	@Column(nullable = false)
	long calledTo;
	@Column(nullable = false)
	int duration;

	public CallDetails() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCalledBy() {
		return calledBy;
	}

	public void setCalledBy(long calledBy) {
		this.calledBy = calledBy;
	}

	public long getCalledTo() {
		return calledTo;
	}

	public void setCalledTo(long calledTo) {
		this.calledTo = calledTo;
	}

	public Date getCalledOn() {
		return calledOn;
	}

	public void setCalledOn(Date calledOn) {
		this.calledOn = calledOn;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public CallDetails(long id, long calledBy,Date calledOn, long calledTo,  int duration) {
		super();
		this.id = id;
		this.calledBy = calledBy;
		this.calledTo = calledTo;
		this.calledOn = calledOn;
		this.duration = duration;
	}

}
