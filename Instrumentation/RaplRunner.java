import JWrapper.*;



public class RaplRunner {


	//public void measure(String name, String method, String output, String init, String test)throws FileNotFoundException{
	public void measure(String name, String method, String output)throws FileNotFoundException{

	int repeats = 10;
	EnergyWrapper.init();
	Main m = null;
	for(int i=0; i<repeats;i++){
		m = new Main();

		//redirect system.in 
		//System.setIn(new FileInputStream(test));

		/** Call your main class and run here**/

		
		System.gc();

	}

		EnergyWrapper.dealloc();
		EnergyWrapper.printTestRunsSPELL(output);
		//EnergyWrapper.printTestRunsTotal(output);
		

	}
	

	public static void main(String[] args) throws Exception{

		RaplRunner raplRunner = new RaplRunner();
		//raplRunner.measure(args[0],args[1],args[2],args[3],args[4]);
		raplRunner.measure(args[0],args[1],args[2]);

	}
}

