
public class Test{
        public static void main(String[] ar){
        final int x = 5;
        class TestInner{
        	public void classInner(){
        	class TestInner2{
        		int z = 8;
                class TestInner3{
                      int w = 90;
                }
        		TestInner2.TestInner3 in3 = new TestInner3();
        		public void show(){
                        System.out.println(in3.w);
        		}
        	}
        	new TestInner2().show();
        	}
        	int y = 4;
        	}
        new TestInner().classInner();
        }
}