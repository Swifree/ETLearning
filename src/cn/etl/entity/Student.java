package cn.etl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student extends BaseDomain{
	@Id
	private String sId;
	private String password;
}
