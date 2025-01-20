package day03.task4;

public class WaitingDto {
	private int no;
	private String telNo;
	private int count;
	
	public WaitingDto() {}
	
	public WaitingDto(int no, String telNo, int count) {		
		this.no = no;
		this.telNo = telNo;
		this.count = count;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
		return "WaitingDto [no=" + no + ", telNo=" + telNo + ", count=" + count + "]";
	}		
}
