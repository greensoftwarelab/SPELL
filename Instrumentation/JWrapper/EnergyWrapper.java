package JWrapper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EnergyWrapper{

	private static ArrayList<TestRun> tests;
	private static TestRun start;
	private static TestRun end;


	public static void init(){
		tests = new ArrayList<TestRun>();
		EnergyCheckUtils.init();
	}

	public static void dealloc(){
		EnergyCheckUtils.profileDealloc();
	}

	public static void addTestRun(String className, String method, int flag, double joules, double time){
		TestRun test = new TestRun(className, method, flag, joules, time);
		tests.add(test);
	}

	public static void getEnergyTotalStart(){
		double joulesCPU = EnergyCheckUtils.getEnergyStats()[1];
		double time = System.currentTimeMillis();
		TestRun test = new TestRun("t", "s", 0, joulesCPU, time);
		start = test;
	}
	public static void getEnergyTotalEnd(){
		double joulesCPU = EnergyCheckUtils.getEnergyStats()[1];
		double time = System.currentTimeMillis();
		TestRun test = new TestRun("t", "e", 1, joulesCPU, time);
		end = test;
	}

	public static void getEnergy(String className, String method, int flag){
		double joulesCPU = EnergyCheckUtils.getEnergyStats()[1];
		double time = System.currentTimeMillis();
		TestRun test = new TestRun(className, method, flag, joulesCPU, time);
		tests.add(test);
	}

	//If there are constant values
	public static void getEnergy(String className, String method, int flag, double constJ, double constT){
		double joulesCPU = EnergyCheckUtils.getEnergyStats()[1];
		double time = System.currentTimeMillis();
		TestRun test = new TestRun(className, method, flag, joulesCPU-constJ, time-constT);
		tests.add(test);
	}

	public static String printTestRuns(){
		StringBuilder sb = new StringBuilder();
		for(TestRun run : tests){
			sb.append(run.toString()+'\n');
		}
		return sb.toString();
	}

	public static void printTestRunsTotal(String output)throws FileNotFoundException{
		StringBuilder sb = new StringBuilder();
		double joulesCPU = end.getJoules() - start.getJoules();
		double time = end.getTime() - start.getTime();

		sb.append("Total Joules;"+joulesCPU+ "; Total Time;"+time+";");
			try {
			PrintWriter pw = new PrintWriter(new FileWriter(output,true));
			pw.print(sb.toString());
			pw.close();
		} catch (IOException e){}
		
	}

	public static void printTestRunsSPELL(String output)throws FileNotFoundException{
		StringBuilder sb = new StringBuilder();
		int size = tests.size();
		int quad = size/4;int i = 0;
		try{

		PrintWriter pw = new PrintWriter(new FileWriter(output,true));
		
		for (TestRun run : tests){
			pw.print(run.toStringSPELL()+'\n');
		}
		pw.close();

		} catch (IOException e){}
		
	}

	public static String printTestRunsPaired(){
		StringBuilder sb = new StringBuilder();
		int size = tests.size();
		int half = size/2;
		ArrayList<TestRun> aux = new ArrayList<TestRun>();
		TestRun t1, t2, t3;

		for(int i=0; i<size; i=i+2){
			t1 = tests.get(i);
			t2 = tests.get(i+1);

			t3 = new TestRun(t1.getClassName(),t1.getMethod(),3,t2.getJoules()-t1.getJoules(),(t2.getTime()-t1.getTime())-2000);
			aux.add(t3);
		}

		String cName = aux.get(0).getClassName();
		String mName = aux.get(0).getMethod();
		for(int i=0; i<half; i++){
			sb.append(cName+";"+mName+";"+(aux.get(i).getJoules())+";"+(aux.get(i).getTime())+";\n");
		}

		return sb.toString();
	}

	public static String printTestRunsAverages(){
		StringBuilder sb = new StringBuilder();
		int size = tests.size();
		ArrayList<TestRun> aux = new ArrayList<TestRun>();
		TestRun t1, t2, t3;

		for(int i=0; i<size; i=i+2){
			t1 = tests.get(i);
			t2 = tests.get(i+1);

			t3 = new TestRun(t1.getClassName(),t1.getMethod(),3,t2.getJoules()-t1.getJoules(),(t2.getTime()-t1.getTime())-2000);
			aux.add(t3);
		}
		Collections.sort(aux,new TestRunComparator());
		String cName = aux.get(0).getClassName();
		String mName = aux.get(0).getMethod();
		
		double joules = 0.0;
		double time = 0.0;
		//remove first two
		aux.remove(0);aux.remove(0);
		//remove last two
		aux.remove(aux.size()-1);aux.remove(aux.size()-1);
		size = aux.size();
		for(TestRun r : aux){
			joules += r.getJoules();
			time += r.getTime();
		}


		sb.append(cName+";"+mName+";"+(joules/size)+";"+(time/size)+";\n");
		return sb.toString();
	}

	public static String simpleValues(int flag){
	//0 = s 1 = mS
		StringBuilder sb = new StringBuilder();
		int size = tests.size();
		boolean found = false;
		TestRun t1, t2;
		String time = "no defined time unit";
		for(int i = 0; i<size; i++){
			t1 = tests.get(i);
			if(t1.getFlag()==0){
				for(int j = i+1; j<size && !found; j++){
					t2 = tests.get(j);
					if(t2.getFlag()==1 && t2.getClassName().equals(t1.getClassName()) && t2.getMethod().equals(t1.getMethod())){
						if(flag==0){
							time = ","+(t2.getTime()-t1.getTime())/1000+"";
						}
						else if (flag==1){
							time = ","+(t2.getTime()-t1.getTime())+"";
						}

						sb.append((t2.getJoules()-t1.getJoules())+time+"\n");
						found = true;
					}
				}

			}
			
		}
		return sb.toString();
	}

	public static String printTestRunDifference(int flag){
		//0 = s 1 = mS
		StringBuilder sb = new StringBuilder();
		int size = tests.size();
		boolean found = false;
		TestRun t1, t2;
		String time = "no defined time unit";
		for(int i = 0; i<size; i++){
			t1 = tests.get(i);
			if(t1.getFlag()==0){
				for(int j = i+1; j<size && !found; j++){
					t2 = tests.get(j);
					if(t2.getFlag()==1 && t2.getClassName().equals(t1.getClassName()) && t2.getMethod().equals(t1.getMethod())){
						if(flag==0){
							time = " Seconds: "+(t2.getTime()-t1.getTime())/1000+"";
						}
						else if (flag==1){
							time = " mSeconds: "+(t2.getTime()-t1.getTime())+"";
						}

						sb.append("Class: " +t1.getClassName()+ " Method: " +t1.getMethod()+ " Joules: " +(t2.getJoules()-t1.getJoules())+time+"\n");
						found = true;
					}
				}

			}
			
		}
		return sb.toString();
	}


}

class TestRunComparator implements Comparator<TestRun> {
    public int compare(TestRun a, TestRun b) {
        return a.getJoules() < b.getJoules() ? -1 : a.getJoules() == b.getJoules() ? 0 : 1;
    }
}