import java.util.Scanner;
public class ChangeMoney {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //scanner 객체 생성
		int i; //변수 i 생성
		int[] unit = {50000,10000,5000,1000,500,100,50,10,1}; //cash unit
		int count [] = new int[9]; //원소가 7개인 배열 생성, 인덱스는 0~6까지 가능

		System.out.print("input price(won):"); //가격을 물어보는 질문출력
		int money = scanner.nextInt(); //입력값 저장
		for(i=0;i<count.length;i++)
		{
			count[i] = money/unit[i]; //unit배열에 해당하는 원소값의 몫을 count배열에 저장
			money = money - count[i] * unit[i];
			//남은 가격은 count배열과 몫에 해당하는 값을 빼고 다음 unit 배열에 넘김
		}
		for (i=0;i< unit.length;i++) {
			if(count[i]!=0) {
		System.out.print(unit[i] + ": " + count[i]);
		System.out.println();
			}
			//unit배열에 해당하는 몫을 출력하되, 몫이 0인 출력값은 제외
		}
	}

}
