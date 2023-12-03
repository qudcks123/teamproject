import java.util.Scanner; //import문 선언
public class ChangeMoney {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //scanner 객체 생성
		int i; //변수 i 생성
		int[] unit = {50000,10000,5000,1000,500,100,50,10,1}; //cash unit
		int count [] = new int[unit.length]; //원소가 7개인 배열 생성, 인덱스는 0~6까지 가능

		System.out.print("input price(won):"); //입력값을 물어보는 질문출력
		int money = scanner.nextInt(); //입력값 저장
		System.out.println(); // 결과값을 출력하기 전 한 줄 띄움
		for(i=0;i<count.length;i++)//for문을 실행할때마다 i=1씩증가(i=0~8까지 9번실행)
		{
			count[i] = money/unit[i]; //unit배열에 해당하는 원소값의 몫을 count배열에 저장
			money = money - count[i] * unit[i];
			//남은 입력값은 count배열의 원소값과 unit배열의 원소값의 곱을 빼고 다음 i값에 넘김
		}
		for (i=0;i< unit.length;i++)//for문을 실행할때마다 i=1씩증가(i=0~8까지 9번실행)
			{
			if(count[i]!=0) //count 배열의 원소값이 0이 아닐 때 if문 실행
			{
		System.out.print(unit[i] + ": " + count[i]);
		//unit배열에 해당하는 몫인 count 배열의 원소값을 출력
		System.out.println();
		//결과값을 하나씩 출력할 때마다 한 줄 띄움
			}

		}
	}

}
