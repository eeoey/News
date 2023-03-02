package com.ruoyi.system.recommend.bean;


/**
 * 
 * @author wqd
 *
 */
public class HabitsBean extends BasicBean {
	private Long id ;

	/**
	 * get the ID
	 */
	@Override
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	public HabitsBean() {
		this(-1);
	}
	

	public HabitsBean(long id) {
		this(id, 5);
	}
	
	public HabitsBean(long id, int n) {
		super(false);
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "HabitBean " + this.id + " :" + super.toString();
	}
	
}
