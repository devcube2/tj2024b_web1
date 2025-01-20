package day03.task2;

public class WaitingDto {
	private String telNo;
	private int count;
	
	public WaitingDto() {}
	
	public WaitingDto(String telNo, int count) {
		super();
		this.telNo = telNo;
		this.count = count;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "WaitingDto [telNo=" + telNo + ", count=" + count + "]";
	}	
}
