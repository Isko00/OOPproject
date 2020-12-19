package main;
public enum Statuses {
	NEW(1), ACCEPTED(2), REJECTED(3);
	
	private int code;
    Statuses(int code){
        this.code = code;
    }
    public int getCode(){ return code; }
}