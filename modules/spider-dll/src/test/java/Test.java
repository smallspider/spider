import org.spider.dll.command.WindowsCommand;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.load("d:\\WindowsCommand.dll");
		//System.loadLibrary("F:\\visual studio 2010\\Projects\\WDll\\Debug\\WindowsCommand.dll");
		WindowsCommand c = new WindowsCommand();
		System.out.println(c.getScreenpixels(0));
		System.out.println(System.getProperty("os.name"));
		
	}

}
