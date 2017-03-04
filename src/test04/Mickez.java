package test04;

public class Mickez extends Tsun {

	@Override
	public String getName() {
		return "鼠";
	}

	@Override
	public String getSkilm() {
		return "画面中央をまとめて消すよ！";
	}

	@Override
	public void printInfo() {
		super.printInfo();

	}

	@Override
	protected Integer tsunId() {
		return 38;
	}

}
