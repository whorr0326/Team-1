package com.station.view;

import java.util.Scanner;

import com.station.controller.StationController;
import com.station.controller.UserController;
import com.station.model.vo.User;

public class UserMenu {
	private UserController uc = new UserController();
	private StationController stc = new StationController();
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		try {
			StringBuffer menu = new StringBuffer();
			menu.append("====== 주유소 / 충전소 검색 프로그램 ======\n");
			menu.append("1. 로그인\n");
			menu.append("2. 회원가입\n");
			menu.append("9. 프로그램 종료\n");
			menu.append(">> 메뉴를 고르세요 : ");

			while (true) {
				System.out.print(menu);
				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1:
					Login();
					break;
				case 2:
					createUser();
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못 입력하였습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userMenu() {
		try {
			StringBuffer menu = new StringBuffer();
			menu.append("============= 마이 페이지 =============\n");
			menu.append("1. 주유소 검색\n");
			menu.append("2. 충전소 검색\n");
			menu.append("3. 지역 별 최저가 / 평균가 검색\n");
			menu.append("4. 즐겨찾기 목록\n");
			menu.append("5. 로그아웃\n");
			menu.append(">> 메뉴를 고르세요 : ");

			while (true) {
				System.out.print(menu);
				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1: // 주유소 검색
					searchStation();
					// 지역명으로 검색(ex. 강남 -> 강남 주유소 주르륵)
					// 주유소명 검색(ex. 한강 -> %한강% 주유소 주르륵)
					// 최저가로 검색
					break;
				case 2: // 충전소 검색
					searchCharger();
					// 지역명으로 검색
					// 충전소명 검색
					break;
				case 3: // 지역별 유류 최저 / 평균가 조회
					topTen();
					// 평균가 조회 메뉴
					// 최저가 조회 메뉴
					break;
				case 4: // 즐겨찾기 목록(즐겨찾기 추가 기능)
					bookmark();
					// 충전소 즐겨찾기
					// 주유소 즐겨찾기
					break;
				case 5: // 로그아웃
					return;
				default:
					System.out.println("잘못 입력하였습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원가입
	private void createUser() {
		try {
			while (true) {
				System.out.print("아이디 : ");
				String userId = sc.nextLine();
				System.out.print("비밀번호 : ");
				String userPw = sc.nextLine();
				System.out.print("이름 : ");
				String userNm = sc.nextLine();
				System.out.print("전화번호 : ");
				String userPhone = sc.nextLine();
				System.out.print("이메일 : ");
				String userEmail = sc.nextLine();
				System.out.print("차종 : ");
				String carType = sc.nextLine();

				User user = new User(userId, userPw, userNm, userPhone, userEmail, carType);
				boolean isCreate = uc.createUser(userId, user);

				if (isCreate == true) {
					System.out.println("성공적으로 회원가입 완료하였습니다.");
					break;
				} else {
					System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 로그인
	private void Login() {
		try {
			while (true) {
				System.out.print("아이디 : ");
				String id = sc.nextLine();
				System.out.print("비밀번호 : ");
				String pw = sc.nextLine();
				uc.login(id, pw);
				if (uc.login(id, pw) == null) {
					System.out.println("아이디 또는 비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
					return;
				} else {
					System.out.println(uc.login(id, pw) + "님, 환영합니다.");
					break;
				}
			}
			userMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchStation() {
		try {
			StringBuffer menu = new StringBuffer();
			menu.append("============= 주유소 검색 =============\n");
			menu.append("1. 지역명으로 검색\n");
			menu.append("2. 지점명으로 검색\n");
			menu.append("3. 돌아가기\n");
			menu.append(">> 메뉴를 고르세요 : ");

			while (true) {
				System.out.print(menu);
				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1: // 지역명으로 검색
					break;
				case 2: // 상호로 검색
					System.out.print("상호를 입력하세요 : ");
					String stationId = sc.nextLine();
					System.out.println(stc.searchByStationId(stationId));
					break;
				case 3: // 돌아가기
					return;
				default:
					System.out.println("잘못 입력하였습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchCharger() {
		StringBuffer menu = new StringBuffer();
		menu.append("============= 충전소 검색 =============\n");
		menu.append("1. 지역명으로 검색\n");
		menu.append("2. 지점명으로 검색\n");
		menu.append("3. 돌아가기\n");
		menu.append(">> 메뉴를 고르세요 : ");

		while (true) {
			System.out.print(menu);
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1: // 지역명으로 검색
				break;
			case 2: // 지점명으로 검색
				break;
			case 3: // 돌아가기
				return;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}

	public void topTen() {
		StringBuffer menu = new StringBuffer();
		menu.append("========== 평균 / 최저가 조회 ==========\n");
		menu.append("1. 지역별 평균가 조회\n");
		menu.append("2. 지역별 최저가 조회\n");
		menu.append("3. 돌아가기\n");
		menu.append(">> 메뉴를 고르세요 : ");

		while (true) {
			System.out.print(menu);
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1: // 평균가 조회
				break;
			case 2: // 최저가 조회
				break;
			case 3: // 돌아가기
				return;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}

	public void bookmark() {
		StringBuffer menu = new StringBuffer();
		menu.append("============ 즐겨찾기 목록 ============\n");
		menu.append("1. 즐겨찾는 주유소\n");
		menu.append("2. 즐겨찾는 충전소\n");
		menu.append("3. 돌아가기\n");
		menu.append(">> 메뉴를 고르세요 : ");

		while (true) {
			System.out.print(menu);
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1: // 즐겨찾는 주유소
				break;
			case 2: // 즐겨찾는 충전소
				break;
			case 3: // 돌아가기
				return;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}
}
