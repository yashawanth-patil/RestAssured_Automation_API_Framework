package ExcelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			dataDriven d = new dataDriven();
			ArrayList<?> aa = d.getData("Delete_profile","testdata");
			
		System.out.println(aa.get(0));
		System.out.println(aa.get(1));
		System.out.println(aa.get(2));
		System.out.println(aa.get(3));
		
	}

}
