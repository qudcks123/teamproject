package 개인프로젝트;

public class 좌석총가격 extends 예매정보{
	@Override
	public int 숫자() {
		int 가격 = 0;
		for(int i = 0; i<30; i++) {
		if(v[i].contains("예약번호"))
			가격+=180000;
		if(s[i].contains("예약번호"))
			가격+=150000;
		if(a[i].contains("예약번호"))
			가격+=120000;
		if(b[i].contains("예약번호"))
			가격+=100000;
	}
		return 가격;
	}
}
